package event.goalEvent;

import jason.asSemantics.GoalListener.GoalStates;
import jason.asSyntax.Term;
import jason.asSyntax.Trigger;

/**
 * A specific goal event that represents a suspended goal event.
 */
public class GoalSuspended extends GoalEvent {

    /**
     * Creates an instance of {@link GoalSuspended}.
     * @param goal the trigger of the goal
     * @param reason the reason of the suspended event
     */
    public GoalSuspended(Trigger goal, Term reason) {
        super(goal, GoalStates.suspended, reason);
    }
}
