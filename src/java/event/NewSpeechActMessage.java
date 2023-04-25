package event;

import event.eventInfo.MessageInfo;
import jason.asSemantics.Message;

/**
 * An event that represents a new speech act message from other agents.
 */
public class NewSpeechActMessage implements Event {

    private final MessageInfo message;

    /**
     * Creates a new {@link NewSpeechActMessage}.
     * @param message the message information
     */
    public NewSpeechActMessage(Message message) {
        this.message = new MessageInfo(message);
    }

    @Override
    public String logEvent() {
        return "Receive new " + message.getType() + " message from " + message.getSender() + ": " + message.getMessage();
    }
}
