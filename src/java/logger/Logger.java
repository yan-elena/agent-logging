package logger;

import event.Event;

public interface Logger {

    void insertEvent(String agentName, Event event);

    void saveLogInFile(String fileName);
}
