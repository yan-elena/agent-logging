package agentHistory;

import event.Event;

import java.util.List;

public interface AgentHistory {

//    List<Event> getHistory();
    List<String> getHistory();

    void addEvent(Event event);
}
