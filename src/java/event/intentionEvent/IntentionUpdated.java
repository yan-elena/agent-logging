package event.intentionEvent;

import jason.asSemantics.Intention;

/**
 * A specific intention event to represent an updated intention event. It occurs when a sub-goal is created.
 */
public class IntentionUpdated extends IntentionEvent {

    public static final String UPDATED_EVENT = "updated";

    /**
     * Creates a new instance of {@link IntentionUpdated} from the given intention.
     * @param intention the updated intention
     */
    public IntentionUpdated(Intention intention) {
        super(intention);
    }

    @Override
    public String getEventMessage() {
        return UPDATED_EVENT;
    }

    @Override
    public String logEvent() {
        return "Intention " + getEventMessage() + " to sub-goal " + intentionInfo.peekFirstIntendedMeans().getTrigger();
    }
}
