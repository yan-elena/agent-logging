package event;

/**
 * A class that representing a new reasoning cycle started event.
 */
public class ReasoningCycleStarted extends AbstractEvent {

    private final int cycleNumber;

    /**
     * Creates a new instance of {@link ReasoningCycleStarted} with the given cycle number.
     * @param cycleNumber the reasoning cycle number
     */
    public ReasoningCycleStarted(int cycleNumber) {
        this.cycleNumber = cycleNumber;
    }

    /**
     * Returns the reasoning cycle number.
     * @return cycle number
     */
    public int getCycleNumber() {
        return cycleNumber;
    }

    @Override
    public String logEvent() {
        return "New reasoning cycle started: " + cycleNumber;
    }
}
