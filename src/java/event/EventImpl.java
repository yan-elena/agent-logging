package event;

abstract class EventImpl implements Event {

    private final long timestamp;
    private final int reasoningCycleNumber;

    public EventImpl(long timestamp, int reasoningCycleNum) {
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
