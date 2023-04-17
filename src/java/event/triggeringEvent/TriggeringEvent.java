package event.triggeringEvent;

import event.AbstractEvent;
import event.eventInfo.EventInfo;
import jason.asSyntax.Trigger;

/**
 * An abstract class that representing a triggering event.
 */
public abstract class TriggeringEvent extends AbstractEvent {

    protected final EventInfo eventInfo;

    /**
     * Creates a new instance of {@link TriggeringEvent} from the event trigger.
     * @param reasoningCycleNum the reasoning cycle number
     * @param trigger the trigger of the event
     */
    public TriggeringEvent(int reasoningCycleNum, Trigger trigger) {
        super(reasoningCycleNum);
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
