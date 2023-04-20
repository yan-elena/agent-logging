package event;

/**
 * An abstract base class for all events, containing common attributes and methods for registering an event.
 */
public abstract class AbstractEvent implements Event {

    private final long timestamp;

    /**
     * Constructor of AbstractEvent with the specified timestamp and reasoning cycle number.
     * @param timestamp         the timestamp of the event
     *
     */
    public AbstractEvent(long timestamp) {
        this.timestamp = timestamp;
    }

    /**
     * Constructor of AbstractEvent with the current time as the timestamp and the specified reasoning cycle number.
     */
    public AbstractEvent() {
        this(System.currentTimeMillis());
    }

    @Override
    public long getTimestamp() {
        return this.timestamp;
    }

    @Override
    public String toString() {
        return "[Timestamp " + timestamp +
                "] " +
                this.getClass().getSimpleName() +
                "\n" + logEvent() +
                "\n";
    }

    /**
     * Abstract method that returns a log message of the event.
     * @return the log message of the event
     */
    abstract public String logEvent();
}
