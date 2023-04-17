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

    private final String reason;
    private final Optional<String> functor;
    private final Optional<List<String>> terms;

    /**
     * Creates an instance of {@link ReasonInfo}.
     * @param reason the reason as a term from which the information is to be extracted
     */
    public ReasonInfo(Term reason) {
        Optional<String> functor = Optional.empty();
        Optional<List<String>> terms = Optional.empty();
        this.reason = reason.toString().replace("_", " ");
        if (reason.isStructure()) {
            try {
                Structure reasonStructure  = ASSyntax.parseStructure(reason.toString());
                functor = Optional.of(reasonStructure.getFunctor());
                terms = Optional.of(reasonStructure.getTerms().stream().map(Term::toString).toList());
            } catch (ParseException e) {
                e.printStackTrace();
            }
        } else {
            functor = Optional.of(reason.toString());
        }
        this.terms = terms;
        this.functor = functor;
    }

    /**
     * Returns the reason.
     * @return reason
     */
    public String getReason() {
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
        if (functor.isPresent()) {
            Optional<ReasonType> type = ReasonType.getReasonType(functor.get());
            if (type.isPresent() && terms.isPresent()) {
                switch (type.get()) {
                    case ACTION_EXECUTED -> {
                        return " because action " + terms.get().get(0) + " is executed";
                    }
                    case ACTION -> {
                        return " to execute action " + terms.get().get(0);
                    }
                }
            }
        }
        return " with reason: " + reason;
    }
}
