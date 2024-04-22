package event.perceptEvent;

import event.Event;
import event.eventInfo.ArtifactEventInfo;
import jason.asSyntax.Trigger;

/**
 * An event that represents a new signal from the artifact.
 */
public class NewPercept implements Event {

    private final ArtifactEventInfo perceptInfo;

    /**
     * Creates a new instance of {@link NewPercept} with the given trigger percept.
     * @param trigger the percept trigger
     */
    public NewPercept(Trigger trigger) {
        this.perceptInfo = new ArtifactEventInfo(trigger);
    }

    @Override
    public String logEvent() {
        return "New " + perceptInfo.getPerceptType() + " percept " + perceptInfo.getFunctor() + " from " + perceptInfo.getArtifactName();
    }
}
