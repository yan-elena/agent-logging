package event.actionEvent;

import event.Event;
import event.eventInfo.DeedInfo;
import event.eventInfo.IntentionInfo;
import jason.asSemantics.Intention;
import jason.asSyntax.PlanBody;

/**
 * An event that represents the completion of an action.
 */
public class ExternalActionFinished implements Event {

    private final DeedInfo deedInfo;
    private final IntentionInfo intentionInfo;

    /**
     * Creates a new instance of {@link ExternalActionFinished} from the given action.
     * @param action the finished action
     * @param intention {@link Intention} the current intention
     */
    public ExternalActionFinished(PlanBody action, Intention intention) {
        this.deedInfo = new DeedInfo(action);
        this.intentionInfo = new IntentionInfo(intention);
    }

    @Override
    public String logEvent() {
        return "Action " + deedInfo.getTerm() + " finished";
    }
}
