package event.signalEvent;

import event.Event;
import event.eventInfo.ArtifactSignalInfo;
import jason.asSyntax.Trigger;

/**
 * An event that represents a new signal from the artifact.
 */
public class NewArtifactSignal implements Event {

    private final ArtifactSignalInfo signalInfo;

    /**
     * Creates a new instance of {@link NewArtifactSignal} with the given trigger signal.
     * @param trigger the signal trigger
     */
    public NewArtifactSignal(Trigger trigger) {
        this.signalInfo = new ArtifactSignalInfo(trigger);
    }

    @Override
    public String logEvent() {
        return "New " + signalInfo.getPerceptType() + " signal from " + signalInfo.getArtifactName() + ": " + signalInfo.getFunctor();
    }
}
