package event.actionEvent;

import event.Event;
import event.eventInfo.DeedInfo;
import event.eventInfo.IntentionInfo;
import jason.asSemantics.Intention;
import jason.asSyntax.PlanBody;

import java.util.Optional;

/**
 * An event that represents the finished execution of a generic deed (that could includes environment action, test
 * goals, mental notes, internal actions and expressions).
 */
public class ExecutedDeed implements Event {

    private final DeedInfo deedInfo;
    private final Optional<IntentionInfo> intentionInfo;

    /**
     * Creates a new instance of {@link ExecutedDeed} from the given deed.
     * @param deed the executed deed
     * @param intention {@link Intention} the current intention
     */
    public ExecutedDeed(PlanBody deed, Intention intention) {
        this.deedInfo = new DeedInfo(deed);
        this.intentionInfo = intention != null ? Optional.of(new IntentionInfo(intention)) : Optional.empty();
    }

    @Override
    public String logEvent() {
        return "Deed " + deedInfo.getTerm() + " of type " + deedInfo.getType() + " executed - from " + deedInfo.getSrcInfo();
    }
}
