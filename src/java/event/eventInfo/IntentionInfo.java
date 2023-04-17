package event.eventInfo;

import jason.asSemantics.Intention;
import jason.asSyntax.*;

import java.util.LinkedList;
import java.util.List;

public class IntentionInfo {

    private final int id;
    private final String trigger;
    private final List<String> planBody;

    public IntentionInfo(Intention intention) {
        this.id = intention.getId();
        Structure structure = ((Structure) ((ListTermImpl) intention.getAsTerm().getTerm(1)).getTerm(0));
        PlanBody planBody = (PlanBody) structure.getTerm(2);

        this.trigger = structure.getTerm(1).toString();
        this.planBody = new LinkedList<>();
        while (planBody != null) {
            this.planBody.add(planBody.toString());
            planBody = planBody.getBodyNext();
        }
        System.out.println(this);
    }

    @Override
    public String toString() {
        return "intention " + id +
                ":\ntrigger=" + trigger +
                "\nplanBody=" + planBody;
    }
}
