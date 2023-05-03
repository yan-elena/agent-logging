package event.eventInfo;

import jason.asSyntax.Literal;
import jason.asSyntax.Trigger;

/**
 * A class that save the relevant information about a signal.
 */
public class SignalInfo {

    private final String functor;
    private final String artifactId;
    private final String artifactName;
    private final String perceptType;

    /**
     * Creates a new instance of {@link SignalInfo} from the given signal trigger.
     * @param trigger the signal trigger from which extract the information
     */
    public SignalInfo(Trigger trigger) {
        Literal literal = trigger.getLiteral();
        this.functor = literal.toString().split("\\[")[0];
        this.artifactId = literal.getAnnot("artifact_id").getTerm(0).toString();
        this.artifactName = literal.getAnnot("artifact_name").getTerm(0).toString();
        this.perceptType = literal.getAnnot("percept_type").getTerm(0).toString();
    }

    /**
     * Retrieves the functor of the signal.
     * @return the signal functor
     */
    public String getFunctor() {
        return functor;
    }

    /**
     * Retrieves the artifact's id of the signal.
     * @return artifact id
     */
    public String getArtifactId() {
        return artifactId;
    }

    /**
     * Retrieves the artifact's name of the signal.
     * @return artifact name
     */
    public String getArtifactName() {
        return artifactName;
    }

    /**
     * Retrieves the type of the percept.
     * @return percept type
     */
    public String getPerceptType() {
        return perceptType;
    }
}
