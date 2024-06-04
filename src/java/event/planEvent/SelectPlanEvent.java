package event.planEvent;

import event.Event;
import event.eventInfo.PlanInfo;
import jason.asSemantics.Option;
import jason.asSyntax.Term;
import jason.asSyntax.Trigger;

import java.util.List;
import java.util.Optional;

/**
 * A class that representing an event for a plan selection.
 */
public class SelectPlanEvent implements Event {

    private final String event;
    private final Optional<List<String>> sources;
    private final List<PlanInfo> planOptions;
    private PlanInfo selectedPlan;

    /**
     * Creates an instance of  {@link SelectPlanEvent}.
     * @param trigger the trigger of the event
     * @param options a list of options to select from
     */
    public SelectPlanEvent(Trigger trigger, List<Option> options) {
        this.event = trigger.getLiteral().getFunctor();
        this.sources = trigger.getLiteral().getSources() == null ? Optional.empty() : Optional.of(trigger.getLiteral().getSources().getAsList().stream().map(Term::toString).toList());
        this.planOptions = options.stream().map(p -> new PlanInfo(p.getPlan())).toList();
    }

    /**
     * Returns a list of plan options to select from.
     * @return list of {@link PlanInfo} options
     */
    public List<PlanInfo> getPlanOptions() {
        return planOptions;
    }

    /**
     * Returns the option that was selected.
     * @return the selected option
     */
    public PlanInfo getSelected() {
        return selectedPlan;
    }

    /**
     * Sets the selected option.
     * @param selected the selected option
     */
    public void setSelected(Option selected) {
        this.selectedPlan = new PlanInfo(selected.getPlan());
    }

    @Override
    public String logEvent() {
        StringBuilder log = new StringBuilder();
        log.append("Plan options for ").append(event).append(" are: \n");
        log.append(String.join("\n", planOptions.stream().map(PlanInfo::toString).toList()));
        if (selectedPlan != null) {
            log.append("\nThe plan selected for ").append(event).append(" is @").append(selectedPlan.getLabel())
                    .append(" ").append(selectedPlan.getTrigger());
        }
        return log.toString();
    }
}
