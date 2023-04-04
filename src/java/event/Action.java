package event;

import jason.asSemantics.ActionExec;
import jason.asSemantics.Intention;
import jason.asSyntax.*;

public class Action extends EventImpl {

    private final ActionExec action;
    private final Structure actionTerm;
    private final Intention intention;

    public Action(long timestamp, int reasoningCycleNum, ActionExec action) {
        super(timestamp, reasoningCycleNum);
        this.action = action;
        this.actionTerm = action.getActionTerm();
        this.intention = action.getIntention();
    }

    public Action(int reasoningCycleNum, ActionExec action) {
        this(System.currentTimeMillis(), reasoningCycleNum, action);
    }

    public ActionExec getAction() {
        return action;
    }

    public Structure getActionTerm() {
        return actionTerm;
    }

    public Intention getIntention() {
        return intention;
    }

    @Override
    public String toString() {
        return "execute action " + actionTerm.getFunctor();
    }
}
