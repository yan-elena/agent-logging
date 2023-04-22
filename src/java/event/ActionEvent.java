package event;

import jason.asSemantics.ActionExec;

/**
 * An event that represents an execution of an action.
 */
public class ActionEvent implements Event {

    private final String action;

    /**
     * Creates an instance of  {@link ActionEvent} with the specified reasoning cycle number and the action
     * @param action the executed action
     */
    public ActionEvent(ActionExec action) {
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
