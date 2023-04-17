package event.goalEvent;

import jason.asSemantics.GoalListener.GoalStates;
import jason.asSyntax.Term;
import jason.asSyntax.Trigger;
import jason.asSyntax.parser.ParseException;

/**
 * A specific goal event that represents a failed goal event.
 */
public class GoalFailedEvent extends GoalEvent {

    /**
     * Creates an instance of {@link GoalFailedEvent}
     * @param reasoningCycleNum the reasoning cycle number
     * @param goal the trigger of the goal
     * @param reason the reason of the failed event
     */
    public GoalFailedEvent(int reasoningCycleNum, Trigger goal, Term reason) throws ParseException {
        super(reasoningCycleNum, goal, GoalStates.failed, reason);
    }
}
