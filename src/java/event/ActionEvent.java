package event;

import jason.asSemantics.ActionExec;
import jason.asSemantics.Intention;
import jason.asSyntax.*;

/**
 * An event that represents an action.
 */
public class ActionEvent extends AbstractEvent {

    private final ActionExec action;
    private final Structure actionTerm;
    private final Intention intention;

    /**
     * Creates an instance of  {@link ActionEvent} with the specified reasoning cycle number and the action
     * @param reasoningCycleNum the number of the reasoning cycle in which the event occurred
     * @param action the executed action
     */
    public ActionEvent(int reasoningCycleNum, ActionExec action) {
        super(reasoningCycleNum);
        this.action = action;
        this.actionTerm = action.getActionTerm();
        this.intention = action.getIntention();
    }

    /**
     * Returns the executed action.
     * @return the executed action
     */
    public ActionExec getAction() {
        return action;
    }

    /**
     * Returns the term representing the executed action.
     * @return the term of the executed action
     */
    public Structure getActionTerm() {
        return actionTerm;
    }

    /**
     * Returns the intention associated with the action.
     * @return the intention of the action
     */
    public Intention getIntention() {
        return intention;
    }

    @Override
    public String eventToString() {
        return "Execute action " + actionTerm.getFunctor();
    }
}
