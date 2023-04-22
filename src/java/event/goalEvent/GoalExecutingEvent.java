package event.goalEvent;

import jason.asSemantics.GoalListener;
import jason.asSyntax.Term;
import jason.asSyntax.Trigger;

/**
 * A specific goal event that represents an executed goal event.
 */
public class GoalExecutingEvent extends GoalEvent {

    /**
     * Creates an instance of {@link GoalExecutingEvent}.
     * @param goal the trigger of the goal
     * @param reason the reason of the executing event
     */
    public GoalExecutingEvent(Trigger goal, Term reason) {
        super(goal, GoalListener.GoalStates.executing, reason);
    }

}
