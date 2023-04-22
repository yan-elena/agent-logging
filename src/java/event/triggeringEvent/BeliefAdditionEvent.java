package event.triggeringEvent;

import jason.asSyntax.Trigger;

/**
 * An event that represents the addition of a belief to a belief base.
 */
public class BeliefAdditionEvent extends TriggeringEvent{

    /**
     * Creates a new instance of {@link BeliefAdditionEvent} from the event trigger.
     * @param trigger the trigger of the event
     */
    public BeliefAdditionEvent(Trigger trigger) {
        super(trigger);
    }

    @Override
    public String logEvent() {
        return "Added belief " + eventInfo.getLiteral();
    }
}
