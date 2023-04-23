package event.goalEvent;

import jason.asSemantics.GoalListener.GoalStates;
import jason.asSyntax.Trigger;

/**
 * A specific goal event that represents a new goal is created and added to the event queue.
 */
public class GoalCreated extends GoalEvent {

    /**
     * Creates an instance of {@link GoalCreated}.
     * @param goal the trigger of the goal
     */
    public GoalCreated(Trigger goal) {
        super(goal, GoalStates.pending);
    }

    @Override
    public String logEvent() {
        return "Goal " + this.getGoalInfo().getGoalFunctor() + " created";
    }
}
