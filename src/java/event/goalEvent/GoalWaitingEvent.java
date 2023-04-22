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
     * @param goal the trigger of the goal
     * @param reason the reason of the waiting event
     */
    public GoalWaitingEvent(Trigger goal, Term reason) {
        super(goal, GoalListener.GoalStates.waiting, reason);
    }
}
