package event.actionEvent;

import event.Event;
import event.eventInfo.DeedInfo;
import jason.asSyntax.PlanBody;
import jason.asSyntax.Term;

/**
 * An event that represents the finished execution of a generic deed (that could includes environment action, test
 * goals, mental notes, internal actions and expressions).
 */
public class ExecutedDeed implements Event {

    private final DeedInfo deedInfo;

    /**
     * Creates a new instance of {@link ExecutedDeed} from the given deed.
     * @param deed the executed deed
     */
    public ExecutedDeed(PlanBody deed) {
        deedInfo = new DeedInfo(deed);
    }

    @Override
    public String logEvent() {
        return "Deed " + deedInfo.getTerm() + " of type " + deedInfo.getType() + " executed - from " + deedInfo.getSrcInfo();
    }
}
