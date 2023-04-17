package event.eventInfo;

import jason.asSemantics.Intention;
import jason.asSyntax.*;
import jason.stdlib.structure;

import java.util.LinkedList;
import java.util.List;

/**
 * A class that save the relevant information about an intention.
 */
public class IntentionInfo {

    private final int id;
    private final Intention.State state;
    private final String trigger;
    private final List<String> planBody;

    /**
     * Creates a new instance of {@link IntentionInfo} from the given intention.
     * @param intention the intention of the agent
     */
    public IntentionInfo(Intention intention) {
        this.id = intention.getId();
        this.state = intention.getStateBasedOnPlace();
        this.planBody = new LinkedList<>();

        ListTermImpl terms = (ListTermImpl) intention.getAsTerm().getTerm(1);
        if (!terms.isEmpty()) {
            Structure structure = ((Structure) terms.getTerm(0));
            PlanBody planBody = (PlanBody) structure.getTerm(2);

            this.trigger = structure.getTerm(1).toString();
            while (planBody != null) {
                this.planBody.add(planBody.toString());
                planBody = planBody.getBodyNext();
            }
        } else {
            System.out.println(intention);
            this.trigger = intention.toString();
        }
    }

    /**
     * Returns the state of the intention.
     * @return intention state
     */
    public Intention.State getState() {
        return state;
    }

    @Override
    public String toString() {
        return "intention " + id +
                " state=" + state +
                ":\ntrigger=" + trigger +
                "\nplanBody=" + planBody;
    }
}
