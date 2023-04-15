package event.goalEvent;

import jason.asSemantics.GoalListener;
import jason.asSyntax.ASSyntax;
import jason.asSyntax.Structure;
import jason.asSyntax.Term;
import jason.asSyntax.Trigger;
import jason.asSyntax.parser.ParseException;

/**
 * A specific goal event that represents an executed goal event.
 */
public class GoalExecutingEvent extends GoalEvent {

    /**
     * Creates an instance of {@link GoalExecutingEvent}
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
            try {
                Term reason = ASSyntax.parseTerm(getGoalInfo().getReason().get());
                if (reason.isStructure()) {
                    Structure reasonStruct = ASSyntax.parseStructure(reason.toString());
                    out.append(" because ").append(reasonStruct.getFunctor().replace("_",
                            " " + reasonStruct.getTerm(0).toString()  + " is "));
                } else {
                    out.append(" with reason: ").append(getGoalInfo().getReason().get());
                }
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }
        return out.toString();
    }
}
