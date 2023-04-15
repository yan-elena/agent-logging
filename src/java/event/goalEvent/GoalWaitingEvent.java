package event.goalEvent;

import jason.asSemantics.GoalListener;
import jason.asSyntax.Term;
import jason.asSyntax.Trigger;

/**
 * A specific goal event that represents a waiting goal event.
 */
public class GoalWaitingEvent extends GoalEvent {

    /**
     * Creates an instance of {@link GoalFailedEvent}
     * @param reasoningCycleNum the reasoning cycle number
     * @param goal the trigger of the goal
     * @param reason the reason of the waiting event
     */
    public GoalWaitingEvent(int reasoningCycleNum, Trigger goal, Term reason) {
        super(reasoningCycleNum, goal, GoalListener.GoalStates.waiting);
        this.getGoalInfo().setReason(reason);
    }
}
