package event.intentionEvent;

import jason.asSemantics.Intention;
import jason.asSyntax.Term;

/**
 * A specific intention event representing the execution of an intention.
 */
public class IntentionExecutingEvent extends IntentionEvent {

    private static final String EXECUTING_EVENT = "executing";

    /**
     * Creates an instance of {@link IntentionAddedEvent}.
     * @param intention the intention of the event
     */
    public IntentionExecutingEvent(Intention intention, Term reason) {
        super(intention, reason );
    }

    @Override
    public String getEventMessage() {
        return EXECUTING_EVENT;
    }
}
