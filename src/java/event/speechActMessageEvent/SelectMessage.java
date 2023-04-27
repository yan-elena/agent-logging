package event.speechActMessageEvent;

import event.Event;
import event.eventInfo.MessageInfo;
import jason.asSemantics.Message;

import java.util.List;

public class SelectMessage implements Event {

    private final List<MessageInfo> messages;
    private MessageInfo selected;

    public SelectMessage(List<Message> messages) {
        this.messages = messages.stream().map(MessageInfo::new).toList();
    }

    public List<MessageInfo> getMessages() {
        return messages;
    }

    public void setSelected(Message message) {
        this.selected = new MessageInfo(message);
    }

    @Override
    public String logEvent() {
        return "Select Message from: \n\t" +
                String.join("\n\t", messages.stream().map(MessageInfo::toString).toList()) +
                "\nSelected Message: " + this.selected.getMessage();
    }
}
