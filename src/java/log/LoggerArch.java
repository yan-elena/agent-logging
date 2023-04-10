package log;

import event.ActionEvent;
import jason.architecture.*;
import jason.asSemantics.*;
import logger.Logger;
import logger.LoggerImpl;

public class LoggerArch extends AgArch {

    private final Logger logger;

    public LoggerArch() {
        logger = LoggerImpl.getLogger();
    }

    // works only with jacamo1.2-SNAPSHOT
    @Override
    public void act(ActionExec action) {
        logger.insertEvent(getAgName(), new ActionEvent(getCycleNumber(), getTS().getC().getAction()));
        super.act(action);
    }

    @Override
    public void reasoningCycleFinished() {
        if (getTS().getC().getAction() != null)  {
            logger.insertEvent(getAgName(), new ActionEvent(getCycleNumber(), getTS().getC().getAction()));
        }
    }

    @Override
    public void actionExecuted(ActionExec act) {
        System.out.println("---> log: action executed "+getTS().getC().getAction().getActionTerm() + "\t" + act);
        super.actionExecuted(act);
    }

    @Override
    public void sendMsg(Message m) throws Exception {
        System.out.println("---> sending " + m);
        super.sendMsg(m);
    }

    @Override
    public void stop() {
        logger.saveLogInFile("log/log.txt"); //todo
        super.stop();
    }
}
