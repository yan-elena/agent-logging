package event.speechActMessageEvent;

import event.Event;
import event.eventInfo.MessageInfo;
import jason.asSemantics.Message;

public class SendMessage implements Event {

    private final MessageInfo messageInfo;

    public SendMessage(Message message) {
        this.messageInfo = new MessageInfo(message);
    }

    @Override
    public String logEvent() {
        return "Send " + messageInfo.getType() + " message to " + messageInfo.getReceiver() + ": " + messageInfo.getMessage();
    }
}
