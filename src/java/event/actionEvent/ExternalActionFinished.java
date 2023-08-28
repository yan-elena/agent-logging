package event.actionEvent;

import jason.asSemantics.Intention;
import jason.asSyntax.PlanBody;

/**
 * An event that represents the completion of an action.
 */
public class ExternalActionFinished extends DeedEvent {

    /**
     * Creates a new instance of {@link ExternalActionFinished} from the given action.
     * @param action the finished action
     * @param intention {@link Intention} the current intention
     */
    public ExternalActionFinished(PlanBody action, Intention intention) {
        super(action, intention);
    }

    @Override
    public String logEvent() {
        return "Action " + deedInfo.getTerm() + " finished";
    }
}
