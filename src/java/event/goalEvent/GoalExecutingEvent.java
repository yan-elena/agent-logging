package event.goalEvent;

import jason.asSemantics.GoalListener;
import jason.asSyntax.Term;
import jason.asSyntax.Trigger;
import jason.asSyntax.parser.ParseException;

/**
 * A specific goal event that represents an executed goal event.
 */
public class GoalExecutingEvent extends GoalEvent {

    /**
     * Creates an instance of {@link GoalExecutingEvent}.
     * @param reasoningCycleNum the reasoning cycle number
     * @param goal the trigger of the goal
     * @param reason the reason of the executing event
     */
    public GoalExecutingEvent(int reasoningCycleNum, Trigger goal, Term reason) throws ParseException {
        super(reasoningCycleNum, goal, GoalListener.GoalStates.executing, reason);
    }

}
