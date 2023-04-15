package eventInfo;

import jason.asSemantics.GoalListener.GoalStates;
import jason.asSyntax.Term;
import jason.asSyntax.Trigger;

import java.util.Optional;

/**
 * A class that save the relevant information about a goal and its associated states.
 */
public class GoalInfo {

    private final String goalFunctor;
    private final GoalStates goalStates;
    private Optional<String> reason;
//    private final String sourceInfo;

    /**
     * Creates a new instance of {@link GoalInfo} from the given goal and state.
     * @param goal a {@link Trigger} object that represents the goal
     * @param state a {@link GoalStates} object that represents the goal current state
     */
    public GoalInfo(Trigger goal, GoalStates state) {
        this.goalFunctor = goal.getLiteral().getFunctor();
        this.goalStates = state;
        this.reason = Optional.empty();
//        this.sourceInfo = goal.getSrcInfo();
    }

    /**
     * Creates a new instance of {@link GoalInfo} from the given goal and state.
     * @param goal a {@link Trigger} object that represents the goal
     * @param state a {@link GoalStates} object that represents the goal current state
     */
    public GoalInfo(Trigger goal, GoalStates state, Term reason) {
        this.goalFunctor = goal.getLiteral().getFunctor();
        this.goalStates = state;
        this.reason = Optional.ofNullable(reason.toString());
//        this.sourceInfo = goal.getSrcInfo();
    }

    /**
     * Returns the functor of the goal associated with the event.
     * @return the goal functor
     */
    public String getGoalFunctor() {
        return goalFunctor;
    }

    /**
     * Returns the state of the goal associated with the event.
     * @return the state of the goal
     */
    public GoalStates getGoalStates() {
        return goalStates;
    }

    /**
     * Returns the reason of a specific goal event.
     * @return the reason of the goal
     */
    public Optional<String> getReason() {
        return reason;
    }

    /**
     * Sets the reason of the goal event.
     * @param reason the reason to set
     */
    public void setReason(Term reason) {
        this.reason = Optional.ofNullable(reason).map(Term::toString);
    }

//    public String getSourceInfo() {
//        return sourceInfo;
//    }
}
