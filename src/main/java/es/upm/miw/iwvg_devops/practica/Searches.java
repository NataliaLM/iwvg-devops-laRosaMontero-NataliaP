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

    public Fraction findFirstProperFractionByUserId(int userId) {
        Optional<Fraction> properFraction = fractions.stream()
                .filter(fraction -> fraction.isProper() && fraction.getUserId() == userId)
                .findFirst();

        return properFraction.orElse(null);
    }


}
