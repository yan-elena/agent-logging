package event;

abstract class AbstractEvent implements Event {

    private final long timestamp;
    private final int reasoningCycleNumber;

    public AbstractEvent(long timestamp, int reasoningCycleNum) {
        this.timestamp = timestamp;
        this.reasoningCycleNumber = reasoningCycleNum;
    }

    @Override
    public long getTimestamp() {
        return this.timestamp;
    }

    @Override
    public int getReasoningCycleNum() {
        return this.reasoningCycleNumber;
    }
}
