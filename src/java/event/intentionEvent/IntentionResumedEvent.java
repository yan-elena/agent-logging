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
     * @param intention the intention of the event
     */
    public IntentionResumedEvent(Intention intention, Term reason) {
        super(intention, reason);
    }

    @Override
    public String getEventMessage() {
        return RESUMED_EVENT;
    }
}
