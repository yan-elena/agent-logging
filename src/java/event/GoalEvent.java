package event;

import jason.asSemantics.GoalListener.GoalStates;
import jason.asSyntax.Term;
import jason.asSyntax.Trigger;

import java.util.Optional;

public class GoalEvent extends AbstractEvent {

    private final GoalStates goalStates;
    private final Trigger goal;
    private final Optional<Term> reason;

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

    public GoalStates getGoalStates() {
        return goalStates;
    }

    public Trigger getGoal() {
        return goal;
    }

    public Optional<Term> getReason() {
        return reason;
    }
}
