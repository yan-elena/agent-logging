package event.eventInfo;

import jason.asSemantics.IntendedMeans;
import jason.asSyntax.PlanBody;

import java.util.Optional;

/**
 * A class that save the relevant information about an intended means.
 */
public class IntendedMeansInfo {

    private final String trigger;
    private final String type;
    private final PlanInfo plan;
    private final String unifier;
    private final Optional<String> currentStep;
    private final boolean isFinished;

    /**
     * Creates a new instance of {@link IntendedMeansInfo} from the given intended means.
     * @param intendedMeans the intendedMeans to extract the information
     */
    public IntendedMeansInfo(IntendedMeans intendedMeans) {
        this.trigger = intendedMeans.getTrigger().getLiteral().getFunctor();
        this.plan = new PlanInfo(intendedMeans.getPlan());
        this.unifier = intendedMeans.getUnif().toString();
        this.isFinished = intendedMeans.isFinished();
        this.currentStep = Optional.ofNullable(intendedMeans.getCurrentStep()).map(PlanBody::toString);
        this.type = intendedMeans.getTrigger().getType().name();
    }

    /**
     * Retrieve the trigger of the intention
     * @return the trigger
     */
    public String getTrigger() {
        return trigger;
    }

    /**
     * Retrieve the plan of the intended means.
     * @return the plan
     */
    public PlanInfo getPlan() {
        return plan;
    }

    /**
     * Retrieve the unifier of the intended means.
     * @return the unifier
     */
    public String getUnifier() {
        return unifier;
    }

    /**
     * Retrieve the current step of the plan body.
     * @return the current step
     */
    public Optional<String> getCurrentStep() {
        return currentStep;
    }

    /**
     * Retrieve the information of the finishing status.
     * @return finishing status
     */
    public boolean isFinished() {
        return isFinished;
    }

    /**
     * Retrieve the type of the trigger.
     * @return trigger type
     */
    public String getType() {
        return type;
    }

    @Override
    public String toString() {
        return "IntendedMeansInfo{" +
                "trigger='" + trigger + '\'' +
                ", type='" + type + '\'' +
                ", plan=" + plan +
                ", unifier='" + unifier + '\'' +
                ", currentStep=" + currentStep +
                ", isFinished=" + isFinished +
                '}';
    }
}
