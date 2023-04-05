package agentHistory;

import event.Event;

import java.util.LinkedList;
import java.util.List;

public class AgentHistoryImpl implements AgentHistory {

    private final List<Event> history;

    public AgentHistoryImpl() {
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
        return "AgentHistory{" +
                "history=" + history +
                '}';
    }
}
