package event.goalEvent;

import jason.asSemantics.GoalListener;
import jason.asSyntax.Term;
import jason.asSyntax.Trigger;

/**
 * A specific goal event that represents a resumed goal event.
 */
public class GoalResumedEvent extends GoalEvent {

    private final String reason;

    /**
     * Creates an instance of {@link GoalFailedEvent}
     * @param reasoningCycleNum the reasoning cycle number
     * @param goal the trigger of the goal
     * @param reason the reason of the failed event
     */
    public GoalResumedEvent(int reasoningCycleNum, Trigger goal, Term reason) {
        super(reasoningCycleNum, goal, GoalListener.GoalStates.resumed);
        this.reason = reason.toString();
    }

    @Override
    public String eventToString() {
        return "Goal " + this.goal.getGoalFunctor() + " " + this.goal.getGoalStates() + " with reason: " + reason;
    }
}
