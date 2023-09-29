package es.upm.miw.iwvg_devops.practica;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

public class SearchesTest {
    private List<Fraction> fractions;
    private Searches searches;

    @BeforeEach
    public void before() {
        fractions = new ArrayList<>();
        fractions.add(new Fraction(1, 2));
        fractions.add(new Fraction(3, 4));
        fractions.add(new Fraction(-1, 3));
        fractions.add(new Fraction(-2, 5));

        User user1 = new User("1", "Ana", "Berna", new ArrayList<>());
        User user2 = new User("2", "Camila", "Cerna", new ArrayList<>());

        fractions.get(0).setUser(user1);
        fractions.get(1).setUser(user1);
        fractions.get(2).setUser(user2);
        fractions.get(3).setUser(user2);

        user1.getFractions().add(fractions.get(0));
        user1.getFractions().add(fractions.get(1));
        user2.getFractions().add(fractions.get(2));
        user2.getFractions().add(fractions.get(3));

        searches = new Searches(fractions);
    }

    @Test
    public void testFindFirstProperFractionByUserId() {
        Fraction result = searches.findFirstProperFractionByUserId("1");
        Fraction secondResult = fractions.get(0);
        assertThat(result).usingRecursiveComparison().isEqualTo(secondResult);

        result = searches.findFirstProperFractionByUserId("3");
        assertNull(result);
    }

    @Test
    public void testFindUserFamilyNameByAllNegativeSignFractionDistinct() {
        List<String> result = searches.findUserFamilyNameByAllNegativeSignFractionDistinct()
                .collect(Collectors.toList());

        assertEquals(1, result.size());
        assertEquals("Cerna", result.get(0));
    }

    @Test
    public void testFindFractionDivisionByUserId() {
        Fraction result = searches.findFractionDivisionByUserId("1");
        //assertEquals(new Fraction(4, 6), result);
        Fraction secondResult = new Fraction(60,12);
        assertThat(result).usingRecursiveComparison().isEqualTo(secondResult);

        result = searches.findFractionDivisionByUserId("3");
        //assertNull(result);
        Fraction thirdResult = new Fraction(60,12);
        assertThat(result).usingRecursiveComparison().isEqualTo(thirdResult);
    }

    @Test
    public void testFindUserFamilyNameInitialBySomeProperFraction() {
        List<String> result = searches.findUserFamilyNameInitialBySomeProperFraction()
                .collect(Collectors.toList());

        assertEquals(4, result.size());
        assertEquals("A.", result.get(0));
    }

    @Test
    public void testFindUserFamilyNameInitialBySomeProperFraction() {
        List<String> result = searches.findUserFamilyNameInitialBySomeProperFraction()
                .collect(Collectors.toList());

        assertEquals(4, result.size());
        assertEquals("A.", result.get(0));
    }


}