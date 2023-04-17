package event.intentionEvent;

import jason.asSemantics.Intention;
import jason.asSyntax.Term;

/**
 * A specific intention event representing the suspension of an intention.
 */
public class IntentionSuspendedEvent extends IntentionEvent {

    private static final String SUSPENDED_EVENT = "suspended";

    /**
     * Creates an instance of {@link IntentionAddedEvent}.
     * @param reasoningCycleNum the reasoning cycle number
     * @param intention the intention of the event
     */
    public IntentionSuspendedEvent(int reasoningCycleNum, Intention intention, Term reason) {
        super(reasoningCycleNum, intention, reason);
    }

    @Override
    public String getEventMessage() {
        return SUSPENDED_EVENT;
    }
}
