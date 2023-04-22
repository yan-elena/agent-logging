package event.triggeringEvent;

import event.Event;
import event.eventInfo.EventInfo;
import jason.asSyntax.Trigger;

/**
 * An abstract class that representing a triggering event.
 */
public abstract class TriggeringEvent implements Event {

    protected final EventInfo eventInfo;

    /**
     * Creates a new instance of {@link TriggeringEvent} from the event trigger.
     * @param trigger the trigger of the event
     */
    public TriggeringEvent(Trigger trigger) {
        this.eventInfo = new EventInfo(trigger);
    }

    /**
     * Returns the information of the triggering event.
     * @return event information
     */
    public EventInfo getEventInfo() {
        return eventInfo;
    }
}
