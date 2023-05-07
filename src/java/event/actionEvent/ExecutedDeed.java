package event.actionEvent;

import event.Event;
import jason.asSyntax.Term;

/**
 * An event that represents the finished execution of a deed (that includes environment action, test goals, mental
 * notes, internal actions and expressions).
 */
public class ExecutedDeed implements Event {

    private final String action;

    /**
     * Creates a new instance of {@link ExecutedDeed} from the given deed.
     * @param deed the executed deed
     */
    public ExecutedDeed(Term deed) {
        action = deed.toString();
    }

    @Override
    public String logEvent() {
        return "Deed " + action + " executed";
    }
}
