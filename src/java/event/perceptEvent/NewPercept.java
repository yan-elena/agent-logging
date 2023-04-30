package event.perceptEvent;

import event.Event;
import event.eventInfo.PerceptInfo;
import jason.asSyntax.Trigger;

/**
 * An event that represents a new signal from the artifact.
 */
public class NewPercept implements Event {

    private final PerceptInfo perceptInfo;

    /**
     * Creates a new instance of {@link NewPercept} with the given trigger percept.
     * @param trigger the percept trigger
     */
    public NewPercept(Trigger trigger) {
        this.perceptInfo = new PerceptInfo(trigger);
    }

    @Override
    public String logEvent() {
        return "New " + perceptInfo.getPerceptType() + " percept from " + perceptInfo.getArtifactName() + ": " + perceptInfo.getFunctor();
    }
}
