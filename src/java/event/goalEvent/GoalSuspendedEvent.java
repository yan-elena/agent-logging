package event.goalEvent;

import jason.asSemantics.GoalListener.GoalStates;
import jason.asSyntax.Term;
import jason.asSyntax.Trigger;
import jason.asSyntax.parser.ParseException;

/**
 * A specific goal event that represents a suspended goal event.
 */
public class GoalSuspendedEvent extends GoalEvent {

    /**
     * Creates an instance of {@link GoalSuspendedEvent}.
     * @param reasoningCycleNum the reasoning cycle number
     * @param goal the trigger of the goal
     * @param reason the reason of the suspended event
     */
    public GoalSuspendedEvent(int reasoningCycleNum, Trigger goal, Term reason) throws ParseException {
        super(reasoningCycleNum, goal, GoalStates.suspended, reason);
    }
}
