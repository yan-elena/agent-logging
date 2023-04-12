package logger;

import eventHistory.EventHistory;
import eventHistory.EventHistoryImpl;
import event.Event;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

/**
 * Implementation of the {@link Logger} interface.
 *
 * This class keeps track of the history of events for each agent. It uses a singleton pattern to ensure that only one
 * instance is created.
 */
public class LoggerImpl implements Logger {

    private static Logger logger;
    private final Map<String, EventHistory> history;

    private LoggerImpl() {
        history = new HashMap<>();
    }

    /**
     * Returns the single instance of this logger. If the instance has not yet been created, it will be created.
     * @return the instance of this logger
     */
    public static Logger getLogger() {
        if (logger == null) {
            logger = new LoggerImpl();
        }
        return logger;
    }

    @Override
    public synchronized void publishEvent(String agentName, Event event) {
        // filter some event
        if (!(event.toString().contains("jcm") || event.toString().contains("focus") ||
                event.toString().contains("/main/w") || event.toString().contains("cobj_2"))) {
            if (!history.containsKey(agentName)) {
                history.put(agentName, new EventHistoryImpl(agentName));
            }
            history.get(agentName).addEvent(event);
        }
    }

    @Override
    public synchronized void saveLogInFile(String fileName) {
        StringBuilder text = new StringBuilder();
        history.forEach((k,v) -> text.append("[Log for ").append(k).append(" agent]\n").append(v).append("\n"));
        try {
            PrintWriter out = new PrintWriter(fileName);
            out.println(text);
            out.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
