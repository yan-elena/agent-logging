package log;

import event.ActionEvent;
import event.ReasoningCycleStarted;
import jason.architecture.AgArch;
import jason.asSemantics.ActionExec;
import logger.EventLogger;
import logger.EventLoggerImpl;

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
        if (getTS().getC().getAction() != null)  {
            eventLogger.publishEvent(getAgName(), new ActionEvent(getTS().getC().getAction()));
        }
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

    @Override
    public void checkMail() {
        super.checkMail();
//        getTS().getC().getMailBox()
    }
}
