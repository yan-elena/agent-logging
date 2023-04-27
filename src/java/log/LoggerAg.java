package log;

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
import event.planEvent.SelectPlanEvent;
import event.signalEvent.NewSignal;
import event.speechActMessageEvent.NewSpeechActMessage;
import event.speechActMessageEvent.SelectMessage;
import jason.asSemantics.*;
import jason.asSyntax.Literal;
import jason.asSyntax.Term;
import jason.asSyntax.Trigger;
import logger.EventLogger;
import logger.EventLoggerImpl;

import java.util.LinkedList;
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

    // from Agent class

    @Override
    public void initAg() {
        super.initAg();
        this.agentName = ts.getAgArch().getAgName();

        // add listeners
        getTS().addGoalListener(this);
        getTS().getC().addEventListener(this);
    }

    @Override
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

            Literal sourceLiteral = trigger.getLiteral().getAnnot("source");
            List<String> sources = sourceLiteral != null ? sourceLiteral.getTerms().stream().map(Term::toString).toList() : new LinkedList<>();
            Literal beliefBaseLiteral = getBB().contains(trigger.getLiteral());
            if (sources.contains("percept")) {
                eventLogger.publishEvent(agentName, new NewSignal(trigger));
            } else {
                switch (trigger.getOperator()) {
                    case add -> {
                        if (beliefBaseLiteral != null) {
                            if (sources.isEmpty() || sources.contains("self")) {
                                eventLogger.publishEvent(agentName, new BeliefAdded(trigger));
                            } else {
                                eventLogger.publishEvent(agentName, new BeliefFromSrcAdded(trigger));
                            }
                        }
                    }
                    case del -> {
                        if (beliefBaseLiteral == null) {
                            if (sources.isEmpty() || sources.contains("self")) {
                                eventLogger.publishEvent(agentName, new BeliefRemoved(trigger));
                            } else {
                                eventLogger.publishEvent(agentName, new BeliefFromSrcRemoved(trigger));
                            }
                        }
                    }
                }
            }
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
        SelectMessage event = new SelectMessage(messages.stream().toList());
        Message message = super.selectMessage(messages);
        event.setSelected(message);
        this.eventLogger.publishEvent(agentName, event);
        return message;
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

//    @Override
//    public int buf(Collection<Literal> percepts) {
//        System.out.println("buf: " + percepts);
//        return super.buf(percepts);
//    }
//
//    @Override
//    public List<Literal>[] brf(Literal beliefToAdd, Literal beliefToDel, Intention i) throws RevisionFailedException {
//        System.out.println("brf: \nbeliefToAdd: " + beliefToAdd + "\nbeliefToDel: " + beliefToDel + "\nintention: " + i);
//        return super.brf(beliefToAdd, beliefToDel, i);
//    }

    @Override
    public boolean socAcc(Message m) {
        boolean accept = super.socAcc(m);
        if (accept) {
            this.eventLogger.publishEvent(agentName, new NewSpeechActMessage(m));
        }
        return accept;
    }
}
