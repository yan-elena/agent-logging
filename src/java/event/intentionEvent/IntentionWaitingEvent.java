package event.intentionEvent;

import event.Event;
import jason.asSemantics.Intention;
import jason.asSyntax.Term;

public class IntentionWaitingEvent extends IntentionEvent {

    public IntentionWaitingEvent(int cycleNumber, Intention intention, Term reason) {
        super(cycleNumber, intention, reason);
    }
}
