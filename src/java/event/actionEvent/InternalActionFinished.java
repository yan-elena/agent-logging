package event.actionEvent;

import event.Event;
import event.eventInfo.DeedInfo;
import event.eventInfo.IntentionInfo;
import jason.asSemantics.Intention;
import jason.asSyntax.PlanBody;

/**
 * An event that represents the completion of an internal action.
 */
public class InternalActionFinished implements Event {

    private final DeedInfo action;
    private final IntentionInfo intentionInfo;

    /**
     * Creates a new {@link InternalActionFinished} instance from the executed action.
     * @param action a {@link PlanBody} of the finished action
     * @param intention {@link Intention} the current intention
     */
    public InternalActionFinished(PlanBody action, Intention intention) {
        this.action = new DeedInfo(action);
        this.intentionInfo = new IntentionInfo(intention);
    }

    @Override
    public String logEvent() {
        return "Internal action " + action.getTerm() + " finished";
    }
}
