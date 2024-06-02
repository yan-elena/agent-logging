package event.eventInfo;

import jason.asSyntax.Plan;
import jason.asSyntax.Trigger;

/**
 * A class that save the relevant information about a plan.
 */
public class PlanInfo {

    private final String label;
    private final String trigger;
    private final String context;
    private final String body;
    private final String log;

    /**
     * Creates a new instance of {@link PlanInfo}.
     * @param plan the {@link Plan} from which the information is to be extracted
     */
    public PlanInfo(Plan plan) {
        this.label = plan.getLabel().getFunctor();
        this.trigger = plan.getTrigger().getLiteral().toString();
        this.context = plan.getContext() != null ? plan.getContext().toString() : "";
        this.body = plan.getBody() != null ? plan.getBody().toString() : "";
        this.log = this.toString();
    }

    /**
     * Retrieves the label of the plan.
     * @return plan label
     */
    public String getLabel() {
        return label;
    }

    /**
     * Retrieves the triggered event of the plan.
     * @return trigger event
     */
    public String getTrigger() {
        return trigger;
    }

    /**
     * Retrieves the context of the plan.
     * @return plan context
     */
    public String getContext() {
        return context;
    }

    /**
     * Retrieves the body of the plan.
     * @return plan body
     */
    public String getBody() {
        return body;
    }

    public String getLog() {
        return log;
    }

    @Override
    public String toString() {
        StringBuilder out = new StringBuilder();
        out.append("\t@").append(label).append(" ").append(trigger);
        if (!context.isEmpty()) {
            out.append(" : ").append(context);
        }
        if (!body.isEmpty()) {
            out.append(" <- ").append(body);
        }
        out.append(".");
        return out.toString();
    }
}
