package log;

import java.util.List;

import event.goalEvent.GoalAddedEvent;
import event.goalEvent.GoalEvent;
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
        System.out.println("goalStarted: \n" + goal.getTrigger().getSrcInfo());
        this.logger.publishEvent(agentName, new GoalAddedEvent(ts.getAgArch().getCycleNumber(), goal.getTrigger()));
    }

    @Override
    public void goalFinished(Trigger goal, GoalStates result) {
//        this.logger.publishEvent(agentName, new GoalAddedEvent(ts.getAgArch().getCycleNumber(), goal);
    }

    // Circumstance Listener Interface

    @Override
    public void eventAdded(Event e) {
        System.out.println("new event "+e.getTrigger());
    }
}
