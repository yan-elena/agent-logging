package event.goalEvent;

import jason.asSemantics.GoalListener.GoalStates;
import jason.asSyntax.Trigger;

/**
 * A specific goal event that represents a goal with (un)successfully finished.
 */
public class GoalFinishedEvent extends GoalEvent{

    private final GoalStates result;

    /**
     * Creates an instance of {@link GoalFinishedEvent}.
     * @param goal the trigger of the goal
     * @param result the result of the goal
     */
    public GoalFinishedEvent(Trigger goal, GoalStates result) {
        super(goal, GoalStates.finished);
        this.result = result;
    }

    /**
     * Returns the result of the finished goal.
     * @return goal result
     */
    public GoalStates getResult() {
        return result;
    }

    @Override
    public String logEvent() {
        return "Goal " + this.getGoalInfo().getGoalFunctor() + " finished with status: " + result;
    }
}
