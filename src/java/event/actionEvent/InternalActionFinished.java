package event.actionEvent;

import jason.asSemantics.Intention;
import jason.asSyntax.PlanBody;

/**
 * An event that represents the completion of an internal action.
 */
public class InternalActionFinished extends DeedEvent {

    /**
     * Creates a new {@link InternalActionFinished} instance from the executed action.
     * @param action a {@link PlanBody} of the finished action
     * @param intention {@link Intention} the current intention
     */
    public InternalActionFinished(PlanBody action, Intention intention) {
        super(action, intention);
    }

    @Override
    public String logEvent() {
        return "Internal action " + deedInfo.getTerm() + " finished";
    }
}
