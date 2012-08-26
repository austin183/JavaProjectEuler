package FractionalMath;

import junit.framework.Assert;
import org.junit.Ignore;
import org.junit.Test;

import java.math.BigInteger;

/**
 * Created with IntelliJ IDEA.
 * User: austin
 * Date: 8/23/12
 * Time: 7:12 PM
 * To change this template use File | Settings | File Templates.
 */

public class InfiniteContinuedFractionAnalyzerTest {
    @Test
    public void ShouldFindFirstIterationEquals3Over2()
    {
        int numberofIterations = 1;
        BigFraction expected = new BigFraction(new BigInteger("3"), new BigInteger("2"));

        InfiniteContinuedFractionAnalyzer analyzer = new InfiniteContinuedFractionAnalyzer();
        BigFraction result = analyzer.FindValueAtIteration(numberofIterations);

        Assert.assertEquals(0, expected.compareTo(result));
    }

    @Test
    public void ShouldFindSecondIteration1Equals7Over5()
    {
        int numberofIterations = 2;
        BigFraction expected = new BigFraction(new BigInteger("7"), new BigInteger("5"));

        InfiniteContinuedFractionAnalyzer analyzer = new InfiniteContinuedFractionAnalyzer();
        BigFraction result = analyzer.FindValueAtIteration(numberofIterations);

        Assert.assertEquals(0, expected.compareTo(result));
    }

    @Test
    public void ShouldFindThirdIteration1Equals17Over12()
    {
        int numberofIterations = 3;
        BigFraction expected = new BigFraction(new BigInteger("17"), new BigInteger("12"));

        InfiniteContinuedFractionAnalyzer analyzer = new InfiniteContinuedFractionAnalyzer();
        BigFraction result = analyzer.FindValueAtIteration(numberofIterations);

        Assert.assertEquals(0, expected.compareTo(result));
    }

    @Test
    public void FindNumberOfFractionsContainingMoreDigitsInNumeratorThanDenominatorWithin8_Expansions()
    {
        int numberOfExpansions = 8;

        int expected = 1;

        InfiniteContinuedFractionAnalyzer analyzer = new InfiniteContinuedFractionAnalyzer();
        int result = analyzer.FindNumberOfFractionsContainingMoreDigitsInNumeratorThanDenominatorWithinX_Expansions(numberOfExpansions);

        Assert.assertEquals(expected, result);
    }

    //Problem 57
    @Test
    public void FindNumberOfFractionsContainingMoreDigitsInNumeratorThanDenominatorWithin1000_Expansions()
    {
        int numberOfExpansions = 1000;

        int expected = 153;

        InfiniteContinuedFractionAnalyzer analyzer = new InfiniteContinuedFractionAnalyzer();
        int result = analyzer.FindNumberOfFractionsContainingMoreDigitsInNumeratorThanDenominatorWithinX_Expansions(numberOfExpansions);

        Assert.assertEquals(expected, result);
    }
}
