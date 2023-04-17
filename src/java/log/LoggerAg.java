package log;

import java.util.List;
import java.util.Queue;

import event.eventInfo.IntentionInfo;
import event.goalEvent.*;
import event.SelectPlanEvent;
import event.intentionEvent.IntentionEvent;
import jason.asSemantics.*;
import jason.asSyntax.Term;
import jason.asSyntax.Trigger;
import logger.Logger;
import logger.LoggerImpl;

/**
 * This class logs events on goals and on the circumstance.
 */
public class LoggerAg extends Agent implements GoalListener, CircumstanceListener {

    private final Logger logger;
    private String agentName;

    /**
     * Creates a new instance of {@link LoggerAg} and initialized the logger.
     */
    public LoggerAg() {
        logger = LoggerImpl.getLogger();
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
        final SelectPlanEvent event = new SelectPlanEvent(ts.getAgArch().getCycleNumber(),
                getTS().getC().getSelectedEvent().getTrigger(),
                options);
        final Option selected = super.selectOption(options);
        event.setSelected(selected);
        logger.publishEvent(agentName, event);
        return selected;
    }

    // Goal  Listener Interface 

    @Override
    public void goalStarted(Event goal) {
        this.logger.publishEvent(agentName, new GoalAddedEvent(ts.getAgArch().getCycleNumber(), goal.getTrigger()));
    }

    @Override
    public void goalFinished(Trigger goal, GoalStates result) {
        this.logger.publishEvent(agentName, new GoalFinishedEvent(ts.getAgArch().getCycleNumber(), goal, result));
    }

    @Override
    public void goalFailed(Trigger goal, Term reason) {
        this.logger.publishEvent(agentName, new GoalFailedEvent(ts.getAgArch().getCycleNumber(), goal, reason));
    }

    @Override
    public void goalSuspended(Trigger goal, Term reason) {
        this.logger.publishEvent(agentName, new GoalSuspendedEvent(ts.getAgArch().getCycleNumber(), goal, reason));
    }

    @Override
    public void goalWaiting(Trigger goal, Term reason) {
        this.logger.publishEvent(agentName, new GoalWaitingEvent(ts.getAgArch().getCycleNumber(), goal, reason));
    }

    @Override
    public void goalResumed(Trigger goal, Term reason) {
        this.logger.publishEvent(agentName, new GoalResumedEvent(ts.getAgArch().getCycleNumber(), goal, reason));
    }

    @Override
    public void goalExecuting(Trigger goal, Term reason) {
        this.logger.publishEvent(agentName, new GoalExecutingEvent(ts.getAgArch().getCycleNumber(), goal, reason));
    }

    // Circumstance Listener Interface

    @Override
    public void eventAdded(Event e) {
//        System.out.println("new event "+e.getTrigger());
    }

    @Override
    public void intentionAdded(Intention i) {
//        addIntentionEvent(i, "added", null);
        new IntentionInfo(i);
    }

    @Override
    public void intentionDropped(Intention i) {

    }

    @Override
    public void intentionSuspended(Trigger t, Intention i, Term reason) {

    }

    @Override
    public void intentionWaiting(Intention i, Term reason) {

    }

    @Override
    public void intentionResumed(Intention i, Term reason) {

    }

    @Override
    public Intention selectIntention(Queue<Intention> intentions) {
        return super.selectIntention(intentions);
    }

    @Override
    public void intentionExecuting(Intention i, Term reason) {
//        System.out.println("intentionExecuting\n " + i);
//        addIntentionEvent(i, "executing", reason);
    }

    private void addIntentionEvent(Intention intention, Term reason) {
        this.logger.publishEvent(agentName, new IntentionEvent(ts.getAgArch().getCycleNumber(), intention, reason));
    }

}
