package event.intentionEvent;

import event.eventInfo.ReasonInfo;
import jason.asSemantics.Intention;

/**
 * A specific intention event to represent a dropping intention event.
 */
public class IntentionDroppedEvent extends IntentionEvent {

    public static final String DROPPED_EVENT = "dropped";

    /**
     * Creates a new instance of {@link IntentionDroppedEvent}.
     * @param reasoningCycleNum the reasoning cycle number
     * @param intention the intention of the dropped event
     */
    public IntentionDroppedEvent(int reasoningCycleNum, Intention intention) {
        super(reasoningCycleNum, intention);
    }

    @Override
    public String getEventMessage() {
        return DROPPED_EVENT;
    }

    @Override
    public String logEvent() {
        if (intentionInfo.getTrigger().contains("finished intention")) {
            return "Intention " + intentionInfo.getId() +
                    " " + getEventMessage() + this.reasonInfo.map(ReasonInfo::toString).orElse("") +
                    " state: " + intentionInfo.getState() +
                    "\n\t " + intentionInfo.getTrigger();
        } else {
            return super.logEvent();
        }
    }
}
