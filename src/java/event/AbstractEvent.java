package event;

/**
 * An abstract base class for all events, containing common attributes and methods for registering an event.
 */
abstract class AbstractEvent implements Event {

    private final long timestamp;
    private final int reasoningCycleNumber;
    private String agentName;

    /**
     * Constructor of AbstractEvent with the specified timestamp and reasoning cycle number.
     * @param timestamp         the timestamp of the event
     * @param reasoningCycleNum the reasoning cycle number of the event
     */
    public AbstractEvent(long timestamp, int reasoningCycleNum) {
        this.timestamp = timestamp;
        this.reasoningCycleNumber = reasoningCycleNum;
    }

    /**
     * Constructor of AbstractEvent with the current time as the timestamp and the specified reasoning cycle number.
     * @param reasoningCycleNum the reasoning cycle number of the event
     */
    public AbstractEvent(int reasoningCycleNum) {
        this(System.currentTimeMillis(), reasoningCycleNum);
    }

    @Override
    public long getTimestamp() {
        return this.timestamp;
    }

    @Override
    public int getReasoningCycleNum() {
        return this.reasoningCycleNumber;
    }

    @Override
    public String getAgentName() {
        return agentName;
    }

    @Override
    public void setAgentName(String agentName) {
        this.agentName = agentName;
    }

    @Override
    public String toString() {
        return "[Cycle " + reasoningCycleNumber +
                " Timestamp " + timestamp +
                "] " +
                eventToString();
    }

    /**
     * Abstract method that returns a string representation of the event.
     * @return the string representation of the event
     */
    abstract public String eventToString();
}
