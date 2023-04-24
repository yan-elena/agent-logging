package log;

import event.SelectPlanEvent;
import event.beliefEvent.BeliefAdded;
import event.beliefEvent.BeliefFromSrcAdded;
import event.beliefEvent.BeliefFromSrcRemoved;
import event.beliefEvent.BeliefRemoved;
import event.goalEvent.GoalCreated;
import event.goalEvent.GoalRemoved;
import event.goalEvent.GoalSuspended;
import event.goalEvent.PlanSelected;
import event.intentionEvent.IntentionCreated;
import event.intentionEvent.IntentionRemoved;
import event.intentionEvent.IntentionSuspended;
import event.intentionEvent.IntentionWaiting;
import jason.asSemantics.*;
import jason.asSyntax.Literal;
import jason.asSyntax.Term;
import jason.asSyntax.Trigger;
import logger.EventLogger;
import logger.EventLoggerImpl;

import java.util.List;
import java.util.Queue;

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
        this.eventLogger.publishEvent(agentName, new GoalCreated(goal));
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
        Trigger trigger = e.getTrigger();
        if (trigger.getType() == Trigger.TEType.belief) {

            System.out.println("trigger: " + trigger);
//            Literal type = trigger.getLiteral().getAnnot("percept_type");
//            System.out.println("type: " + (type!= null ? type.getTerm(0): "null"));
//            System.out.println("source: " + (type!= null ? trigger.getLiteral().getAnnot("source").getTerm(0):
//                    "null"));

            Literal source = trigger.getLiteral().getAnnot("source");
            if (source == null || source.toString().equals("self")) {
                switch (trigger.getOperator()) {
                    case add -> eventLogger.publishEvent(agentName, new BeliefAdded(trigger));
                    case del -> eventLogger.publishEvent(agentName, new BeliefRemoved(trigger));
                }
            } else {
                switch (trigger.getOperator()) {
                    case add -> eventLogger.publishEvent(agentName, new BeliefFromSrcAdded(trigger));
                    case del -> eventLogger.publishEvent(agentName, new BeliefFromSrcRemoved(trigger));
                }
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
        this.eventLogger.publishEvent(agentName, new IntentionCreated(i));
    }

    @Override
    public void intentionDropped(Intention i) {
        this.eventLogger.publishEvent(agentName, new IntentionRemoved(i));
    }

    @Override
    public void intentionSuspended(Trigger t, Intention i, Term reason) {
        this.eventLogger.publishEvent(agentName, new IntentionSuspended(i, reason));
    }

    @Override
    public void intentionWaiting(Intention i, Term reason) {
        this.eventLogger.publishEvent(agentName, new IntentionWaiting(i, reason));
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
