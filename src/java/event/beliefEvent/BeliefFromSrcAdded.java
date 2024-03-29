package event.beliefEvent;

import jason.asSyntax.Trigger;

/**
 * An event that represents a belief that is added from the source.
 */
public class BeliefFromSrcAdded extends BeliefEvent {

    /**
     * Creates a new instance of {@link BeliefFromSrcAdded}.
     * @param trigger the belief
     */
    public BeliefFromSrcAdded(Trigger trigger) {
        super(trigger);
    }

    @Override
    public String logEvent() {
        return "Added" + beliefInfo.getSource().map(s -> " source: " + s).orElse("") + " to belief " + beliefInfo.getLiteral();
    }
}
