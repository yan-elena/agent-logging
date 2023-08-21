package logger.eventHistory;

import event.Event;

import java.util.List;

/**
 * An interface for tracking the history of all events in an agent.
 */
public interface EventHistory {

    /**
     * Adds an event to the history.
     * @param event the event to be added
     */
    void addEvent(Event event);

    /**
     * Save the event history log.
     */
    void saveLog();
}
