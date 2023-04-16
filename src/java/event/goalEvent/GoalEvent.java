package event.goalEvent;

import event.AbstractEvent;
import event.eventInfo.GoalInfo;
import event.eventInfo.ReasonInfo;
import jason.asSemantics.GoalListener.GoalStates;
import jason.asSyntax.Trigger;

/**
 * A class that representing an event related to a goal.
 */
public class GoalEvent extends AbstractEvent {

    private final GoalInfo goal;

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

    @Override
    public String logEvent() {
        return "Goal " + this.goal.getGoalFunctor() + " " + this.goal.getGoalStates() +
                getGoalInfo().getReasonInfo().toString();
    }
}
