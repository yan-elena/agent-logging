package log;

import event.ActionEvent;
import event.ReasoningCycleStarted;
import jason.architecture.AgArch;
import jason.asSemantics.ActionExec;
import logger.Logger;
import logger.LoggerImpl;

/**
 * This class extends the agent architecture for implementing the logging functionality in an agent.
 */
public class LoggerArch extends AgArch {

    private final Logger logger;

    /**
     * Creates a new instance of {@link LoggerArch} and initialized the logger.
     */
    public LoggerArch() {
        logger = LoggerImpl.getLogger();
    }

    // works only with jacamo1.2-SNAPSHOT
    @Override
    public void act(ActionExec action) {
        logger.publishEvent(getAgName(), new ActionEvent(getCycleNumber(), getTS().getC().getAction()));
        super.act(action);
    }

    @Override
    public void reasoningCycleStarting() {
        logger.publishEvent(getAgName(), new ReasoningCycleStarted(getCycleNumber()));
    }

    @Override
    public void reasoningCycleFinished() {
        if (getTS().getC().getAction() != null)  {
            logger.publishEvent(getAgName(), new ActionEvent(getCycleNumber(), getTS().getC().getAction()));
        }
    }

    @Override
    public void stop() {
        logger.saveAgentLogInFile(getAgName());
        logger.saveAgentLogAsJson(getAgName());
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
