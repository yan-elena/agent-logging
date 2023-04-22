package logger;

import com.google.gson.Gson;
import data.GsonUtils;
import eventHistory.EventHistory;
import eventHistory.EventHistoryImpl;
import event.Event;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

/**
 * Implementation of the {@link EventLogger} interface.
 *
 * This class keeps track of the history of events for each agent. It uses a singleton pattern to ensure that only one
 * instance is created.
 */
public class EventLoggerImpl implements EventLogger {

    public static final String PATH = "log/";
    private static EventLogger eventLogger;
    private final Map<String, EventHistory> history;
    private final Gson gson;

    private EventLoggerImpl() {
        gson = GsonUtils.createGson();
        history = new HashMap<>();
    }

    /**
     * Returns the single instance of this logger. If the instance has not yet been created, it will be created.
     * @return the instance of this logger
     */
    public static EventLogger getLogger() {
        if (eventLogger == null) {
            eventLogger = new EventLoggerImpl();
        }
        return eventLogger;
    }

    @Override
    public synchronized void publishEvent(String agentName, Event event) {
        // filter some event
//        if (!(event.toString().contains("jcm") || event.toString().contains("focus") ||
//                event.toString().contains("/main/w") || event.toString().contains("cobj_2"))) {
            if (!history.containsKey(agentName)) {
                history.put(agentName, new EventHistoryImpl());
            }
            history.get(agentName).addEvent(event);
//        }
    }

    @Override
    public Map<String, EventHistory> getHistory() {
        return history;
    }

    @Override
    public synchronized void saveAgentLogInFile(String agentName) {
        String output = String.join("\n", history.get(agentName).getHistory().stream().map(Event::toString).toList());
        try {
            PrintWriter out = new PrintWriter(PATH + agentName + ".txt");
            out.println(output);
            out.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Override
    public synchronized void saveAgentLogAsJson(String agentName) {
        try {
            PrintWriter out = new PrintWriter(PATH + agentName + ".json");
            out.println(gson.toJson(history.get(agentName).getHistory()));
            out.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Override
    public synchronized void saveLogInFile(String fileName) {
        StringBuilder output = new StringBuilder();
        history.forEach((k,v) -> output.append("[Log for ").append(k).append(" agent]\n").append(v).append("\n"));
        try {
            PrintWriter out = new PrintWriter(PATH + fileName + ".txt");
            out.println(output);
            out.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Override
    public synchronized void saveLogAsJson(String fileName) {
        try {
            PrintWriter out = new PrintWriter(PATH + fileName + ".json");
            out.println(gson.toJson(this));
            out.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
