package es.upm.miw.iwvg_devops.practica;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

public class SearchesTest {
    private Searches searches;

    @BeforeEach
    public void begin() {
        List<Fraction> fractions = new ArrayList<>();
        fractions.add(new Fraction(1, 2, 1));
        fractions.add(new Fraction(3, 4, 2));
        fractions.add(new Fraction(-1, 3, 3));
        searches = new Searches(fractions);
    }
    @Test
    public void testFindFirstProperFractionByUserId() {
        Fraction result = searches.findFirstProperFractionByUserId(1);
        assertThat(result).usingRecursiveComparison().isEqualTo(new Fraction(1, 2, 1));

        result = searches.findFirstProperFractionByUserId(4);
        assertNull(result);
    }
}
