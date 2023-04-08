package log;

import java.util.List;

import event.SelectPlanEvent;
import jason.asSemantics.Agent;
import jason.asSemantics.CircumstanceListener;
import jason.asSemantics.Event;
import jason.asSemantics.GoalListener;
import jason.asSemantics.Option;
import jason.asSyntax.Term;
import jason.asSyntax.Trigger;
import logger.Logger;
import logger.LoggerImpl;

public class LoggerAg extends Agent implements GoalListener, CircumstanceListener {

    private final Logger logger;

    public LoggerAg() {
        logger = LoggerImpl.getLogger();
    }

    @Override
    public void initAg() {
        super.initAg();

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
        this.logger.insertEvent(ts.getAgArch().getAgName(), event);
        return selected;
    }

    // Goal  Listener Interface 

    @Override
    public void goalStarted(Event goal) {
        printLog("goal "+goal.getTrigger()+" started!");
    }

    @Override
    public void goalFinished(Trigger goal, GoalStates result) {

    }

    @Override
    public void goalSuspended(Trigger goal, Term reason) {

    }

    @Override
    public void goalWaiting(Trigger goal, Term reason) {

    }

    @Override
    public void goalResumed(Trigger goal, Term reason) {

    }

    @Override
    public void goalExecuting(Trigger goal, Term reason) {

    }

    // Circumstance Listener Interface

    @Override
    public void eventAdded(Event e) {
//        printLog("new event "+e.getTrigger());
    }

    // TODO: see other methods of Goal & Circumstance Listeners

    void printLog(String m) {
        if (!m.contains("+!jcm::")) // filter some msgs
            System.out.println("log: "+m);
    }
}
