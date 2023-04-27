package event.speechActMessageEvent;

import event.Event;
import event.eventInfo.MessageInfo;
import jason.asSemantics.Message;

/**
 * An event that represent the selection of a message.
 */
public class SelectedMessage implements Event {

    private final MessageInfo selected;

    /**
     * Creates a new instance of {@link SelectedMessage} event.
     * @param message the selected message
     */
    public SelectedMessage(Message message) {
        this.selected = new MessageInfo(message);
    }

    @Override
    public String logEvent() {
        return "Selected Message: " + this.selected.getMessage();
    }
}
