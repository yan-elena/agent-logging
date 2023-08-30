package event.planEvent;

import event.Event;
import event.eventInfo.PlanInfo;
import jason.asSyntax.Plan;

/**
 * An event that represents the addition of a plan to the agent's plan library.
 */
public class PlanAdded implements Event {

    private final PlanInfo planInfo;

    /**
     * Creates a new instance of {@link PlanAdded} from the given plan.
     * @param plan the plan to add
     */
    public PlanAdded(Plan plan) {
        this.planInfo = new PlanInfo(plan);
    }

    @Override
    public String logEvent() {
        return "Plan " + planInfo.getTrigger() + planInfo.getContext() + " added to the plan library";
    }
}
