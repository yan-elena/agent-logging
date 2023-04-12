package log;

import java.util.List;

import event.GoalEvent;
import event.SelectPlanEvent;
import jason.asSemantics.*;
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
        logger.publishEvent(agentName, event);
        return selected;
    }

    // Goal  Listener Interface 

    @Override
    public void goalStarted(Event goal) {
        addGoalEvent(goal.getTrigger(), GoalStates.pending);
    }

    @Override
    public void goalFinished(Trigger goal, GoalStates result) {
        addGoalEvent(goal, GoalStates.finished);
        if (goal.getLiteral().getFunctor().equals("g1")) { //todo
            logger.saveLogInFile("log/log.txt");
        }
    }

    private void addGoalEvent(Trigger goal, GoalStates state) {
        this.logger.publishEvent(agentName, new GoalEvent(ts.getAgArch().getCycleNumber(), goal, state));
    }

    // Circumstance Listener Interface

    @Override
    public void eventAdded(Event e) {
//        printLog("new event "+e.getTrigger());
    }
}
