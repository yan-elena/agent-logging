package event.intentionEvent;

import event.AbstractEvent;
import jason.asSemantics.Intention;
import jason.asSyntax.Term;

import java.util.Optional;

/**
 * A class that representing an event related to an intention.
 */
public class IntentionEvent extends AbstractEvent {

    private final Intention intention;
    private final String event;
    private final Optional<Term> reason;

    /**
     * Creates an instance of {@link IntentionEvent}.
     * @param reasoningCycleNum the number of the reasoning cycle
     * @param intention the intention that the event is related to
     * @param event the description of the event
     * @param reason an optional reason for the event
     */
    public IntentionEvent(int reasoningCycleNum, Intention intention, String event, Term reason) {
        super(reasoningCycleNum);
        this.intention = intention;
        this.event = event;
        this.reason = Optional.ofNullable(reason);
    }

    @Override
    public String logEvent() {
        return event + " "  + intention;
    }

    /**
     * Returns the intention related to the event.
     * @return the intention of the event
     */
    public Intention getIntention() {
        return intention;
    }

    /**
     * Returns the description of the event.
     * @return the event description
     */
    public String getEvent() {
        return event;
    }

    /**
     * Returns an optional of a reason for the intention.
     * @return an optional reason
     */
    public Optional<Term> getReason() {
        return reason;
    }
}
