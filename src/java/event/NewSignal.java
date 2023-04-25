package event;

import event.eventInfo.SignalInfo;
import jason.asSyntax.Trigger;

/**
 * An event that represents a new signal from the artifact.
 */
public class NewSignal implements Event {

    private final SignalInfo signalInfo;

    /**
     * Creates a new instance of {@link NewSignal} with the given trigger signal.
     * @param trigger the signal trigger
     */
    public NewSignal(Trigger trigger) {
        this.signalInfo = new SignalInfo(trigger);
    }

    @Override
    public String logEvent() {
        return "New " + signalInfo.getPerceptType() + " signal from " + signalInfo.getArtifactName() + ": " + signalInfo.getFunctor();
    }
}
