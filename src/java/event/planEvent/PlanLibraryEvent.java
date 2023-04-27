package event.planEvent;

import event.Event;
import event.eventInfo.PlanInfo;
import jason.asSyntax.Plan;

import java.util.List;

/**
 * A class that representing the initial plan library event.
 */
public class PlanLibraryEvent implements Event {

    private final List<PlanInfo> plansInfo;

    /**
     * Creates a new instance of {@link PlanLibraryEvent} with the given plans.
     * @param plans a list of plan
     */
    public PlanLibraryEvent(List<Plan> plans) {
        plansInfo = plans.stream().map(PlanInfo::new).toList();
    }

    @Override
    public String logEvent() {
        return "plan library: \n" + String.join("\n", plansInfo.stream().map(PlanInfo::toString).toList());
    }
}
