package event.eventInfo;

import jason.asSemantics.Intention;
import jason.asSyntax.ListTermImpl;
import jason.asSyntax.PlanBody;
import jason.asSyntax.Structure;
import jason.asSyntax.Trigger;

import java.util.LinkedList;
import java.util.List;

/**
 * A class that save the relevant information about an intention.
 */
public class IntentionInfo {

    private final int id;
    private final Intention.State state;
    private final LinkedList<IntendedMeansInfo> intendedMeansInfo;

    private final String trigger;
    private final List<String> planBody;

    /**
     * Creates a new instance of {@link IntentionInfo} from the given intention.
     * @param intention the intention of the agent
     */
    public IntentionInfo(Intention intention) {
        this.id = intention.getId();
        this.state = intention.getStateBasedOnPlace();


        intendedMeansInfo = new LinkedList<>();
        intention.spliterator().forEachRemaining(intendedMeans -> intendedMeansInfo.add(new IntendedMeansInfo(intendedMeans)));




        this.planBody = new LinkedList<>();

        ListTermImpl terms = (ListTermImpl) intention.getAsTerm().getTerm(1);
        if (!terms.isEmpty()) {
            Structure structure = ((Structure) terms.getTerm(0));
            PlanBody planBody = (PlanBody) structure.getTerm(2);

            this.trigger = ((Trigger)structure.getTerm(1)).getLiteral().getFunctor();
            while (planBody != null) {
                this.planBody.add(planBody.toString());
                planBody = planBody.getBodyNext();
            }
        } else {
            this.trigger = intention.toString().substring(intention.toString().indexOf("<"));
        }
    }

    public IntendedMeansInfo peekFirstIntendedMeans() {
        return intendedMeansInfo.peekFirst();
    }

    /**
     * Returns the id of the intention.
     * @return intention id
     */
    public int getId() {
        return id;
    }

    /**
     * Returns the state of the intention.
     * @return intention state
     */
    public Intention.State getState() {
        return state;
    }

    /**
     * Returns the trigger of the intention.
     * @return intention trigger
     */
    public String getTrigger() {
        return trigger;
    }

    /**
     * Returns the plan body of the intention.
     * @return intention plan body
     */
    public List<String> getPlanBody() {
        return planBody;
    }
}
