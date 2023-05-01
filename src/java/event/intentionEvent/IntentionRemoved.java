package event.intentionEvent;

import event.eventInfo.ReasonInfo;
import jason.asSemantics.Intention;

/**
 * A specific intention event to represent a dropping intention event.
 */
public class IntentionRemoved extends IntentionEvent {

    public static final String REMOVED_EVENT = "removed";

    /**
     * Creates a new instance of {@link IntentionRemoved}.
     * @param intention the intention of the dropped event
     */
    public IntentionRemoved(Intention intention) {
        super(intention);
    }

    @Override
    public String getEventMessage() {
        return REMOVED_EVENT;
    }

    @Override
    public String logEvent() {
        return intentionInfo.peekFirstIntendedMeans()
                .map(intendedMeansInfo -> "Intention " + intentionInfo.getId() +
                " " + getEventMessage() +
                ", " + intendedMeansInfo.getTrigger() +
                " " + this.reasonInfo.map(ReasonInfo::toString).orElse("") +
                ", state: " + intentionInfo.getState()).orElseGet(super::logEvent);
    }
}
