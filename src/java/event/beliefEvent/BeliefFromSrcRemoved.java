package event.beliefEvent;

import jason.asSyntax.Trigger;

/**
 * An event that represents a belief that is removed from the source.
 */
public class BeliefFromSrcRemoved extends BeliefEvent {

    /**
     * Creates a new instance of {@link BeliefFromSrcRemoved}.
     * @param trigger the belief
     *
     */
    public BeliefFromSrcRemoved(Trigger trigger) {
        super(trigger);
    }

    @Override
    public String logEvent() {
        return "Removed belief " + beliefInfo.getLiteral() + beliefInfo.getSource().map(s -> " from source: " + s).orElse("");
    }
}
