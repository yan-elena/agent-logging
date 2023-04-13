package log;

import event.ActionEvent;
import jason.architecture.*;
import jason.asSemantics.*;
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
    public void reasoningCycleFinished() {
        if (getTS().getC().getAction() != null)  {
            logger.publishEvent(getAgName(), new ActionEvent(getCycleNumber(), getTS().getC().getAction()));
        }
    }

    @Override
    public void sendMsg(Message m) throws Exception {
        //todo
        super.sendMsg(m);
    }

    @Override
    public void stop() {
        logger.saveLogInFile("log/log.txt");
        logger.saveLogAsJson("log/log.json");
        super.stop();
    }

    @Override
    public void checkMail() {
        super.checkMail();
    }

    @Override
    public void actionExecuted(ActionExec act) {
        super.actionExecuted(act);
        System.out.println(act);
    }
}
