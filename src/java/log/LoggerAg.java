package log;

import java.util.List;

import event.GoalEvent;
import event.IntentionEvent;
import event.SelectPlanEvent;
import jason.asSemantics.*;
import jason.asSyntax.Term;
import jason.asSyntax.Trigger;
import logger.Logger;
import logger.LoggerImpl;

public class LoggerAg extends Agent implements GoalListener, CircumstanceListener {

    private final Logger logger;
    private String agentName;

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
        logger.insertEvent(agentName, event);
        return selected;
    }

    // Goal  Listener Interface 

    @Override
    public void goalStarted(Event goal) {
        addGoalEvent(goal.getTrigger(), GoalStates.pending, null);
    }

    @Override
    public void goalFinished(Trigger goal, GoalStates result) {
        addGoalEvent(goal, GoalStates.finished, null);
        if (goal.getLiteral().getFunctor().equals("g1")) { //todo
            logger.saveLogInFile("log/log.txt");
        }
    }

    @Override
    public void goalSuspended(Trigger goal, Term reason) {
        addGoalEvent(goal, GoalStates.suspended, reason);
    }

    @Override
    public void goalWaiting(Trigger goal, Term reason) {
        addGoalEvent(goal, GoalStates.waiting, reason);
    }

    @Override
    public void goalResumed(Trigger goal, Term reason) {
        addGoalEvent(goal, GoalStates.resumed, reason);
    }

    @Override
    public void goalExecuting(Trigger goal, Term reason) {
        addGoalEvent(goal, GoalStates.executing, reason);
    }

    private void addGoalEvent(Trigger goal, GoalStates state, Term reason) {
        this.logger.insertEvent(agentName, new GoalEvent(ts.getAgArch().getCycleNumber(), goal, state, reason));
    }

    // Circumstance Listener Interface

    @Override
    public void eventAdded(Event e) {
//        printLog("new event "+e.getTrigger());
    }

    @Override
    public void intentionAdded(Intention i) {
        addIntentionEvent(i, "added", null);
    }

    @Override
    public void intentionDropped(Intention i) {
        addIntentionEvent(i, "dropped", null);
    }

    @Override
    public void intentionSuspended(Trigger t, Intention i, Term reason) {
        addIntentionEvent(i, "suspended", reason);
    }

    @Override
    public void intentionWaiting(Intention i, Term reason) {
        addIntentionEvent(i, "waiting", reason);
    }

    @Override
    public void intentionResumed(Intention i, Term reason) {
        addIntentionEvent(i, "resumed", reason);
    }

    @Override
    public void intentionExecuting(Intention i, Term reason) {
        addIntentionEvent(i, "executing", reason);
    }

    private void addIntentionEvent(Intention intention, String event, Term reason) {
        this.logger.insertEvent(agentName, new IntentionEvent(ts.getAgArch().getCycleNumber(), intention, event, reason));
    }

    void printLog(String m) {
        if (!m.contains("+!jcm::")) // filter some msgs
            System.out.println("log: "+m);
    }
}
