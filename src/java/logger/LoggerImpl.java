package logger;

import agentHistory.AgentHistory;
import agentHistory.AgentHistoryImpl;
import event.Event;

import java.util.HashMap;
import java.util.Map;

public class LoggerImpl implements Logger {

    private static Logger logger;
    private final Map<String, AgentHistory> history;

    private LoggerImpl() {
        history = new HashMap<>();
    }

    public static Logger getLogger() {
        if (logger == null) {
            logger = new LoggerImpl();
        }
        return logger;
    }

    @Override
    public synchronized void insertEvent(String agentName, Event event) {
        if (!history.containsKey(agentName)) {
            history.put(agentName, new AgentHistoryImpl());
        }
        history.get(agentName).addEvent(event);
    }

    @Override
    public synchronized void printLog() {
        history.forEach((k,v) -> System.out.println("[" + k + "]" + v));
    }
}
