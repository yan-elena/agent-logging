package event.beliefEvent;

import event.Event;
import event.eventInfo.BeliefInfo;
import jason.asSyntax.Trigger;

/**
 * An abstract class that representing a belief event.
 */
public abstract class BeliefEvent implements Event {

    protected final BeliefInfo beliefInfo;

    /**
     * Creates a new instance of {@link BeliefEvent} from the event trigger.
     * @param trigger the trigger of the event
     */
    public BeliefEvent(Trigger trigger) {
        this.beliefInfo = new BeliefInfo(trigger);
    }

    /**
     * Returns the information of the triggering event.
     * @return event information
     */
    public BeliefInfo getEventInfo() {
        return beliefInfo;
    }
}
