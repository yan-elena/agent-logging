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
     * @param intention the intention of the event
     */
    public IntentionSuspendedEvent(Intention intention, Term reason) {
        super(intention, reason);
    }

    @Override
    public String getEventMessage() {
        return SUSPENDED_EVENT;
    }
}
