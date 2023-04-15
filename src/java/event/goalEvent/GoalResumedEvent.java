package event.goalEvent;

import jason.asSemantics.GoalListener;
import jason.asSyntax.Term;
import jason.asSyntax.Trigger;

/**
 * A specific goal event that represents a resumed goal event.
 */
public class GoalResumedEvent extends GoalEvent {

    /**
     * Creates an instance of {@link GoalFailedEvent}
     * @param reasoningCycleNum the reasoning cycle number
     * @param goal the trigger of the goal
     * @param reason the reason of the resumed event
     */
    public GoalResumedEvent(int reasoningCycleNum, Trigger goal, Term reason) {
        super(reasoningCycleNum, goal, GoalListener.GoalStates.resumed);
        this.getGoalInfo().setReason(reason);
    }
}
