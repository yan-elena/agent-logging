package event.goalEvent;

import jason.asSemantics.GoalListener.GoalStates;
import jason.asSyntax.Trigger;

/**
 * A specific goal event that represents a new goal added event with the pending state.
 */
public class GoalAddedEvent extends GoalEvent {

    /**
     * Creates an instance of {@link GoalAddedEvent}.
     * @param goal the trigger of the goal
     */
    public GoalAddedEvent(Trigger goal) {
        super(goal, GoalStates.pending);
    }

    @Override
    public String logEvent() {
        return "New goal " + this.getGoalInfo().getGoalFunctor() + " added";
    }
}
