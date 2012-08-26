package FractionalMath;

import java.math.BigInteger;


/**
 * Created with IntelliJ IDEA.
 * User: austin
 * Date: 8/3/12
 * Time: 8:29 PM
 * To change this template use File | Settings | File Templates.
 */
class InfiniteContinuedFractionAnalyzer {
    public BigFraction FindValueAtIteration(int numberofIterations) {
        BigFraction currentSecondaryFraction = new BigFraction(BigInteger.ONE, new BigInteger("2"));
        for(int i = 1; i < numberofIterations; i++)
        {
             currentSecondaryFraction = new BigFraction(BigInteger.ONE, currentSecondaryFraction.Add(2));
        }
        return currentSecondaryFraction.Add(1);
    }

    public int FindNumberOfFractionsContainingMoreDigitsInNumeratorThanDenominatorWithinX_Expansions(int x)
    {
        int toReturn = 0;
        for(int i = 1; i <= x; i++)
        {
            BigFraction currentValue = FindValueAtIteration(i);

            if(currentValue.getNumerator().toString().length() > currentValue.getDenominator().toString().length())
                toReturn++;
        }
        return toReturn;
    }
}
