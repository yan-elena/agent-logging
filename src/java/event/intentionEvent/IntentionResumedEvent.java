package event.intentionEvent;

import jason.asSemantics.Intention;
import jason.asSyntax.Term;

/**
 * A specific intention event representing the resume of an intention.
 */
public class IntentionResumedEvent extends IntentionEvent {

    private static final String RESUMED_EVENT = "resumed";

    /**
     * Creates an instance of {@link IntentionAddedEvent}.
     * @param reasoningCycleNum the reasoning cycle number
     * @param intention the intention of the event
     */
    public IntentionResumedEvent(int reasoningCycleNum, Intention intention, Term reason) {
        super(reasoningCycleNum, intention, reason);
    }

    @Override
    public String getEvent() {
        return RESUMED_EVENT;
    }
}
