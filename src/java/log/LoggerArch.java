package log;

import event.Action;
import jason.architecture.*;
import jason.asSemantics.*;
import logger.Logger;

public class LoggerArch extends AgArch {

    private final Logger logger;

    public LoggerArch() {
        logger = Logger.getLogger();
    }

    // works only with jacamo1.2-SNAPSHOT
    @Override
    public void act(ActionExec action) {
        System.out.println("log: 1.doing "+getTS().getC().getAction().getActionTerm());
        super.act(action);
    }

    @Override
    public void reasoningCycleFinished() {
        if (getTS().getC().getAction() != null)  {
            final Action action = new Action(getCycleNumber(), getTS().getC().getAction());
            logger.insertEvent(getAgName(), action);
            logger.printLog();
//            System.out.println("log: 2.doing "+getTS().getC().getAction().getActionTerm());
        }
    }

    // TODO: see other methods from AgArch to Override
}
