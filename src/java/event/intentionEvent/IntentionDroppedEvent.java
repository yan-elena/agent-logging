package event.intentionEvent;

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
    String getEvent() {
        return DROPPED_EVENT;
    }
}
