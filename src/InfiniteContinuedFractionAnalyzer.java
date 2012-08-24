import junit.framework.Assert;
import org.junit.Test;

import java.text.DecimalFormat;

/**
 * Created with IntelliJ IDEA.
 * User: austin
 * Date: 8/3/12
 * Time: 8:29 PM
 * To change this template use File | Settings | File Templates.
 */
class InfiniteContinuedFractionAnalyzer {
    public Fraction FindValueAtIteration(int numberofIterations) {
        Fraction currentSecondaryFraction = new Fraction(1, 2);
        for(int i = 1; i < numberofIterations; i++)
        {
             currentSecondaryFraction = new Fraction(1, (currentSecondaryFraction.Add(2)));
        }
        return currentSecondaryFraction.Add(1);
    }

    public int FindNumberOfFractionsContainingMoreDigitsInNumeratorThanDenominatorWithinX_Expansions(int x)
    {
        int toReturn = 0;
        for(int i = 1; i <= x; i++)
        {
            Fraction currentValue = FindValueAtIteration(i);

            if(i % 100 == 0)
                System.out.println("Current Fraction = " + currentValue.Numerator + "/" + currentValue.Denominator);

            if(Integer.toString((int)currentValue.Numerator).length() > Integer.toString((int)currentValue.Denominator).length())
                toReturn++;
        }
        return toReturn;
    }
}
