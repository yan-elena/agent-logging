package logger;

import agentHistory.AgentHistory;
import agentHistory.AgentHistoryImpl;
import event.Event;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
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
            history.put(agentName, new AgentHistoryImpl(agentName));
        }
        history.get(agentName).addEvent(event);
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
