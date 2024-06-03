package event.speechActMessageEvent;

import event.Event;
import event.eventInfo.IntentionInfo;
import event.eventInfo.MessageInfo;
import jason.asSemantics.Intention;
import jason.asSemantics.Message;

/**
 * the event representing the sending of a message by the agent.
 */
public class SendMessage implements Event {

    private final MessageInfo messageInfo;
    private final IntentionInfo intentionInfo;

    /**
     * Creates a new instance of {@link SendMessage} from the given message.
     *
     * @param message           the message to send
     * @param intention         the current selected intention
     */
    public SendMessage(Message message, Intention intention) {
        this.messageInfo = new MessageInfo(message);
        this.intentionInfo = new IntentionInfo(intention);
    }

    @Override
    public String logEvent() {
        return "Send " + messageInfo.getType() + " message to " + messageInfo.getReceiver() + ": " + messageInfo.getMessage();
    }
}
