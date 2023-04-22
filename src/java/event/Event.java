package event;

/**
 * An interface that represents a common event generated by an agent.
 */
public interface Event {

    /**
     * Returns the log message of the event.
     * @return the log message
     */
    String logEvent();
}