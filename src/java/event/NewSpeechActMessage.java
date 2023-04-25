package event;

import event.eventInfo.MessageInfo;

/**
 * An event that represents a new speech act message from other agents.
 */
public class NewSpeechActMessage implements Event {

    private final MessageInfo message;

    /**
     * Creates a new {@link NewSpeechActMessage}.
     * @param message the message information
     */
    public NewSpeechActMessage(MessageInfo message) {
        this.message = message;
    }

    @Override
    public String logEvent() {
        return "Receive new " + message.getType() + " message from " + message.getSender() + ": " + message.getMessage();
    }
}
