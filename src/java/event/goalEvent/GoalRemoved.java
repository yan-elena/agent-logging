package event.goalEvent;

import jason.asSemantics.GoalListener.GoalStates;
import jason.asSyntax.Trigger;

/**
 * A specific goal event that represents a goal with (un)successfully finished and removed.
 */
public class GoalRemoved extends GoalEvent{

    private final GoalStates result;

    /**
     * Creates an instance of {@link GoalRemoved}.
     * @param goal the trigger of the goal
     * @param result the result of the goal: dropped/achieved/failed
     */
    public GoalRemoved(Trigger goal, GoalStates result) {
        super(goal, GoalStates.finished);
        this.result = result;
    }

    /**
     * Returns the result of the removed goal.
     * @return goal result
     */
    public GoalStates getResult() {
        return result;
    }

    @Override
    public String logEvent() {
        return "Goal " + this.getGoalInfo().getGoalFunctor() + " removed because the goal is " + result;
    }
}
