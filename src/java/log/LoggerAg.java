package log;

import java.util.List;

import event.GoalEvent;
import event.SelectPlanEvent;
import jason.asSemantics.*;
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
        addGoalEvent(goal.getTrigger(), "started");
    }

    @Override
    public void goalFinished(Trigger goal, GoalStates result) {
        addGoalEvent(goal, "finished");
        if (goal.getLiteral().getFunctor().equals("g1")) { //todo
            logger.saveLogInFile("log/log.txt");
            logger.saveLogAsJson("log/log.json");
        }
    }

    private void addGoalEvent(Trigger goal, String state) {
        this.logger.publishEvent(agentName, new GoalEvent(ts.getAgArch().getCycleNumber(), goal, state));
    }

    // Circumstance Listener Interface

    @Override
    public void eventAdded(Event e) {
//        printLog("new event "+e.getTrigger());
    }
}
