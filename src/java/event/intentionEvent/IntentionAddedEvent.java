package event.intentionEvent;

import jason.asSemantics.Intention;

/**
 * A specific intention event representing the addition of a new intention.
 */
public class IntentionAddedEvent extends IntentionEvent {

    public static final String ADDED_EVENT = "added";

    /**
     * Creates an instance of {@link IntentionAddedEvent}.
     * @param intention the intention of the event
     */
    public IntentionAddedEvent(Intention intention) {
        super(intention);
    }

    @Override
    public String getEventMessage() {
        return ADDED_EVENT;
    }
}
