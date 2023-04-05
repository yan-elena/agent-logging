package agentHistory;

import event.Event;

import java.util.List;

public interface AgentHistory {

    List<Event> getHistory();

    void addEvent(Event event);
}
