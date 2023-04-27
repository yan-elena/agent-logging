package event.eventInfo;

import jason.asSemantics.Message;

/**
 * A class that save the relevant information about a message.
 */
public class MessageInfo {

    private final String id;
    private final String type;
    private final String sender;
    private final String receiver;
    private final String message;

    /**
     * Creates a new instance of {@link MessageInfo}.
     * @param message the {@link Message} from which the information is to be extracted
     */
    public MessageInfo(Message message) {
        this.id = message.getMsgId();
        this.type = message.getIlForce();
        this.sender = message.getSender();
        this.receiver = message.getReceiver();
        this.message = message.getPropCont().toString();
    }

    /**
     * Retrieves the id of the message.
     * @return message id
     */
    public String getId() {
        return id;
    }

    /**
     * Retrieves the type of the message: tell/achieve/askOne
     * @return message type
     */
    public String getType() {
        return type;
    }

    /**
     * Retrieves the sender of the message.
     * @return message sender
     */
    public String getSender() {
        return sender;
    }

    /**
     * Retrieves the receiver of the message.
     * @return message receiver
     */
    public String getReceiver() {
        return receiver;
    }

    /**
     * Retrieves the content of the message.
     * @return message content
     */
    public String getMessage() {
        return message;
    }

    @Override
    public String toString() {
        return "[" + type + " message]" + " from " + sender + ": " + message;
    }
}
