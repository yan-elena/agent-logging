package eventHistory;

import event.Event;

import java.util.LinkedList;
import java.util.List;

/**
 * Implementation of the {@link EventHistory} interface.
 *
 * This class is responsible for maintaining the history of events for a single agent.
 */
public class EventHistoryImpl implements EventHistory {

    private final List<Event> history;

    /**
     * Creates an instance of {@link EventHistory} for the specified agent.
     */
    public EventHistoryImpl() {
        this.history = new LinkedList<>();
    }

    @Override
    public List<Event> getHistory() {
        return this.history;
    }

    @Override
    public void addEvent(Event event) {
        this.history.add(event);
    }

    @Override
    public String toString() {
        return String.join("\n", history.stream().map(Event::toString).toList());
    }
}
