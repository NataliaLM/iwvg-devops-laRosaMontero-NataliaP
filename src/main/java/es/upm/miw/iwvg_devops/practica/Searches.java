package es.upm.miw.iwvg_devops.practica;

import org.apache.logging.log4j.LogManager;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Stream;

public class Searches {
    private final List<Fraction> fractions;

    public Searches(List<Fraction> fractions) {
        this.fractions = fractions;
    }

    public Fraction findFirstProperFractionByUserId(String id) {
        return fractions.stream()
                .filter(fraction -> fraction.getUser() != null && fraction.getUser().getId().equals(id))
                .filter(Fraction::isProper)
                .findFirst()
                .orElse(null);
    }

    public Stream<String> findUserFamilyNameByAllNegativeSignFractionDistinct() {
        return fractions.stream()
                .filter(fraction -> fraction.getNumerator() < 0)
                .map(fraction -> fraction.getUser().getFamilyName())
                .distinct();
    }

    public Fraction findFractionDivisionByUserId(String id) {
        return fractions.stream()
                .filter(fraction -> fraction.getUser() != null && fraction.getUser().getId().equals(id))
                .reduce(Fraction::divide)
                .orElse(null);
    }

    public Stream<String> findUserFamilyNameInitialBySomeProperFraction() {
        return fractions.stream()
                .filter(Fraction::isProper)
                .map(fraction -> fraction.getUser().initials());
    }

}
