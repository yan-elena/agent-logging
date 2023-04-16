package event.eventInfo;

import java.util.Arrays;
import java.util.Optional;

/**
 * An enumeration of the possible types of reasons for specific tracking.
 */
public enum ReasonType {

    /**
     * Reason that represents the execution of an action.
     */
    ACTION("action"),

    /**
     * The reason that represents an action will be executed.
     */
    ACTION_EXECUTED("action_executed");

    private final String type;

    ReasonType(String reason) {
        this.type = reason;
    }

    /**
     * Returns the type of the reason.
     * @return type
     */
    public String getType() {
        return type;
    }

    /**
     * Returns an optional of {@link ReasonType} from the functor of the reason.
     * @param functor the functor of the reason
     * @return an optional reason type
     */
    public static Optional<ReasonType> getReasonType(String functor) {
        return Arrays.stream(ReasonType.values()).filter(r -> r.getType().equals(functor)).findFirst();
    }
}
