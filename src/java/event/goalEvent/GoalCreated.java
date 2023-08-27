package event.goalEvent;

import jason.asSemantics.Event;
import jason.asSemantics.GoalListener.GoalStates;

/**
 * A specific goal event that represents a new goal is created and added to the event queue.
 */
public class GoalCreated extends GoalEvent {

    /**
     * Creates an instance of {@link GoalCreated}.
     *
     * @param goal the trigger of the goal
     */
    public GoalCreated(Event goal) {
        super(goal.getTrigger(), GoalStates.pending, goal.getIntention());
    }


    @Override
    public String logEvent() {
        StringBuilder log = new StringBuilder();
        log.append("Goal ").append(this.getGoalInfo().getGoalFunctor());
        if (goalInfo.getIntention().isPresent() && goalInfo.getIntention().get().peekFirstIntendedMeans().isPresent()) {
            log.append(" (sub-goal of ").append(goalInfo.getIntention().get().peekFirstIntendedMeans().get().getTrigger()).append(")");
        }
        log.append(" created");
        return log.toString();
    }
}
