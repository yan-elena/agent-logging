package eventHistory;

import event.Event;

import java.util.List;

/**
 * An interface for tracking the history of all events in an agent.
 */
public interface EventHistory {


    /**
     * Returns a list of strings representing the history of events.
     * @return events history
     */
    List<Event> getHistory();
//    List<String> getHistory();

    /**
     * Adds an event to the history.
     * @param event the event to be added
     */
    void addEvent(Event event);
}
