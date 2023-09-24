package event.planEvent;

import event.Event;
import event.eventInfo.PlanInfo;
import jason.asSyntax.Plan;

/**
 * An event that represents the deletion of a plan to the agent's plan library.
 */
public class PlanRemoved implements Event {

    private final PlanInfo planInfo;

    /**
     * Creates a new instance of {@link PlanRemoved} from the given plan.
     * @param plan the plan to remove
     */
    public PlanRemoved(Plan plan) {
        this.planInfo = new PlanInfo(plan);
    }

    @Override
    public String logEvent() {
        return "Plan " + planInfo.getTrigger() + planInfo.getContext() + " removed from the plan library";
    }
}
