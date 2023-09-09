package logger.eventHistory;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import gson.GsonUtils;
import event.Event;
import logger.JsonFileHandler;
import logger.LogFormatter;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.FileHandler;
import java.util.logging.Handler;
import java.util.logging.Logger;

/**
 * Implementation of the {@link EventHistory} interface.
 *
 * This class is responsible for maintaining the history of events for a single agent.
 */
public class EventHistoryImpl implements EventHistory {

    public static final String PATH = "log/";
    private final List<Event> history;
    private final Logger logger;
    private final Gson gson;

    /**
     * Creates an instance of {@link EventHistory} for the specified agent.
     * @param agentName the name of the agent
     */
    public EventHistoryImpl(String agentName) {
        this.logger = Logger.getLogger(agentName);
        this.history = new LinkedList<>();
        this.gson = GsonUtils.createGson();

        File dir = new File(PATH);
        if (!dir.exists() && dir.isDirectory()) {
            dir.mkdir();
        }

        try {
            FileHandler fileHandler = new FileHandler(PATH + agentName + ".log");
            fileHandler.setFormatter(new LogFormatter());
            logger.addHandler(fileHandler);
            logger.addHandler(new JsonFileHandler(agentName));
            logger.setUseParentHandlers(false); // remove the console handler
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void saveLog() {
        Arrays.stream(this.logger.getHandlers()).toList().forEach(Handler::close);
    }

    @Override
    public void addEvent(Event event) {
        this.history.add(event);

        JsonObject object = new JsonObject();
        object.addProperty("type", event.getClass().getSimpleName());
        object.add("event", gson.toJsonTree(event));
        object.addProperty("log", event.logEvent());
        this.logger.info(gson.toJson(object));
    }

    @Override
    public String toString() {
        return String.join("\n", history.stream().map(Event::toString).toList());
    }
}
