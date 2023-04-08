package event;

abstract class AbstractEvent implements Event {

    private final long timestamp;
    private final int reasoningCycleNumber;

    public AbstractEvent(long timestamp, int reasoningCycleNum) {
        this.timestamp = timestamp;
        this.reasoningCycleNumber = reasoningCycleNum;
    }

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
    public String toString() {
        return "Cycle " + reasoningCycleNumber +
                " - Timestamp " + timestamp +
                ": " + eventToString();
    }

    abstract public String eventToString();
}
