package event;

import jason.asSyntax.Trigger;

public class GoalEvent extends AbstractEvent {

    private final String event;
    private final Trigger goal;

    public GoalEvent(int reasoningCycleNum, Trigger goal, String event) {
        super(reasoningCycleNum);
        this.goal = goal;
        this.event = event;
    }

    @Override
    public String eventToString() {
        return "Goal " + goal.getLiteral().getFunctor() + " " + event;
    }

    public String getEvent() {
        return event;
    }

    public Trigger getGoal() {
        return goal;
    }
}
