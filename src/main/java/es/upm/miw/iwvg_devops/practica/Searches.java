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


}
