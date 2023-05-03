package event.speechActMessageEvent;

import event.Event;
import event.eventInfo.MessageInfo;
import jason.asSemantics.Message;

/**
 * the event representing the sending of a message by the agent.
 */
public class SendMessage implements Event {

    private final MessageInfo messageInfo;

    /**
     * Creates a new instance of {@link SendMessage} from the given message.
     * @param message the message to send
     */
    public SendMessage(Message message) {
        this.messageInfo = new MessageInfo(message);
    }

    @Override
    public String logEvent() {
        return "Send " + messageInfo.getType() + " message to " + messageInfo.getReceiver() + ": " + messageInfo.getMessage();
    }
}
