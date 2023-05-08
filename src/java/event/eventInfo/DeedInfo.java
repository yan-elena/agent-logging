package event.eventInfo;

import jason.asSyntax.PlanBody;

/**
 * A class that save the relevant information about a deed.
 */
public class DeedInfo {

    private final String term;
    private final String type;
    private final String srcInfo;

    /**
     * Creates a new instance of {@link DeedInfo} from the given plan body.
     * @param deed a {@link PlanBody} of the deed
     */
    public DeedInfo(PlanBody deed) {
        this.term = deed.getBodyTerm().toString();
        this.type = deed.getBodyType().name();
        this.srcInfo = deed.getSrcInfo().toString();
    }

    /**
     * Retrieves the term of the deed.
     * @return deed term
     */
    public String getTerm() {
        return term;
    }

    /**
     * Retrieves the type of the deed.
     * @return deed type
     */
    public String getType() {
        return type;
    }

    /**
     * Retrieves the source file and line information.
     * @return deed src info
     */
    public String getSrcInfo() {
        return srcInfo;
    }
}
