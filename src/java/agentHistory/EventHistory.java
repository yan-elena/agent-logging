package agentHistory;

import event.Event;

import java.util.List;

public interface EventHistory {

//    List<Event> getHistory();
    List<String> getHistory();

    void addEvent(Event event);
}
