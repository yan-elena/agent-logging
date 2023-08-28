package event.actionEvent;

import jason.asSemantics.Intention;
import jason.asSyntax.PlanBody;

/**
 * An event that represents the finished execution of a generic deed (that could includes environment action, test
 * goals, mental notes, internal actions and expressions).
 */
public class ExecutedDeed extends DeedEvent {

    /**
     * Creates a new instance of {@link ExecutedDeed} from the given deed.
     * @param deed the executed deed
     * @param intention {@link Intention} the current intention
     */
    public ExecutedDeed(PlanBody deed, Intention intention) {
        super(deed, intention);
    }

    @Override
    public String logEvent() {
        return "Deed " + deedInfo.getTerm() + " of type " + deedInfo.getType() + " executed - from " + deedInfo.getSrcInfo();
    }
}
