package event.actionEvent;

import event.Event;
import event.eventInfo.ActionInfo;
import jason.asSemantics.ActionExec;

/**
 * An event that represents an execution of an action.
 */
public class ExternalActionTriggered implements Event {

    private final ActionInfo action;

    /**
     * Creates an instance of  {@link ExternalActionTriggered} with the specified reasoning cycle number and the action
     * @param action the executed action
     */
    public ExternalActionTriggered(ActionExec action) {
        this.action = new ActionInfo(action);
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
