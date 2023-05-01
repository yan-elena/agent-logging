package event.intentionEvent;

import event.eventInfo.IntendedMeansInfo;
import jason.asSemantics.Intention;

import java.util.Optional;

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
        Optional<IntendedMeansInfo> intendedMeans = intentionInfo.peekFirstIntendedMeans();
        return "Intention " + getEventMessage() +
                intendedMeans.map(im -> " to sub-goal " + im.getTrigger()).orElse("") +
                ", state: " + intentionInfo.getState() +
                "\n\tcurrent step: " + intendedMeans.map(im ->
                im.isFinished() || im.getCurrentStep().isEmpty() ? "finished" : im.getCurrentStep().get()).orElse("");
    }
}
