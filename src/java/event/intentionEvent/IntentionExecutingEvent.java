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
     * @param reasoningCycleNum the reasoning cycle number
     * @param intention the intention of the event
     */
    public IntentionExecutingEvent(int reasoningCycleNum, Intention intention, Term reason) {
        super(reasoningCycleNum, intention, reason );
    }

    @Override
    String getEvent() {
        return EXECUTING_EVENT;
    }
}
