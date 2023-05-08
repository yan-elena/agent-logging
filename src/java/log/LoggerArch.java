package log;

import event.actionEvent.ActionFinished;
import event.actionEvent.ActionTriggered;
import event.actionEvent.ExecutedDeed;
import event.actionEvent.InternalActionFinished;
import event.reasoningCycleEvent.ReasoningCycleStarted;
import event.speechActMessageEvent.MailBoxMessages;
import event.speechActMessageEvent.SendMessage;
import jason.architecture.AgArch;
import jason.asSemantics.ActionExec;
import jason.asSemantics.Message;
import jason.asSyntax.PlanBody;
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

    // works only with jacamo1.2-SNAPSHOT
    @Override
    public void act(ActionExec action) {
        super.act(action);
        eventLogger.publishEvent(getAgName(), new ActionTriggered(action));
    }

    @Override
    public void reasoningCycleStarting() {
        super.reasoningCycleStarting();
        eventLogger.publishEvent(getAgName(), new ReasoningCycleStarted(getCycleNumber()));
    }

    @Override
    public void reasoningCycleFinished() {
        super.reasoningCycleFinished();
        PlanBody lastDeed = getTS().getC().getLastDeed();
        if (lastDeed != null) {
            switch (lastDeed.getBodyType()) {
                case action -> eventLogger.publishEvent(getAgName(), new ActionFinished(lastDeed));
                case internalAction -> eventLogger.publishEvent(getAgName(), new InternalActionFinished(lastDeed));
                default -> eventLogger.publishEvent(getAgName(), new ExecutedDeed(lastDeed));
            }

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
