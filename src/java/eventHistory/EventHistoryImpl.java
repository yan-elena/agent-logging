package eventHistory;

import com.google.gson.Gson;
import data.GsonUtils;
import event.Event;
import logger.JsonFileHandler;
import logger.LogFormatter;

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

        try {
            FileHandler fileHandler = new FileHandler(PATH + agentName + ".log");
            fileHandler.setFormatter(new LogFormatter());
            logger.addHandler(fileHandler);
            logger.addHandler(new JsonFileHandler(agentName));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void saveLog() {
        Arrays.stream(this.logger.getHandlers()).toList().forEach(Handler::close);
    }

    @Override
    public List<Event> getHistory() {
        return this.history;
    }

    @Override
    public void addEvent(Event event) {
        this.history.add(event);
        this.logger.info(gson.toJson(event));
    }

    @Override
    public String toString() {
        return String.join("\n", history.stream().map(Event::toString).toList());
    }
}
