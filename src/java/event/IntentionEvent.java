package event;

import jason.asSemantics.Intention;
import jason.asSyntax.Term;

import java.util.Optional;

public class IntentionEvent extends AbstractEvent {

    private final Intention intention;
    private final String event;
    private final Optional<Term> reason;

    public IntentionEvent(int reasoningCycleNum, Intention intention, String event, Term reason) {
        super(reasoningCycleNum);
        this.intention = intention;
        this.event = event;
        this.reason = Optional.ofNullable(reason);
    }

    @Override
    public String eventToString() {
        return "Intention "  + intention + " " + event;
    }

    public Intention getIntention() {
        return intention;
    }

    public String getEvent() {
        return event;
    }

    public Optional<Term> getReason() {
        return reason;
    }
}
