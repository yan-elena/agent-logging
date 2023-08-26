package event.actionEvent;

import event.Event;
import event.eventInfo.DeedInfo;
import event.eventInfo.IntentionInfo;
import jason.asSemantics.Intention;
import jason.asSyntax.PlanBody;

import java.util.Optional;

/**
 * An event that represents the completion of an internal action.
 */
public class InternalActionFinished implements Event {

    private final DeedInfo action;
    private final Optional<IntentionInfo> intentionInfo;

    /**
     * Creates a new {@link InternalActionFinished} instance from the executed action.
     * @param action a {@link PlanBody} of the finished action
     * @param intention {@link Intention} the current intention
     */
    public InternalActionFinished(PlanBody action, Intention intention) {
        this.action = new DeedInfo(action);
        this.intentionInfo = intention != null ? Optional.of(new IntentionInfo(intention)) : Optional.empty();
    }

    @Override
    public String logEvent() {
        return "Internal action " + action.getTerm() + " finished";
    }
}
