package event.intentionEvent;

import event.Event;
import jason.asSemantics.Intention;
import jason.asSyntax.Term;

public class IntentionExecutingEvent extends IntentionEvent {

    public IntentionExecutingEvent(int cycleNumber, Intention intention, Term reason) {
        super(cycleNumber, intention, reason );
    }
}
