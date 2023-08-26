package event.goalEvent;

import event.eventInfo.IntentionInfo;
import jason.asSemantics.GoalListener.GoalStates;
import jason.asSemantics.Intention;
import jason.asSyntax.Trigger;

import java.util.Optional;

/**
 * A specific goal event that represents a goal with (un)successfully finished and removed.
 */
public class GoalRemoved extends GoalEvent{

    private final GoalStates result;
    private final Optional<IntentionInfo> intentionInfo;

    /**
     * Creates an instance of {@link GoalRemoved}.
     * @param goal the trigger of the goal
     * @param result the result of the goal: dropped/achieved/failed
     * @param intention the current intention
     */
    public GoalRemoved(Trigger goal, GoalStates result, Intention intention) {
        super(goal, GoalStates.finished);
        this.result = result;
        this.intentionInfo = intention == null ? Optional.empty() : Optional.of(new IntentionInfo(intention));
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
