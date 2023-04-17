package event.triggeringEvent;

import jason.asSyntax.Trigger;

/**
 * An event that represents the addition of a belief to a belief base.
 */
public class BeliefAdditionEvent extends TriggeringEvent{

    /**
     * Creates a new instance of {@link BeliefAdditionEvent} from the event trigger.
     * @param reasoningCycleNum the reasoning cycle number
     * @param trigger the trigger of the event
     */
    public BeliefAdditionEvent(int reasoningCycleNum, Trigger trigger) {
        super(reasoningCycleNum, trigger);
    }

    @Override
    public String logEvent() {
        return "Added belief " + eventInfo.getLiteral();
    }
}
