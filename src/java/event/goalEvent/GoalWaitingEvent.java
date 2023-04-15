package event.goalEvent;

import jason.asSemantics.GoalListener;
import jason.asSyntax.Term;
import jason.asSyntax.Trigger;

public class GoalWaitingEvent extends GoalEvent {

    private final String reason;

    /**
     * Creates an instance of {@link GoalFailedEvent}
     * @param reasoningCycleNum the reasoning cycle number
     * @param goal the trigger of the goal
     * @param reason the reason of the failed event
     */
    public GoalWaitingEvent(int reasoningCycleNum, Trigger goal, Term reason) {
        super(reasoningCycleNum, goal, GoalListener.GoalStates.waiting);
        this.reason = reason.toString();
    }

    @Override
    public String eventToString() {
        return "Goal " + this.goal.getGoalFunctor() + " " + this.goal.getGoalStates() + " with reason: " + reason;
    }
}
