package event.speechActMessageEvent;

import event.Event;
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
        return "New speech act message [" + message.getType() + "] from " + message.getSender() + ": " + message.getMessage();
    }
}
