package event.actionEvent;

import event.Event;
import event.eventInfo.DeedInfo;
import jason.asSyntax.PlanBody;

/**
 * An event that represents the completion of an internal action.
 */
public class InternalActionFinished implements Event {

    private final DeedInfo action;

    /**
     * Creates a new {@link InternalActionFinished} instance from the executed action.
     * @param action a {@link PlanBody} of the finished action
     */
    public InternalActionFinished(PlanBody action) {
        this.action = new DeedInfo(action);
    }

    @Override
    public String logEvent() {
        return "Internal action " + action.getTerm() + " finished";
    }
}
