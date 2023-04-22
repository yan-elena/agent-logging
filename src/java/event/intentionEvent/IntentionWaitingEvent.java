package event.intentionEvent;

import jason.asSemantics.Intention;
import jason.asSyntax.Term;

/**
 * A specific intention event representing the waiting of an intention.
 */
public class IntentionWaitingEvent extends IntentionEvent {

    private static final String WAITING_EVENT = "waiting";

    /**
     * Creates an instance of {@link IntentionAddedEvent}.
     * @param intention the intention of the event
     */
    public IntentionWaitingEvent(Intention intention, Term reason) {
        super(intention, reason);
    }

    @Override
    public String getEventMessage() {
        return WAITING_EVENT;
    }
}
