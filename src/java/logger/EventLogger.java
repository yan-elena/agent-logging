package logger;

import event.Event;
import logger.eventHistory.EventHistory;

import java.util.Map;

/**
 * An interface that represents a logger of events generated by an agent.
 */
public interface EventLogger {

    /**
     * Published an event with the given agent name and event information.
     * @param agentName the name of the agent
     * @param event the event to be published
     */
    void publishEvent(String agentName, Event event);

    /**
     * Saves the log of the agent.
     * @param agentName the name of the agent to log
     */
    void saveLog(String agentName);
}
