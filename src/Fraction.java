import java.util.List;

/**
 * Go IntelliJ IDEA!
 * User: Austin
 * Date: 3/28/12
 * Time: 8:53 PM
 */
class Fraction implements Comparable<Fraction> {
    public double Numerator;
    public double Denominator;

    public Fraction(double numerator, double denominator) {
        Numerator = numerator;
        Denominator = denominator;
        Normalize();
    }

    public Fraction(Fraction fraction)
    {
        Numerator = fraction.Numerator;
        Denominator = fraction.Denominator;
        Normalize();
    }

    public Fraction(int multiplier, Fraction fraction) {
        Numerator = multiplier * fraction.Denominator;
        Denominator = fraction.Numerator;
    }

    private void Normalize() {
        if(Numerator % 1 != 0 || Denominator % 1 != 0)
        {
            double exponent = 1;
            double using;
            if(Numerator > Denominator)
                using = Numerator;
            else using = Denominator;
            while(((using * Math.pow(10, exponent)) % 1) != 0)
            {
                exponent++;
            }
            Numerator = Numerator * Math.pow(10, exponent);
            Denominator = Denominator * Math.pow(10, exponent);
        }
    }

    private Fraction ReduceFraction(Fraction fraction) {
        int greatestCommonFactor = FindGreatestCommonFactor(fraction);

        if(greatestCommonFactor != 0)
            return new Fraction((int)fraction.Numerator / greatestCommonFactor, (int)fraction.Denominator / greatestCommonFactor);
        return fraction;
    }

    private int FindGreatestCommonFactor(Fraction fraction) {
        int toReturn = 0;
        Factorizer factorizer = new Factorizer();
        List<Integer> numeratorFactors = factorizer.GetFactorsOf((int) fraction.Numerator);
        List<Integer> denominatorFactors = factorizer.GetFactorsOf((int) fraction.Denominator);
        for (Integer numeratorFactor : numeratorFactors) {
            if(denominatorFactors.contains(numeratorFactor) && numeratorFactor > toReturn)
                toReturn = numeratorFactor;
        }
        return toReturn;
    }

    public Fraction Reduced() {
        return ReduceFraction(this);
    }

    public int GreatestCommonFactor()
    {
        return FindGreatestCommonFactor(this);
    }

    @Override
    public int compareTo(Fraction fraction) {
        double thisOne = this.Numerator / this.Denominator;
        double thatOne = fraction.Numerator / fraction.Denominator;

        if(thisOne > thatOne) return 1;
        if(thisOne < thatOne) return -1;
        return 0;
    }

    public Fraction Add(int givenInteger) {
        return new Fraction(Numerator + (Denominator * givenInteger), Denominator);
    }
}
