package event;

import jason.asSemantics.GoalListener.GoalStates;
import jason.asSyntax.Term;
import jason.asSyntax.Trigger;

import java.util.Optional;

/**
 * A class that representing an event related to a goal.
 */
public class GoalEvent extends AbstractEvent {

    private final GoalStates goalStates;
    private final Trigger goal;
    private final Optional<Term> reason;

    /**
     * Creates an instance of {@link GoalEvent}.
     * @param reasoningCycleNum the reasoning cycle number
     * @param goal the trigger of the goal
     * @param goalStates the state of the goal
     * @param reason an optional reason for the event
     */
    public GoalEvent(int reasoningCycleNum, Trigger goal, GoalStates goalStates, Term reason) {
        super(reasoningCycleNum);
        this.goal = goal;
        this.goalStates = goalStates;
        this.reason = Optional.ofNullable(reason);
    }

    @Override
    public String eventToString() {
        return "Goal " + goal.getLiteral().getFunctor() + " " + goalStates.name();
    }

    /**
     * Returns the state of the goal associated with the event.
     * @return the state of the goal
     */
    public GoalStates getGoalStates() {
        return goalStates;
    }

    /**
     * Returns the trigger of the goal associated with the event.
     * @return the trigger of the goal
     */
    public Trigger getGoal() {
        return goal;
    }

    /**
     * Returns an optional reason for the event.
     * @return an optional reason
     */
    public Optional<Term> getReason() {
        return reason;
    }
}
