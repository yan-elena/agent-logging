package event;

/**
 * An interface that represents a common event generated by an agent.
 */
public interface Event {

    /**
     * Returns the timestamp at which the event occurred.
     * @return the timestamp of the event
     */
    long getTimestamp();

    /**
     * Returns the reasoning cycle number when the event occurred.
     * @return the reasoning cycle number of the event
     */
    int getReasoningCycleNum();

    /**
     * Returns the name of the agent that triggered the event.
     * @return the name of the agent
     */
    String getAgentName();

    /**
     * Sets the name of the agent.
     * @param agentName the name of the agent
     */
    void setAgentName(String agentName);
}