package event.goalEvent;

import event.Event;
import event.eventInfo.GoalInfo;
import event.eventInfo.ReasonInfo;
import jason.asSemantics.GoalListener.GoalStates;
import jason.asSyntax.Term;
import jason.asSyntax.Trigger;

import java.util.Optional;

/**
 * An abstract class that representing an event related to a goal.
 */
public abstract class GoalEvent implements Event {

    protected GoalInfo goalInfo;
    protected Optional<ReasonInfo> reasonInfo;

    /**
     * Creates an instance of {@link GoalEvent}.
     * @param goal the trigger of the goal
     */
    public GoalEvent(Trigger goal, GoalStates states) {
        this.goalInfo = new GoalInfo(goal, states);
        this.reasonInfo = Optional.empty();
    }

    /**
     * Creates an instance of {@link GoalEvent} with a reason.
     * @param goal the trigger of the goal
     * @param reason the reason of the event
     */
    public GoalEvent(Trigger goal, GoalStates states, Term reason) {
        this.goalInfo = new GoalInfo(goal, states);
        this.reasonInfo = reason != null ? Optional.of(new ReasonInfo(reason)) : Optional.empty();
    }

    /**
     * Returns the goal information associated with the event.
     * @return the goal
     */
    public GoalInfo getGoalInfo() {
        return goalInfo;
    }

    /**
     * Returns the reason of a specific goal event.
     * @return the reason of the goal
     */
    public Optional<ReasonInfo> getReasonInfo() {
        return reasonInfo;
    }

    @Override
    public String logEvent() {
        return "Goal " + this.goalInfo.getGoalFunctor() + " " + this.goalInfo.getGoalStates() + this.reasonInfo.map(ReasonInfo::toString).orElse("");
    }
}
