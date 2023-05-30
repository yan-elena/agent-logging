package event.beliefEvent;

import jason.asSyntax.Trigger;

/**
 * An event that represents the deletion of a belief from a belief base.
 */
public class BeliefRemoved extends BeliefEvent {

    /**
     * Creates a new instance of {@link BeliefRemoved} from the event trigger.
     * @param trigger the trigger of the event
     */
    public BeliefRemoved(Trigger trigger) {
        super(trigger);
    }

    @Override
    public String logEvent() {
        return "Removed belief " + beliefInfo.getLiteral();
    }
}
