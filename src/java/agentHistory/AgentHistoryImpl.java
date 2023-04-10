package agentHistory;

import event.Event;

import java.util.LinkedList;
import java.util.List;

public class AgentHistoryImpl implements AgentHistory {

    private final String agentName;
    private final List<Event> history;

    public AgentHistoryImpl(String agentName) {
        this.agentName = agentName;
        this.history = new LinkedList<>();
    }

    @Override
    public List<Event> getHistory() {
        return this.history;
    }

    @Override
    public void addEvent(Event event) {
        event.setAgentName(agentName);
        System.out.println(event);
        this.history.add(event);
    }

    @Override
    public String toString() {
        return String.join("\n", history.stream().map(Event::toString).toList());
    }
}
