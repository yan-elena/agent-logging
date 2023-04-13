package event.goalEvent;

import event.AbstractEvent;
import eventInfo.GoalInfo;
import jason.asSemantics.GoalListener.GoalStates;
import jason.asSyntax.Trigger;

/**
 * A class that representing an event related to a goal.
 */
public abstract class GoalEvent extends AbstractEvent {

    protected final GoalInfo goal;

    /**
     * Creates an instance of {@link GoalEvent}.
     * @param reasoningCycleNum the reasoning cycle number
     * @param goal the trigger of the goal
     */
    public GoalEvent(int reasoningCycleNum, Trigger goal, GoalStates states) {
        super(reasoningCycleNum);
        this.goal = new GoalInfo(goal, states);
    }

    /**
     * Returns the goal information associated with the event.
     * @return the goal
     */
    public GoalInfo getGoalInfo() {
        return goal;
    }

}
