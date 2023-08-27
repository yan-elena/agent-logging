package event.goalEvent;

import event.Event;
import event.eventInfo.GoalInfo;
import event.eventInfo.ReasonInfo;
import jason.asSemantics.GoalListener.GoalStates;
import jason.asSemantics.Intention;
import jason.asSyntax.Term;
import jason.asSyntax.Trigger;

import java.util.Optional;

/**
 * An abstract class that representing an event related to a goal.
 */
public abstract class GoalEvent implements Event {

    protected final GoalInfo goalInfo;
    private final GoalStates goalStates;
    protected final Optional<ReasonInfo> reasonInfo;

    /**
     * Creates an instance of {@link GoalEvent}.
     * @param goal the trigger of the goal
     * @param states a {@link GoalStates} object that represents the goal current state
     * @param intention the intention created from the goal
     */
    public GoalEvent(Trigger goal, GoalStates states, Intention intention) {
        this.goalInfo = new GoalInfo(goal, intention);
        this.goalStates = states;
        this.reasonInfo = Optional.empty();
    }

    /**
     * Creates an instance of {@link GoalEvent} with a reason.
     * @param goal the trigger of the goal
     * @param intention the intention created from the goal
     * @param reason the reason of the event
     */
    public GoalEvent(Trigger goal, GoalStates states, Intention intention, Term reason) {
        this.goalInfo = new GoalInfo(goal, intention);
        this.goalStates = states;
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
    public Optional<ReasonInfo> getReasonInfo() {
        return reasonInfo;
    }

    @Override
    public String logEvent() {
        return "Goal " + this.goalInfo.getGoalFunctor() + " " + goalStates + this.reasonInfo.map(ReasonInfo::toString).orElse(
                "");
    }
}
