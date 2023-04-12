package event;

import jason.asSemantics.GoalListener.GoalStates;
import jason.asSyntax.Trigger;

/**
 * A class that representing an event related to a goal.
 */
public class GoalEvent extends AbstractEvent {

    private final String goalStates;
    private final String goalFunctor;

    /**
     * Creates an instance of {@link GoalEvent}.
     * @param reasoningCycleNum the reasoning cycle number
     * @param goal the trigger of the goal
     * @param goalStates the state of the goal
     */
    public GoalEvent(int reasoningCycleNum, Trigger goal, GoalStates goalStates) {
        super(reasoningCycleNum);
        this.goalFunctor = goal.getLiteral().getFunctor();
        this.goalStates = goalStates.name();
    }

    @Override
    public String eventToString() {
        return "Goal " + goalFunctor + " " + goalStates;
    }

    /**
     * Returns the state of the goal associated with the event.
     * @return the state of the goal
     */
    public String getGoalStates() {
        return goalStates;
    }

    /**
     * Returns the functor of the goal associated with the event.
     * @return the functor of the goal
     */
    public String getGoalFunctor() {
        return goalFunctor;
    }

}
