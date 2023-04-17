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
     * @param reasoningCycleNum the reasoning cycle number
     * @param intention the intention of the event
     */
    public IntentionWaitingEvent(int reasoningCycleNum, Intention intention, Term reason) {
        super(reasoningCycleNum, intention, reason);
    }

    @Override
    String getEvent() {
        return WAITING_EVENT;
    }
}
