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
public class IntentionEvent extends AbstractEvent {

    private final IntentionInfo intentionInfo;
    private final Optional<ReasonInfo> reasonInfo;

    /**
     * Creates an instance of {@link IntentionEvent}.
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
        return intentionInfo + " "  + this.reasonInfo.map(ReasonInfo::toString).orElse("");
    }

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
