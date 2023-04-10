package event;

abstract class AbstractEvent implements Event {

    private final long timestamp;
    private final int reasoningCycleNumber;
    private String agentName;

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
    public String getAgentName() {
        return agentName;
    }

    @Override
    public void setAgentName(String agentName) {
        this.agentName = agentName;
    }

    @Override
    public String toString() {
        return "[" + agentName + "]" +
                " Cycle " + reasoningCycleNumber +
                " Timestamp " + timestamp +
                ": " + eventToString();
    }

    abstract public String eventToString();
}
