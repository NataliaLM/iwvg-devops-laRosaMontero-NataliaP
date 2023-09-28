package es.upm.miw.iwvg_devops.practica;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
public class FractionTest {
    private Fraction fraction;
    private Fraction anotherFraction;
    @BeforeEach
    public void before() {

        fraction = new Fraction(5, 6);
        anotherFraction = new Fraction(3, 4);
    }

    @Test
    public void testConstructorWithParameters() {
        assertEquals(5, fraction.getNumerator());
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
        assertEquals(5.0 / 6.0, fraction.decimal(), 0.0001);
    }

    @Test
    public void testToString() {
        assertEquals("Fraction{numerator=5, denominator=6}", fraction.toString());
    }

    @Test
    public void testIsProper() {
        assertTrue(fraction.isProper());
        assertFalse(anotherFraction.isProper());
    }

    @Test
    public void testIsImproper() {
        assertFalse(fraction.isImproper());
        assertTrue(anotherFraction.isImproper());
    }

    @Test
    public void testIsEquivalent() {
        Fraction equivalentFraction = new Fraction(15, 24);
        assertTrue(fraction.isEquivalent(equivalentFraction));
        assertFalse(fraction.isEquivalent(anotherFraction));
    }

    @Test
    public void testAdd() {
        Fraction result = fraction.add(anotherFraction);
        assertEquals(new Fraction(17, 12), result);
    }

    @Test
    public void testMultiply() {
        Fraction result = fraction.multiply(anotherFraction);
        assertEquals(new Fraction(1, 2), result);
    }

    @Test
    public void testDivide() {
        Fraction result = fraction.divide(anotherFraction);
        assertEquals(new Fraction(8, 9), result);
    }

}
