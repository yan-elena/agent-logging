package event.goalEvent;

import event.eventInfo.ReasonInfo;
import jason.asSemantics.GoalListener;
import jason.asSyntax.ASSyntax;
import jason.asSyntax.Structure;
import jason.asSyntax.Term;
import jason.asSyntax.Trigger;
import jason.asSyntax.parser.ParseException;

import java.util.List;
import java.util.Optional;

/**
 * A specific goal event that represents an executed goal event.
 */
public class GoalExecutingEvent extends GoalEvent {

    /**
     * Creates an instance of {@link GoalExecutingEvent}.
     * @param reasoningCycleNum the reasoning cycle number
     * @param goal the trigger of the goal
     * @param reason the reason of the executing event
     */
    public GoalExecutingEvent(int reasoningCycleNum, Trigger goal, Term reason) {
        super(reasoningCycleNum, goal, GoalListener.GoalStates.executing);
        this.getGoalInfo().setReason(reason);
    }

    @Override
    public String logEvent() {
        StringBuilder out = new StringBuilder();
        out.append("Goal ").append(getGoalInfo().getGoalFunctor()).append(" ").append(getGoalInfo().getGoalStates());
        if (getGoalInfo().getReason().isPresent()) {
            Optional<ReasonInfo> reasonInfo = getGoalInfo().getReason();
            if (reasonInfo.isPresent()) {
                Optional<String> reasonFunctor = reasonInfo.get().getFunctor();
                Optional<List<String>> reasonTerm = reasonInfo.get().getTerms();
                if (reasonFunctor.isPresent() && reasonTerm.isPresent()) {
                    out.append(" because ").append(reasonFunctor.get().replace("_", " " + reasonTerm.get().get(0) + " is "));
                }
            } else {
                out.append(getGoalInfo().getReason());
            }
        }
        return out.toString();
    }
}
