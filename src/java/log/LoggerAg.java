package log;

import java.util.List;
import java.util.Queue;

import event.triggeringEvent.BeliefAdditionEvent;
import event.goalEvent.*;
import event.SelectPlanEvent;
import event.intentionEvent.*;
import event.triggeringEvent.BeliefDeletionEvent;
import jason.asSemantics.*;
import jason.asSyntax.Term;
import jason.asSyntax.Trigger;
import logger.EventLogger;
import logger.EventLoggerImpl;

/**
 * This class logs events on goals and on the circumstance.
 */
public class LoggerAg extends Agent implements GoalListener, CircumstanceListener {

    private final EventLogger eventLogger;
    private String agentName;

    /**
     * Creates a new instance of {@link LoggerAg} and initialized the logger.
     */
    public LoggerAg() {
        eventLogger = EventLoggerImpl.getLogger();
    }

    @Override
    public void initAg() {
        super.initAg();
        this.agentName = ts.getAgArch().getAgName();

        // add listeners
        getTS().addGoalListener(this);
        getTS().getC().addEventListener(this);
    }

    @Override // from Agent class
    public Option selectOption(List<Option> options) {
        final SelectPlanEvent event = new SelectPlanEvent(getTS().getC().getSelectedEvent().getTrigger(), options);
        final Option selected = super.selectOption(options);
        event.setSelected(selected);
        eventLogger.publishEvent(agentName, event);
        return selected;
    }

    // Goal  Listener Interface 

    @Override
    public void goalStarted(Event goal) {
        this.eventLogger.publishEvent(agentName, new GoalCreated(goal.getTrigger()));
    }

    @Override
    public void goalFinished(Trigger goal, GoalStates result) {
        this.eventLogger.publishEvent(agentName, new GoalRemoved(goal, result));
    }

    @Override
    public void goalFailed(Trigger goal, Term reason) {
        this.eventLogger.publishEvent(agentName, new GoalRemoved(goal, GoalStates.failed));
    }

    @Override
    public void goalSuspended(Trigger goal, Term reason) {
        this.eventLogger.publishEvent(agentName, new GoalSuspended(goal, reason));
    }

    @Override
    public void goalExecuting(Trigger goal, Term reason) {
        this.eventLogger.publishEvent(agentName, new PlanSelected(goal, reason));
    }

    // Circumstance Listener Interface

    @Override
    public void eventAdded(Event e) {
        if (e.getTrigger().getType() == Trigger.TEType.belief) {
            switch (e.getTrigger().getOperator()) {
                case add -> eventLogger.publishEvent(agentName, new BeliefAdditionEvent(e.getTrigger()));
                case del -> eventLogger.publishEvent(agentName, new BeliefDeletionEvent(e.getTrigger()));
            }
//        } else if (e.getTrigger().getType() == Trigger.TEType.achieve ) {
//            switch (e.getTrigger().getOperator()) {
//                case add -> logger.publishEvent(agentName, new AchievementGoalAddition(e.getTrigger()));
//                case del -> logger.publishEvent(agentName, new AchievementGoalDeletion(e.getTrigger()));
//            }
        }
    }

    @Override
    public void intentionAdded(Intention i) {
        this.eventLogger.publishEvent(agentName, new IntentionAddedEvent(i));
    }

    @Override
    public void intentionDropped(Intention i) {
        this.eventLogger.publishEvent(agentName, new IntentionDroppedEvent(i));
    }

    @Override
    public void intentionSuspended(Trigger t, Intention i, Term reason) {
        this.eventLogger.publishEvent(agentName, new IntentionSuspendedEvent(i, reason));
    }

    @Override
    public void intentionWaiting(Intention i, Term reason) {
        this.eventLogger.publishEvent(agentName, new IntentionWaitingEvent(i, reason));
    }

    @Override
    public void intentionResumed(Intention i, Term reason) {
        this.eventLogger.publishEvent(agentName, new IntentionResumedEvent(i, reason));
    }

    @Override
    public void intentionExecuting(Intention i, Term reason) {
        this.eventLogger.publishEvent(agentName, new IntentionExecutingEvent(i, reason));
    }

    // Agent class


    @Override
    public Message selectMessage(Queue<Message> messages) {
        return super.selectMessage(messages);
    }

    @Override
    public Event selectEvent(Queue<Event> events) {
//        getTS().getC().getSelectedEvent()
        return super.selectEvent(events);
    }

    @Override
    public ActionExec selectAction(Queue<ActionExec> actions) {
        return super.selectAction(actions);
    }

    @Override
    public Intention selectIntention(Queue<Intention> intentions) {
//        getTS().getC().getSelectedIntention()
        return super.selectIntention(intentions);
    }

}
