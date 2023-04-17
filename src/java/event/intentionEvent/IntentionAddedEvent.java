package event.intentionEvent;

import jason.asSemantics.Intention;

public class IntentionAddedEvent extends IntentionEvent {

    public IntentionAddedEvent(int cycleNumber, Intention intention) {
        super(cycleNumber, intention);
    }
}
