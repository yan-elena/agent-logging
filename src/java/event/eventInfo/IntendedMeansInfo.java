package event.eventInfo;

import jason.asSemantics.IntendedMeans;
import jason.asSyntax.PlanBody;

import java.util.Optional;

public class IntendedMeansInfo {

    private final String trigger;
    private final PlanInfo plan;
    private final String unifier;
    private final Optional<String> currentStep;

    public IntendedMeansInfo(IntendedMeans intendedMeans) {
        this.trigger = intendedMeans.getTrigger().toString();
        this.plan = new PlanInfo(intendedMeans.getPlan());
        this.unifier = intendedMeans.getUnif().toString();
        this.currentStep = Optional.ofNullable(intendedMeans.getCurrentStep()).map(PlanBody::toString);
    }

    public String getTrigger() {
        return trigger;
    }

    public PlanInfo getPlan() {
        return plan;
    }

    public String getUnifier() {
        return unifier;
    }

    public Optional<String> getCurrentStep() {
        return currentStep;
    }
}
