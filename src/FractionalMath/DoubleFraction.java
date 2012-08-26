package FractionalMath;

import java.util.List;

/**
 * Go IntelliJ IDEA!
 * User: Austin
 * Date: 3/28/12
 * Time: 8:53 PM
 */
public class DoubleFraction {
    private Double Numerator;
    private Double Denominator;

    public DoubleFraction(Double numerator, Double denominator) {
        setNumerator(numerator);
        setDenominator(denominator);
        Normalize();
    }

    public DoubleFraction(DoubleFraction fraction)
    {
        setNumerator(fraction.getNumerator());
        setDenominator(fraction.getDenominator());
        Normalize();
    }

    public DoubleFraction(int multiplier, DoubleFraction fraction) {
        setNumerator(multiplier * fraction.getDenominator());
        setDenominator(fraction.getNumerator());
    }

    private void Normalize() {
        if(getNumerator() % 1 != 0 || getDenominator() % 1 != 0)
        {
            double exponent = 1;
            double using;
            if(getNumerator() > getDenominator())
                using = getNumerator();
            else using = getDenominator();
            while(((using * Math.pow(10, exponent)) % 1) != 0)
            {
                exponent++;
            }
            setNumerator(getNumerator() * Math.pow(10, exponent));
            setDenominator(getDenominator() * Math.pow(10, exponent));
        }
    }

    private DoubleFraction ReduceFraction(DoubleFraction fraction) {
        int greatestCommonFactor = FindGreatestCommonFactor(fraction);

        if(greatestCommonFactor != 0)
            return new DoubleFraction(fraction.getNumerator() / greatestCommonFactor, fraction.getDenominator() / greatestCommonFactor);
        return fraction;
    }

    private int FindGreatestCommonFactor(DoubleFraction fraction) {
        int toReturn = 0;
        Factorizer factorizer = new Factorizer();
        List<Integer> numeratorFactors = factorizer.GetFactorsOf(fraction.getNumerator().intValue());
        List<Integer> denominatorFactors = factorizer.GetFactorsOf(fraction.getDenominator().intValue());
        for (Integer numeratorFactor : numeratorFactors) {
            if(denominatorFactors.contains(numeratorFactor) && numeratorFactor > toReturn)
                toReturn = numeratorFactor;
        }
        return toReturn;
    }

    public DoubleFraction Reduced() {
        return ReduceFraction(this);
    }

    public int GreatestCommonFactor()
    {
        return FindGreatestCommonFactor(this);
    }

    public int compareTo(DoubleFraction fraction) {
        double thisOne = this.getNumerator() / this.getDenominator();
        double thatOne = fraction.getNumerator() / fraction.getDenominator();

        if(thisOne > thatOne) return 1;
        if(thisOne < thatOne) return -1;
        return 0;
    }

    public DoubleFraction Add(int givenInteger) {
        return new DoubleFraction(getNumerator() + (getDenominator() * givenInteger), getDenominator());
    }

    public Double getNumerator() {
        return Numerator;
    }

    void setNumerator(Double numerator) {
        Numerator = numerator;
    }

    public Double getDenominator() {
        return Denominator;
    }

    void setDenominator(Double denominator) {
        Denominator = denominator;
    }
}
