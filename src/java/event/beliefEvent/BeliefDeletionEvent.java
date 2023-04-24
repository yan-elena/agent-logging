package event.beliefEvent;

import jason.asSyntax.Trigger;

/**
 * An event that represents the deletion of a belief from a belief base.
 */
public class BeliefDeletionEvent extends BeliefEvent {

    /**
     * Creates a new instance of {@link BeliefDeletionEvent} from the event trigger.
     * @param trigger the trigger of the event
     */
    public BeliefDeletionEvent(Trigger trigger) {
        super(trigger);
    }

    @Override
    public String logEvent() {
        return "Delete belief " + eventInfo.getLiteral();
    }
}
