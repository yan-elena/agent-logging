package event.intentionEvent;

import event.AbstractEvent;
import event.eventInfo.IntentionInfo;
import event.eventInfo.ReasonInfo;
import jason.asSemantics.Intention;
import jason.asSyntax.Term;

import java.util.Optional;

/**
 * A class that representing an event related to an intention.
 */
public abstract class IntentionEvent extends AbstractEvent {

    private final IntentionInfo intentionInfo;
    private final Optional<ReasonInfo> reasonInfo;

    /**
     * Creates an instance of {@link IntentionEvent}.
     * @param reasoningCycleNum the number of the reasoning cycle
     * @param intention the intention that the event is related to
     */
    public IntentionEvent(int reasoningCycleNum, Intention intention) {
        super(reasoningCycleNum);
        this.intentionInfo = new IntentionInfo(intention);
        this.reasonInfo = Optional.empty();
    }

    /**
     * Creates an instance of {@link IntentionEvent} with a specific reason.
     * @param reasoningCycleNum the number of the reasoning cycle
     * @param intention the intention that the event is related to
     * @param reason an optional reason for the event
     */
    public IntentionEvent(int reasoningCycleNum, Intention intention, Term reason) {
        super(reasoningCycleNum);
        this.intentionInfo = new IntentionInfo(intention);
        this.reasonInfo = reason != null ? Optional.of(new ReasonInfo(reason)) : Optional.empty();
    }

    @Override
    public String logEvent() {
        return "Intention " + intentionInfo.getId() +
                " "  + getEvent() + this.reasonInfo.map(ReasonInfo::toString).orElse("") +
                " state: " + intentionInfo.getState() +
                "\n\ttrigger: " + intentionInfo.getTrigger() +
                (intentionInfo.getPlanBody().isEmpty() ? "" : "\n\tplanBody: " + intentionInfo.getPlanBody());
    }

    /**
     * Returns the type of the event.
     * @return intention event
     */
    public abstract String getEvent();

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
