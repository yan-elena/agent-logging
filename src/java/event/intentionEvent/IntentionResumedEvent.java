package event.intentionEvent;

import event.Event;
import jason.asSemantics.Intention;
import jason.asSyntax.Term;

public class IntentionResumedEvent extends IntentionEvent {

    public IntentionResumedEvent(int cycleNumber, Intention intention, Term reason) {
        super(cycleNumber, intention, reason);
    }
}
