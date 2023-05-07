package log;

import event.actionEvent.ExecutedDeed;
import event.actionEvent.ActionTriggered;
import event.planEvent.PlanLibraryEvent;
import event.reasoningCycleEvent.ReasoningCycleStarted;
import event.speechActMessageEvent.MailBoxMessages;
import event.speechActMessageEvent.SendMessage;
import jason.architecture.AgArch;
import jason.asSemantics.ActionExec;
import jason.asSemantics.Message;
import jason.asSyntax.Term;
import logger.EventLogger;
import logger.EventLoggerImpl;

import java.util.Queue;

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

    @Override
    public void init() throws Exception {
        super.init();
        this.eventLogger.publishEvent(getAgName(), new PlanLibraryEvent(getTS().getAg().getPL().getPlans()));
    }

    // works only with jacamo1.2-SNAPSHOT
    @Override
    public void act(ActionExec action) {
        eventLogger.publishEvent(getAgName(), new ActionTriggered(getTS().getC().getAction()));
        super.act(action);
    }

    @Override
    public void reasoningCycleStarting() {
        eventLogger.publishEvent(getAgName(), new ReasoningCycleStarted(getCycleNumber()));
    }

    @Override
    public void reasoningCycleFinished() {
        super.reasoningCycleFinished();
        ActionExec action = getTS().getC().getAction();
        Term lastDeed = getTS().getC().getLastDeed();
        if (action != null)  {
            eventLogger.publishEvent(getAgName(), new ActionTriggered(action));
        } else if (lastDeed != null) {
            eventLogger.publishEvent(getAgName(), new ExecutedDeed(lastDeed));
        }
    }

    @Override
    public void stop() {
        eventLogger.saveLog(getAgName());
        super.stop();
    }

    @Override
    public void checkMail() {
        super.checkMail();
        Queue<Message> mailBox = getTS().getC().getMailBox();

        if (!mailBox.isEmpty()) {
            this.eventLogger.publishEvent(getAgName(), new MailBoxMessages(mailBox.stream().toList()));
        }
    }

    @Override
    public void sendMsg(Message m) throws Exception {
        super.sendMsg(m);
        this.eventLogger.publishEvent(getAgName(), new SendMessage(m));
    }
}
