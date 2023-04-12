package event;

import jason.asSemantics.Option;
import jason.asSyntax.Plan;
import jason.asSyntax.Trigger;

import java.util.List;

/**
 * A class that representing an event for a plan selection.
 */
public class SelectPlanEvent extends AbstractEvent {

    private static final long LIMIT_OPTIONS = 5;

    private final String event;
    private final List<String> planOptions;
    private String selectedPlan;

    /**
     * Creates an instance of  {@link SelectPlanEvent}.
     * @param reasoningCycleNum the number of the reasoning cycle
     * @param trigger the trigger of the event
     * @param options a list of options to select from
     */
    public SelectPlanEvent(int reasoningCycleNum, Trigger trigger, List<Option> options) {
        super(reasoningCycleNum);
        this.event = trigger.getLiteral().getFunctor();
        this.planOptions = options.stream().limit(LIMIT_OPTIONS).map(p -> planToString(p.getPlan(), false)).toList();
        if (planOptions.size() > LIMIT_OPTIONS) {
            planOptions.add("...");
        }
    }

    /**
     * Returns a list of plan options to select from.
     * @return list of plan options
     */
    public List<String> getPlanOptions() {
        return planOptions;
    }

    /**
     * Returns the option that was selected.
     * @return the selected option
     */
    public String getSelected() {
        return selectedPlan;
    }

    /**
     * Sets the selected option.
     * @param selected the selected option
     */
    public void setSelected(Option selected) {
        this.selectedPlan = planToString(selected.getPlan(), true);
    }

    @Override
    public String eventToString() {
        StringBuilder out = new StringBuilder();
        if (planOptions.size() > 1) {
            out.append("Plan options for ").append(event).append(" are: \n");
            planOptions.forEach(op -> out.append("\t").append(op).append("\n"));
        }
        if (selectedPlan != null) {
            out.append("The plan selected for ").append(event).append(" is ").append(selectedPlan);
        }
        return out.toString();
    }

    private String planToString(Plan plan, boolean withBody) {
        StringBuilder out = new StringBuilder();
        out.append(plan.getTrigger());
        if (plan.getContext() != null) {
            out.append(plan.getContext());
        }
        if (withBody && !plan.getBody().isEmptyBody()) {
            out.append(" <- ").append(plan.getBody());
        }
        out.append(".");
        return out.toString();
    }
}
