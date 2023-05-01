package event.eventInfo;

import jason.asSemantics.Intention;

import java.util.LinkedList;
import java.util.Optional;

/**
 * A class that save the relevant information about an intention.
 */
public class IntentionInfo {

    private final int id;
    private final Intention.State state;
    private final LinkedList<IntendedMeansInfo> intendedMeansInfo;

    /**
     * Creates a new instance of {@link IntentionInfo} from the given intention.
     * @param intention the intention of the agent
     */
    public IntentionInfo(Intention intention) {
        this.id = intention.getId();
        this.state = intention.getStateBasedOnPlace();

        intendedMeansInfo = new LinkedList<>();
        intention.spliterator().forEachRemaining(intendedMeans -> intendedMeansInfo.add(new IntendedMeansInfo(intendedMeans)));

    }

    /**
     * Returns the first intended means of the intention, if exists.
     * @return an optional of first im
     */
    public Optional<IntendedMeansInfo> peekFirstIntendedMeans() {
        return Optional.ofNullable(intendedMeansInfo.peekFirst());
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

}
