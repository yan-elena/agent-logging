package event.goalEvent;

import event.eventInfo.IntentionInfo;
import jason.asSemantics.Event;
import jason.asSemantics.GoalListener.GoalStates;

import java.util.Optional;

/**
 * A specific goal event that represents a new goal is created and added to the event queue.
 */
public class GoalCreated extends GoalEvent {

    private final Optional<IntentionInfo> intention;

    /**
     * Creates an instance of {@link GoalCreated}.
     *
     * @param goal the trigger of the goal
     */
    public GoalCreated(Event goal) {
        super(goal.getTrigger(), GoalStates.pending);
        this.intention = goal.getIntention() != null ? Optional.of(new IntentionInfo(goal.getIntention())) : Optional.empty();
    }

    @Override
    public String logEvent() {
        StringBuilder log = new StringBuilder();
        log.append("Goal ").append(this.getGoalInfo().getGoalFunctor());
        if (intention.isPresent() && intention.get().peekFirstIntendedMeans().isPresent()) {
            log.append(" (sub-goal of ").append(intention.get().peekFirstIntendedMeans().get().getTrigger()).append(")");
        }
        log.append(" created");
        return log.toString();
    }
}
