package eventHistory;

import event.Event;

import java.util.LinkedList;
import java.util.List;

/**
 * Implementation of {@link EventHistory} interface.
 */
public class EventHistoryImpl implements EventHistory {

    private final String agentName;
//    private final List<Event> history;
    private final List<String> history;

    /**
     * Creates an instance of {@link EventHistory}.
     * @param agentName the name of the associated agent
     */
    public EventHistoryImpl(String agentName) {
        this.agentName = agentName;
        this.history = new LinkedList<>();
    }

//    @Override
//    public List<Event> getHistory() {
//        return this.history;
//    }

    @Override
    public List<String> getHistory() {
        return this.history;
    }

    @Override
    public void addEvent(Event event) {
        event.setAgentName(agentName);
        System.out.println(event);
//        this.history.add(event);
        this.history.add(event.toString());
    }

    @Override
    public String toString() {
//        return String.join("\n", history.stream().map(Event::toString).toList());
        return String.join("\n", history);
    }
}
