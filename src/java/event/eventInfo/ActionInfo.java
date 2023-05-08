package event.eventInfo;

import jason.asSemantics.ActionExec;

/**
 * A class that save the relevant information about an executed action.
 */
public class ActionInfo {

    private final String term;
    private final String source;
    private final IntentionInfo intention;

    /**
     * Creates a new instance of {@link ActionInfo} from the give action.
     * @param action the {@link ActionExec} that represent the executed action
     */
    public ActionInfo(ActionExec action) {
        this.term = action.getActionTerm().toString();
        this.intention = new IntentionInfo(action.getIntention());
        this.source = action.getActionTerm().getSrcInfo().toString();
    }

    /**
     * Retrieves the term of the action.
     * @return action term
     */
    public String getTerm() {
        return term;
    }

    /**
     * Retrieves the source file and the line of the action.
     * @return action source
     */
    public String getSource() {
        return source;
    }

    /**
     * Retrieves the intention associated to the action.
     * @return action intention
     */
    public IntentionInfo getIntention() {
        return intention;
    }
}
