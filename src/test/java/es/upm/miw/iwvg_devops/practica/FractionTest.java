package es.upm.miw.iwvg_devops.practica;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;
public class FractionTest {
    private Fraction fraction;
    private Fraction anotherFraction;
    @BeforeEach
    public void before() {

        fraction = new Fraction(7, 6);
        anotherFraction = new Fraction(3, 4);
    }

    @Test
    public void testConstructorWithParameters() {
        assertEquals(7, fraction.getNumerator());
        assertEquals(6, fraction.getDenominator());
    }

    @Test
    public void testDefaultConstructor() {
        Fraction defaultFraction = new Fraction();
        assertEquals(1, defaultFraction.getNumerator());
        assertEquals(1, defaultFraction.getDenominator());
    }

    @Test
    public void testSetNumerator() {
        fraction.setNumerator(4);
        assertEquals(4, fraction.getNumerator());
    }

    @Test
    public void testSetDenominator() {
        fraction.setDenominator(5);
        assertEquals(5, fraction.getDenominator());
    }

    @Test
    public void testDecimal() {
        assertEquals(7.0 / 6.0, fraction.decimal(), 0.0001);
    }

    @Test
    public void testToString() {
        assertEquals("Fraction{numerator=7, denominator=6}", fraction.toString());
    }

    @Test
    public void testIsProper() {
        assertFalse(fraction.isProper());
        assertTrue(anotherFraction.isProper());
    }

    @Test
    public void testIsImproper() {
        assertTrue(fraction.isImproper());
        assertFalse(anotherFraction.isImproper());
    }

    @Test
    public void testIsEquivalent() {
        Fraction equivalentFraction = new Fraction(14, 12);
        assertTrue(fraction.isEquivalent(equivalentFraction));
        assertFalse(fraction.isEquivalent(anotherFraction));
    }

    @Test
    public void testAdd() {
        Fraction result = fraction.add(anotherFraction);
        Fraction secondResult = new Fraction(46, 24);
        assertThat(result).usingRecursiveComparison().isEqualTo(secondResult);
    }

    @Test
    public void testMultiply() {
        Fraction result = fraction.multiply(anotherFraction);
        Fraction secondResult = new Fraction(21, 24);
        assertThat(result).usingRecursiveComparison().isEqualTo(secondResult);
    }

    @Test
    public void testDivide() {
        Fraction result = fraction.divide(anotherFraction);
        Fraction secondResult = new Fraction(28, 18);
        assertThat(result).usingRecursiveComparison().isEqualTo(secondResult);
    }

}
