package event.goalEvent;

import jason.asSemantics.GoalListener;
import jason.asSemantics.Intention;
import jason.asSyntax.Term;
import jason.asSyntax.Trigger;

/**
 * A specific goal event that represents a plan that was selected for a goal.
 */
public class PlanSelected extends GoalEvent {

    /**
     * Creates an instance of {@link PlanSelected}.
     * @param goal the trigger of the goal
     * @param reason the reason of the executing event
     */
    public PlanSelected(Trigger goal, Intention intention, Term reason) {
        super(goal, GoalListener.GoalStates.executing, intention, reason);
    }

    @Override
    public String logEvent() {
        return "Plan " + this.getGoalInfo().getGoalFunctor() + " selected, state: " +  this.getGoalStates();
    }
}
