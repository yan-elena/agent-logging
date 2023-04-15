package event.goalEvent;

import jason.asSemantics.GoalListener.GoalStates;
import jason.asSyntax.Trigger;

/**
 * A specific goal event that represents a new goal added event with the pending state.
 */
public class GoalAddedEvent extends GoalEvent {

    /**
     * Creates an instance of {@link GoalAddedEvent}.
     *
     * @param reasoningCycleNum the reasoning cycle number
     * @param goal the trigger of the goal
     */
    public GoalAddedEvent(int reasoningCycleNum, Trigger goal) {
        super(reasoningCycleNum, goal, GoalStates.pending);
    }

    @Override
    public String logEvent() {
        return "New goal " + this.getGoalInfo().getGoalFunctor() + " added";
    }
}
