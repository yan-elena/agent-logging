package event.eventInfo;

import jason.asSyntax.ASSyntax;
import jason.asSyntax.Structure;
import jason.asSyntax.Term;
import jason.asSyntax.parser.ParseException;

import java.util.List;
import java.util.Optional;

/**
 * A class that save the relevant information about a goal's reason.
 */
public class ReasonInfo {

    private final Optional<String> reason;
    private final Optional<String> functor;
    private final Optional<List<String>> terms;

    /**
     * Creates an instance of {@link ReasonInfo}.
     * @param reason the reason as a term from which the information is to be extracted
     * @throws ParseException if the reason is not a term
     */
    public ReasonInfo(Term reason) throws ParseException {
        this.reason = Optional.ofNullable(reason).map(Term::toString);
        if (reason != null) {
            if (reason.isStructure()) {
                Structure reasonStructure = ASSyntax.parseStructure(reason.toString());
                functor = Optional.of(reasonStructure.getFunctor());
                terms = Optional.of(reasonStructure.getTerms().stream().map(Term::toString).toList());
            } else {
                functor = Optional.of(reason.toString());
                terms = Optional.empty();
            }
        } else {
            this.functor = Optional.empty();
            this.terms = Optional.empty();
        }
    }

    /**
     * Returns the reason.
     * @return reason
     */
    public Optional<String> getReason() {
        return reason;
    }

    /**
     * Returns an optional that contains the functor of the reason.
     * @return the functor of the reason
     */
    public Optional<String> getFunctor() {
        return functor;
    }

    /**
     * Returns an optional that contains a list of terms of the reason.
     * @return a list of terms
     */
    public Optional<List<String>> getTerms() {
        return terms;
    }

    @Override
    public String toString() {
        return reason.map(r -> " with reason: " + r).orElse("");
    }
}
