package event.intentionEvent;

import event.Event;
import jason.asSemantics.Intention;
import jason.asSyntax.Term;

public class IntentionSuspendedEvent extends IntentionEvent {

    public IntentionSuspendedEvent(int cycleNumber, Intention intention, Term reason) {
        super(cycleNumber, intention, reason);
    }
}
