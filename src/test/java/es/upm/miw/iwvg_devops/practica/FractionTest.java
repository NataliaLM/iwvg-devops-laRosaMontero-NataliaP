package es.upm.miw.iwvg_devops.practica;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
public class FractionTest {
    private Fraction fraction;

    @BeforeEach
    public void setUp() {
        fraction = new Fraction(5, 6);
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
}
