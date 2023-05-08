package event.actionEvent;

import event.Event;
import jason.asSemantics.ActionExec;

/**
 * An event that represents an execution of an action.
 */
public class ExternalActionTriggered implements Event {

    private final String action;

    /**
     * Creates an instance of  {@link ExternalActionTriggered} with the specified reasoning cycle number and the action
     * @param action the executed action
     */
    public ExternalActionTriggered(ActionExec action) {
        this.action = action.getActionTerm().toString();
    }

    /**
     * Returns the executing action.
     * @return the action
     */
    public String getAction() {
        return action;
    }

    @Override
    public String logEvent() {
        return "Execute action " + action;
    }
}
