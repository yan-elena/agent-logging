package event.beliefEvent;

import jason.asSyntax.Trigger;

/**
 * An event that represents the addition of a belief to a belief base.
 */
public class BeliefAdded extends BeliefEvent {

    /**
     * Creates a new instance of {@link BeliefAdded} from the event trigger.
     * @param trigger the trigger of the event
     */
    public BeliefAdded(Trigger trigger) {
        super(trigger);
    }

    @Override
    public String logEvent() {
        return "Added belief " + beliefInfo.getLiteral();
    }
}
