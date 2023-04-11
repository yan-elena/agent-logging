package event;

import jason.asSemantics.Option;
import jason.asSyntax.Plan;
import jason.asSyntax.Trigger;

import java.util.LinkedList;
import java.util.List;

/**
 * A class that representing an event for a plan selection.
 */
public class SelectPlanEvent extends AbstractEvent {

    private static final long LIMIT_OPTIONS = 5;
    private final Trigger trigger;

    private final List<Option> options;
    private Option selected;

    /**
     * Creates an instance of  {@link SelectPlanEvent}.
     * @param reasoningCycleNum the number of the reasoning cycle
     * @param trigger the trigger of the event
     * @param options a list of options to select from
     */
    public SelectPlanEvent(int reasoningCycleNum, Trigger trigger, List<Option> options) {
        super(reasoningCycleNum);
        this.trigger = trigger;
        this.options = new LinkedList<>(options);
    }

    /**
     * Returns the trigger of the event.
     * @return the trigger
     */
    public Trigger getTrigger() {
        return trigger;
    }

    /**
     * Returns a list of options to select from.
     * @return
     */
    public List<Option> getOptions() {
        return options;
    }

    /**
     * Returns the option that was selected.
     * @return the selected option
     */
    public Option getSelected() {
        return selected;
    }

    /**
     * Sets the selected option.
     * @param selected the selected option
     */
    public void setSelected(Option selected) {
        this.selected = selected;
    }

    @Override
    public String eventToString() {
        StringBuilder out = new StringBuilder();
        if (options.size() > 1) {
            out.append("Plan options for ").append(trigger.getLiteral().getFunctor()).append(" are: \n");
            options.stream().limit(LIMIT_OPTIONS).forEach(op ->
                    out.append("\t").append(planToString(op.getPlan(), false)).append("\n"));
            if (options.size() > LIMIT_OPTIONS) {
                out.append("...");
            }
        }
        if (selected != null) {
            out.append("The plan selected for ").append(trigger.getLiteral().getFunctor()).append(" is ")
                    .append(planToString(selected.getPlan(), true));
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
