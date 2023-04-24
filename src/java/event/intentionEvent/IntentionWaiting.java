package event.intentionEvent;

import jason.asSemantics.Intention;
import jason.asSyntax.Term;

/**
 * A specific intention event representing the waiting of an intention.
 */
public class IntentionWaiting extends IntentionEvent {

    private static final String WAITING_EVENT = "waiting";

    /**
     * Creates an instance of {@link IntentionWaiting}.
     * @param intention the intention of the event
     */
    public IntentionWaiting(Intention intention, Term reason) {
        super(intention, reason);
    }

    @Override
    public String getEventMessage() {
        return WAITING_EVENT;
    }
}
