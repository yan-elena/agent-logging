package event.eventInfo;

import jason.asSyntax.Literal;
import jason.asSyntax.Term;
import jason.asSyntax.Trigger;

import java.util.List;
import java.util.Optional;

/**
 * A class that save the relevant information about a triggering event.
 */
public class BeliefInfo {

    private final String literal;
    private final String functor;
    private final String operator;
    private final Optional<String> perceptType;
    private final Optional<String> source;
    private final Optional<List<String>> terms;

    /**
     * Creates a new instance of {@link BeliefInfo} from the given trigger event.
     * @param trigger a {@link Trigger} object that represents the event
     */
    public BeliefInfo(Trigger trigger) {
        this.literal = trigger.getLiteral().toString();
        this.functor = trigger.getLiteral().getFunctor();
        this.operator = trigger.getOperator().toString();
        if (trigger.getLiteral().getTerms() != null) {
            this.terms = Optional.of(trigger.getLiteral().getTerms().stream().map(Term::toString).toList());
        } else {
            this.terms = Optional.empty();
        }
        Literal type = trigger.getLiteral().getAnnot("percept_type");
        Literal src = trigger.getLiteral().getAnnot("source");
        this.perceptType = type == null ? Optional.empty() : Optional.of(type.getTerm(0).toString());
        this.source = src == null ? Optional.empty() : Optional.of(src.getTerm(0).toString());
    }

    /**
     * Returns the literal part of the event.
     * @return event literal
     */
    public String getLiteral() {
        return literal;
    }

    /**
     * Returns the functor part of the triggering event.
     * @return event functor
     */
    public String getFunctor() {
        return functor;
    }

    /**
     * Returns the operator of the triggering event.
     * @return event operator
     */
    public String getOperator() {
        return operator;
    }

    /**
     * Returns the percept type of the belief.
     * @return an optional of the type
     */
    public Optional<String> getPerceptType() {
        return perceptType;
    }

    /**
     * Returns the source of the belief
     * @return an optional of the source
     */
    public Optional<String> getSource() {
        return source;
    }

    /**
     * Returns an optional of terms of the triggering event.
     * @return an optional of terms
     */
    public Optional<List<String>> getTerms() {
        return terms;
    }
}
