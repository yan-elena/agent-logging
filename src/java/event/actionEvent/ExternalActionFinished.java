package event.actionEvent;

import event.Event;
import event.eventInfo.DeedInfo;
import event.eventInfo.IntentionInfo;
import jason.asSemantics.Intention;
import jason.asSyntax.PlanBody;

import java.util.Optional;

/**
 * An event that represents the completion of an action.
 */
public class ExternalActionFinished implements Event {

    private final DeedInfo deedInfo;
    private final Optional<IntentionInfo> intentionInfo;

    /**
     * Creates a new instance of {@link ExternalActionFinished} from the given action.
     * @param action the finished action
     * @param intention {@link Intention} the current intention
     */
    public ExternalActionFinished(PlanBody action, Intention intention) {
        this.deedInfo = new DeedInfo(action);
        this.intentionInfo = intention != null ? Optional.of(new IntentionInfo(intention)) : Optional.empty();

    }

    @Override
    public String logEvent() {
        return "Action " + deedInfo.getTerm() + " finished";
    }
}
