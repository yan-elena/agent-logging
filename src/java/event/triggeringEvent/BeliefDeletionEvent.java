package event.triggeringEvent;

import jason.asSyntax.Trigger;

/**
 * An event that represents the deletion of a belief from a belief base.
 */
public class BeliefDeletionEvent extends TriggeringEvent {

    /**
     * Creates a new instance of {@link BeliefDeletionEvent} from the event trigger.
     * @param reasoningCycleNum the reasoning cycle number
     * @param trigger the trigger of the event
     */
    public BeliefDeletionEvent(int reasoningCycleNum, Trigger trigger) {
        super(reasoningCycleNum, trigger);
    }

    @Override
    public String logEvent() {
        return "Delete belief " + eventInfo.getLiteral();
    }
}
