package event.goalEvent;

import event.AbstractEvent;
import event.eventInfo.GoalInfo;
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
    public String eventToString() {
        StringBuilder out = new StringBuilder();
        out.append("Goal ").append(this.goal.getGoalFunctor()).append(" ").append(this.goal.getGoalStates());
        if (goal.getReason().isPresent()) {
            out.append(" with reason: ").append(goal.getReason().get());
        }
        return out.toString();
    }
}
