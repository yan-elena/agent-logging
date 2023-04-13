package eventInfo;

import jason.asSemantics.GoalListener.GoalStates;
import jason.asSyntax.Trigger;

/**
 * A class that save the relevant information about a goal and its associated states.
 */
public class GoalInfo {

    private final String goalFunctor;
    private final GoalStates goalStates;
//    private final String sourceInfo;

    /**
     * Creates a new instance of {@link GoalInfo} from the given goal and state.
     * @param goal a {@link Trigger} object that represents the goal
     * @param state a {@link GoalStates} object that represents the goal current state
     */
    public GoalInfo(Trigger goal, GoalStates state) {
        this.goalFunctor = goal.getLiteral().getFunctor();
        goalStates = state;
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

//    public String getSourceInfo() {
//        return sourceInfo;
//    }
}
