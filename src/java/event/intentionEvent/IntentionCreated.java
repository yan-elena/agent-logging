package event.intentionEvent;

import jason.asSemantics.Intention;

/**
 * A specific intention event representing the creation of a new intention.
 */
public class IntentionCreated extends IntentionEvent {

    public static final String CREATED_EVENT = "created";

    /**
     * Creates an instance of {@link IntentionCreated}.
     * @param intention the intention of the event
     */
    public IntentionCreated(Intention intention) {
        super(intention);
    }

    @Override
    public String getEventMessage() {
        return CREATED_EVENT;
    }
}
