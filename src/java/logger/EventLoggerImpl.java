package logger;

import com.google.gson.Gson;
import data.GsonUtils;
import eventHistory.EventHistory;
import eventHistory.EventHistoryImpl;
import event.Event;

import java.util.HashMap;
import java.util.Map;

/**
 * Implementation of the {@link EventLogger} interface.
 *
 * This class keeps track of the history of events for each agent. It uses a singleton pattern to ensure that only one
 * instance is created.
 */
public class EventLoggerImpl implements EventLogger {

    private static final String PATH = "log/";
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
        if (!history.containsKey(agentName)) {
            history.put(agentName, new EventHistoryImpl(agentName));
        }
        history.get(agentName).addEvent(event);
    }

    @Override
    public Map<String, EventHistory> getHistory() {
        return history;
    }

    @Override
    public void saveLog(String agentName) {
        history.get(agentName).saveLog();
    }
}
