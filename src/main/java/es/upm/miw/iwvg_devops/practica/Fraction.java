package es.upm.miw.iwvg_devops.practica;

public class Fraction {
    private int numerator;
    private int denominator;
    private User user;

    public Fraction(int numerator, int denominator) {
        this.numerator = numerator;
        this.denominator = denominator;
    }
    public Fraction(int numerator, int denominator, User user) {
        this.numerator = numerator;
        this.denominator = denominator;
        this.user = user;
    }

    public Fraction() {
        this(1, 1);
    }

    public int getNumerator() {
        return numerator;
    }

    public void setNumerator(int numerator) {
        this.numerator = numerator;
    }

    public int getDenominator() {
        return denominator;
    }

    public void setDenominator(int denominator) {
        this.denominator = denominator;
    }

    public double decimal() {
        return (double) numerator / denominator;
    }

    public boolean isProper() {
        return Math.abs(numerator) < Math.abs(denominator);
    }

    public boolean isImproper() {
        return Math.abs(numerator) >= Math.abs(denominator);
    }

    public boolean isEquivalent(Fraction fraction) {
        int greatestCommonDivisor = greatestCommonDivisor(Math.abs(numerator), Math.abs(denominator));
        int fractionGreatestCommonDivisor = greatestCommonDivisor(Math.abs(fraction.numerator), Math.abs(fraction.denominator));
        int reducedNumerator = numerator / greatestCommonDivisor;
        int reducedDenominator = denominator / greatestCommonDivisor;
        int fractionReducedNumerator = fraction.numerator / fractionGreatestCommonDivisor;
        int fractionReducedDenominator = fraction.denominator / fractionGreatestCommonDivisor;
        return (reducedNumerator == fractionReducedNumerator) && (reducedDenominator == fractionReducedDenominator);
    }

    public Fraction add(Fraction fraction) {
        int newNumerator = numerator * fraction.denominator + fraction.numerator * denominator;
        int newDenominator = denominator * fraction.denominator;
        return new Fraction(newNumerator, newDenominator);
    }

    public Fraction multiply(Fraction fraction) {
        int newNumerator = numerator * fraction.numerator;
        int newDenominator = denominator * fraction.denominator;
        return new Fraction(newNumerator, newDenominator);
    }

    public Fraction divide(Fraction fraction) {
        int newNumerator = numerator * fraction.denominator;
        int newDenominator = denominator * fraction.numerator;
        return new Fraction(newNumerator, newDenominator);
    }

    private int greatestCommonDivisor(int numerator, int denominator) {
        while (denominator != 0) {
            int temporal = denominator;
            denominator = numerator % denominator;
            numerator = temporal;
        }
        return Math.abs(numerator);
    }

    @Override
    public String toString() {
        return "Fraction{" +
                "numerator=" + numerator +
                ", denominator=" + denominator +
                '}';
    }


    public User getUser() {
        return user;
    }
    public void setUser(User user) {
        this.user = user;
    }
}
