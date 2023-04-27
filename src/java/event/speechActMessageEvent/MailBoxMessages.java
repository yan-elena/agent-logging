package event.speechActMessageEvent;

import event.Event;
import event.eventInfo.MessageInfo;
import jason.asSemantics.Message;

import java.util.List;

/**
 * An event that represent messages in the agent mailbox.
 */
public class MailBoxMessages implements Event {

    private final List<MessageInfo> messages;

    /**
     * Creates a new instance of {@link MailBoxMessages} with the list of messages.
     * @param messages a list of messages
     */
    public MailBoxMessages(List<Message> messages) {
        this.messages = messages.stream().map(MessageInfo::new).toList();
    }

    /**
     * Retrieves the list of messages in the agent's mailbox.
     * @return list of messages
     */
    public List<MessageInfo> getMessages() {
        return messages;
    }

    @Override
    public String logEvent() {
        return "Messages in mailbox: \n\t" + String.join("\n\t", messages.stream().map(MessageInfo::toString).toList());
    }
}
