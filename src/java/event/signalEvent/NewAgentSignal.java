package event.signalEvent;

import event.Event;
import event.eventInfo.AgentSignalInfo;
import jason.asSyntax.Trigger;

/**
 * An event that represents a new signal from an agent.
 */
public class NewAgentSignal implements Event {

    private final AgentSignalInfo signalInfo;

    /**
     * Creates a new instance of {@link NewAgentSignal} with the given trigger signal.
     * @param trigger the signal trigger
     */
    public NewAgentSignal(Trigger trigger) {
        this.signalInfo = new AgentSignalInfo(trigger);
    }

    @Override
    public String logEvent() {
        return "New signal from " + signalInfo.getSource() + ": " + signalInfo.getFunctor();
    }
}