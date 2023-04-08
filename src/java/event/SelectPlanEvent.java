package event;

import jason.asSemantics.Option;
import jason.asSyntax.Plan;
import jason.asSyntax.Trigger;

import java.util.LinkedList;
import java.util.List;

public class SelectPlanEvent extends AbstractEvent {

    private final Trigger trigger;

    private final List<Option> options;
    private Option selected;

    public SelectPlanEvent(int reasoningCycleNum, Trigger trigger, List<Option> options) {
        super(reasoningCycleNum);
        this.trigger = trigger;
        this.options = new LinkedList<>(options);
    }

    public Trigger getTrigger() {
        return trigger;
    }

    public List<Option> getOptions() {
        return options;
    }

    public Option getSelected() {
        return selected;
    }

    public void setSelected(Option selected) {
        this.selected = selected;
        System.out.println(this); // todo canc
    }

    @Override
    public String eventToString() {
        StringBuilder out = new StringBuilder();
        if (options.size() > 1) {
            out.append("Plan options for ").append(trigger.getLiteral().getFunctor()).append(" are: \n");
            options.forEach(op -> out.append("\t\t").append(planToString(op.getPlan())).append("\n"));
        }
        if (selected != null) {
            out.append("Selected plan: ").append(planToString(selected.getPlan()));
        }
        return out.toString();
    }

    private String planToString(Plan plan) {
        StringBuilder out = new StringBuilder();
        out.append(plan.getTrigger());
        if (plan.getContext() != null) {
            out.append(plan.getContext());
        }
        if (!plan.getBody().isEmptyBody()) {
            out.append(" <- ").append(plan.getBody());
        }
        out.append(".");
        return out.toString();
    }
}
