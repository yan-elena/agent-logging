package event.intentionEvent;

import event.Event;
import jason.asSemantics.Intention;

public class IntentionDroppedEvent extends IntentionEvent {

    public IntentionDroppedEvent(int cycleNumber, Intention intention) {
        super(cycleNumber, intention);
    }
}
