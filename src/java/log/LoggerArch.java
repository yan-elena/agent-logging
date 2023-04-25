package log;

import event.actionEvent.ActionEvent;
import event.reasoningCycleEvent.ReasoningCycleStarted;
import jason.architecture.AgArch;
import jason.asSemantics.ActionExec;
import jason.asSyntax.Literal;
import logger.EventLogger;
import logger.EventLoggerImpl;

import java.util.Collection;

/**
 * This class extends the agent architecture for implementing the logging functionality in an agent.
 */
public class LoggerArch extends AgArch {

    private final EventLogger eventLogger;

    /**
     * Creates a new instance of {@link LoggerArch} and initialized the logger.
     */
    public LoggerArch() {
        eventLogger = EventLoggerImpl.getLogger();
    }

    // works only with jacamo1.2-SNAPSHOT
    @Override
    public void act(ActionExec action) {
        eventLogger.publishEvent(getAgName(), new ActionEvent(getTS().getC().getAction()));
        super.act(action);
    }

    @Override
    public void reasoningCycleStarting() {
        eventLogger.publishEvent(getAgName(), new ReasoningCycleStarted(getCycleNumber()));
    }

    @Override
    public void reasoningCycleFinished() {
        ActionExec action = getTS().getC().getAction();
        if (action != null)  {
            System.out.println("action finish: " + action);
//            if (action.getResult())
            eventLogger.publishEvent(getAgName(), new ActionEvent(action));
        }
    }

    @Override
    public Collection<Literal> perceive() {
        Collection<Literal> percepts = super.perceive();

        if (percepts != null) {
            System.out.println("perceive " + percepts);
        }
        return percepts;
    }

    @Override
    public void stop() {
        eventLogger.saveLog(getAgName());
        super.stop();
    }

    @Override
    public void actionExecuted(ActionExec act) {
        System.out.println("action executed " + act);
        super.actionExecuted(act);
    }

}
