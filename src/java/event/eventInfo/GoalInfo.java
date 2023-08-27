package event.eventInfo;

import jason.asSemantics.GoalListener.GoalStates;
import jason.asSemantics.Intention;
import jason.asSyntax.Trigger;

import java.util.Optional;

/**
 * A class that save the relevant information about a goal and its associated states.
 */
public class GoalInfo {

    private final String goalFunctor;
    private final Optional<IntentionInfo> intention;

    /**
     * Creates a new instance of {@link GoalInfo} from the given goal and state.
     * @param goal a {@link Trigger} object that represents the goal
     * @param intention the intention created from the goal
     */
    public GoalInfo(Trigger goal, Intention intention) {
        this.goalFunctor = goal.getLiteral().getFunctor();
        this.intention = intention == null ? Optional.empty() : Optional.of(new IntentionInfo(intention));
    }

    /**
     * Returns an optional of the intention associated to the goal.
     * @return intention
     */
    public Optional<IntentionInfo> getIntention() {
        return intention;
    }

    /**
     * Returns the functor of the goal associated with the event.
     * @return the goal functor
     */
    public String getGoalFunctor() {
        return goalFunctor;
    }

}
