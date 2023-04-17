package event.intentionEvent;

import jason.asSemantics.Intention;

/**
 * A specific intention event representing the addition of a new intention.
 */
public class IntentionAddedEvent extends IntentionEvent {

    public static final String ADDED_EVENT = "added";

    /**
     * Creates an instance of {@link IntentionAddedEvent}.
     * @param reasoningCycleNum the reasoning cycle number
     * @param intention the intention of the event
     */
    public IntentionAddedEvent(int reasoningCycleNum, Intention intention) {
        super(reasoningCycleNum, intention);
    }

    @Override
    public String getEvent() {
        return ADDED_EVENT;
    }
}
