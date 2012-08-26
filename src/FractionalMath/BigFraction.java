package FractionalMath;

import java.math.BigInteger;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: austin
 * Date: 8/24/12
 * Time: 8:04 PM
 * To change this template use File | Settings | File Templates.
 */
public class BigFraction {

    private final BigInteger Numerator;
    private final BigInteger Denominator;

    public BigFraction(BigInteger numerator, BigInteger denominator)
    {
        Numerator = numerator;
        Denominator = denominator;
    }

    public BigFraction(BigFraction given) {
        Numerator = given.getNumerator();
        Denominator = given.getDenominator();
    }

    public BigFraction(BigInteger numerator, BigFraction given) {
        Numerator = given.getDenominator().multiply(numerator);
        Denominator = given.getNumerator();
    }

    public BigFraction Reduced() {
        return ReduceFraction(this);
    }

    private BigFraction ReduceFraction(BigFraction bigFraction) {
        BigInteger greatestCommonFactor = FindGreatestCommonFactor(bigFraction);

        if(greatestCommonFactor.compareTo(BigInteger.ZERO) > 0)
        {
            return new BigFraction(bigFraction.getNumerator().divide(greatestCommonFactor), bigFraction.getDenominator().divide(greatestCommonFactor));
        }
        return bigFraction;
    }

    public BigInteger GreatestCommonFactor() {
        return FindGreatestCommonFactor(this);
    }

    private BigInteger FindGreatestCommonFactor(BigFraction bigFraction) {
        BigInteger toReturn = BigInteger.ZERO;
        BigFactorizer factorizer = new BigFactorizer();
        List<BigInteger> numeratorFactors = factorizer.GetFactorsOf(bigFraction.getNumerator());
        List<BigInteger> denominatorFactors = factorizer.GetFactorsOf(bigFraction.getDenominator());
        for (BigInteger numeratorFactor : numeratorFactors) {
            if(denominatorFactors.contains(numeratorFactor) && toReturn.compareTo(numeratorFactor) < 0)
                toReturn = numeratorFactor;
        }
        return toReturn;
    }

    public int compareTo(BigFraction fraction) {
        double thisOne = this.getNumerator().doubleValue() / this.getDenominator().doubleValue();
        double thatOne = fraction.getNumerator().doubleValue() / fraction.getDenominator().doubleValue();

        if(thisOne > thatOne) return 1;
        if(thisOne < thatOne) return -1;
        return 0;
    }

    public BigFraction Add(int givenInteger) {
        return new BigFraction(getNumerator().add(getDenominator().multiply(new BigInteger(Integer.toString(givenInteger)))), getDenominator());
    }

    public BigInteger getNumerator() {
        return Numerator;
    }

    public BigInteger getDenominator() {
        return Denominator;
    }

}
