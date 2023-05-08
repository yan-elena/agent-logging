package event.actionEvent;

import event.Event;
import event.eventInfo.DeedInfo;
import jason.asSyntax.PlanBody;

/**
 * An event that represents the completion of an action.
 */
public class ExternalActionFinished implements Event {

    private final DeedInfo deedInfo;

    /**
     * Creates a new instance of {@link ExternalActionFinished} from the given action.
     * @param action the finished action
     */
    public ExternalActionFinished(PlanBody action) {
        this.deedInfo = new DeedInfo(action);
    }

    @Override
    public String logEvent() {
        return "Action " + deedInfo.getTerm() + " finished";
    }
}
