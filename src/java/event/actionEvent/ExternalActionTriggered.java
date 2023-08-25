package event.actionEvent;

import event.Event;
import event.eventInfo.ActionInfo;
import event.eventInfo.IntentionInfo;
import jason.asSemantics.ActionExec;
import jason.asSemantics.Intention;

/**
 * An event that represents an execution of an action.
 */
public class ExternalActionTriggered implements Event {

    private final ActionInfo action;
    private final IntentionInfo intentionInfo;

    /**
     * Creates an instance of  {@link ExternalActionTriggered} with the specified reasoning cycle number and the action
     * @param action the executed action
     * @param intention {@link Intention} the current intention
     */
    public ExternalActionTriggered(ActionExec action, Intention intention) {
        this.action = new ActionInfo(action);
        this.intentionInfo = new IntentionInfo(intention);
    }

    /**
     * Returns the executing action.
     * @return the action
     */
    public ActionInfo getAction() {
        return action;
    }

    @Override
    public String logEvent() {
        return "Execute action " + action.getTerm() + " from " + action.getSource();
    }
}
