package event.intentionEvent;

import event.Event;
import event.eventInfo.IntentionInfo;
import event.eventInfo.ReasonInfo;
import jason.asSemantics.Intention;
import jason.asSyntax.Term;

import java.util.Optional;

/**
 * A class that representing an event related to an intention.
 */
public abstract class IntentionEvent implements Event {

    protected final IntentionInfo intentionInfo;
    protected final Optional<ReasonInfo> reasonInfo;

    /**
     * Creates an instance of {@link IntentionEvent}.
     * @param intention the intention that the event is related to
     */
    public IntentionEvent(Intention intention) {
        this.intentionInfo = new IntentionInfo(intention);
        this.reasonInfo = Optional.empty();
    }

    /**
     * Creates an instance of {@link IntentionEvent} with a specific reason.
     * @param intention the intention that the event is related to
     * @param reason an optional reason for the event
     */
    public IntentionEvent(Intention intention, Term reason) {
        this.intentionInfo = new IntentionInfo(intention);
        this.reasonInfo = reason != null ? Optional.of(new ReasonInfo(reason)) : Optional.empty();
    }

    @Override
    public String logEvent() {
        return "Intention " + intentionInfo.getId() +
                " "  + getEventMessage() + this.reasonInfo.map(ReasonInfo::toString).orElse("") +
                " state: " + intentionInfo.getState() +
                "\n\ttrigger: " + intentionInfo.getTrigger() +
                (intentionInfo.getPlanBody().isEmpty() ? "" : "\n\tplanBody: " + intentionInfo.getPlanBody());
    }

    /**
     * Returns the type of the event.
     * @return intention event
     */
    public abstract String getEventMessage();

    /**
     * Returns the {@link IntentionInfo} related to the event.
     * @return the intention info of the event
     */
    public IntentionInfo getIntentionInfo() {
        return intentionInfo;
    }

    /**
     * Returns an optional of a reason for the intention.
     * @return an optional reason info
     */
    public Optional<ReasonInfo> getReason() {
        return reasonInfo;
    }
}
