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
     * @param goal the trigger of the goal
     * @param reason the reason of the resumed event
     */
    public GoalResumedEvent(Trigger goal, Term reason) {
        super(goal, GoalListener.GoalStates.resumed, reason);
    }
}
