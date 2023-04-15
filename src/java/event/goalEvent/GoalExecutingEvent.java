package event.goalEvent;

import event.Event;
import jason.asSemantics.GoalListener;
import jason.asSyntax.Term;
import jason.asSyntax.Trigger;

/**
 * A specific goal event that represents an executed goal event.
 */
public class GoalExecutingEvent extends GoalEvent {

    private final String reason;

    /**
     * Creates an instance of {@link GoalExecutingEvent}
     * @param reasoningCycleNum the reasoning cycle number
     * @param goal the trigger of the goal
     * @param reason the reason of the failed event
     */
    public GoalExecutingEvent(int reasoningCycleNum, Trigger goal, Term reason) {
        super(reasoningCycleNum, goal, GoalListener.GoalStates.executing);
        this.reason = reason.toString();
    }

    @Override
    public String eventToString() {
        return "Goal " + this.goal.getGoalFunctor() + " " + this.goal.getGoalStates() + " with reason: " + reason;
    }
}
