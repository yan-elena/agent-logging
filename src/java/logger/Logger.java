package logger;

import event.Event;

public interface Logger {

    void publishEvent(String agentName, Event event);

    void saveLogInFile(String fileName);
}
