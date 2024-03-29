package event.actionEvent;

import event.Event;
import event.eventInfo.DeedInfo;
import event.eventInfo.IntentionInfo;
import jason.asSemantics.Intention;
import jason.asSyntax.PlanBody;

import java.util.Optional;

/**
 * A class that representing an event related to a deed.
 */
abstract class DeedEvent implements Event {

    protected final DeedInfo deedInfo;
    protected final Optional<IntentionInfo> intentionInfo;

    /**
     * Constructor of {@link DeedEvent}.
     * @param deed the executed deed
     * @param intention {@link Intention} the current intention
     */
    public DeedEvent(PlanBody deed, Intention intention) {
        this.deedInfo = new DeedInfo(deed);
        if (intention != null) {
            IntentionInfo intentionInfo = new IntentionInfo(intention);
            if (intentionInfo.peekFirstIntendedMeans().isPresent() &&
                    intentionInfo.peekFirstIntendedMeans().get().getPlan().getBody().contains(deedInfo.getTerm())) {
                this.intentionInfo = Optional.of(intentionInfo);
            } else {
                this.intentionInfo = Optional.empty();
            }
        } else {
            this.intentionInfo = Optional.empty();
        }
    }

    public DeedInfo getDeedInfo() {
        return deedInfo;
    }

    public Optional<IntentionInfo> getIntentionInfo() {
        return intentionInfo;
    }
}
