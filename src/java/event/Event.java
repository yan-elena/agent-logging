package event;

public interface Event {

    long getTimestamp();

    int getReasoningCycleNum();

    String getAgentName();

    void setAgentName(String agentName);
}
