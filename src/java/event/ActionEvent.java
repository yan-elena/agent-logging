package event;

import jason.asSemantics.ActionExec;

/**
 * An event that represents an action.
 */
public class ActionEvent extends AbstractEvent {

    private final String actionFunctor;

    /**
     * Creates an instance of  {@link ActionEvent} with the specified reasoning cycle number and the action
     * @param reasoningCycleNum the number of the reasoning cycle in which the event occurred
     * @param action the executed action
     */
    public ActionEvent(int reasoningCycleNum, ActionExec action) {
        super(reasoningCycleNum);
        this.actionFunctor = action.getActionTerm().getFunctor();
    }

    /**
     * Returns the functor of the executed action.
     * @return the action functor
     */
    public String getActionFunctor() {
        return actionFunctor;
    }

    @Override
    public String eventToString() {
        return "Execute action " + actionFunctor;
    }
}
