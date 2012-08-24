import junit.framework.Assert;
import org.junit.Ignore;
import org.junit.Test;

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
        Fraction expected = new Fraction(3, 2);

        InfiniteContinuedFractionAnalyzer analyzer = new InfiniteContinuedFractionAnalyzer();
        Fraction result = analyzer.FindValueAtIteration(numberofIterations);

        Assert.assertEquals(0, expected.compareTo(result));
    }

    @Test
    public void ShouldFindSecondIteration1Equals7Over5()
    {
        int numberofIterations = 2;
        Fraction expected = new Fraction(7, 5);

        InfiniteContinuedFractionAnalyzer analyzer = new InfiniteContinuedFractionAnalyzer();
        Fraction result = analyzer.FindValueAtIteration(numberofIterations);

        Assert.assertEquals(0, expected.compareTo(result));
    }

    @Test
    public void ShouldFindThirdIteration1Equals17Over12()
    {
        int numberofIterations = 3;
        Fraction expected = new Fraction(17, 12);

        InfiniteContinuedFractionAnalyzer analyzer = new InfiniteContinuedFractionAnalyzer();
        Fraction result = analyzer.FindValueAtIteration(numberofIterations);

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

    @Test
    @Ignore("I think there is a problem with the double type for this problem.  I will reimplement Fraction with BigInteger.")
    public void FindNumberOfFractionsContainingMoreDigitsInNumeratorThanDenominatorWithin1000_Expansions()
    {
        int numberOfExpansions = 1000;

        int expected = 1;

        InfiniteContinuedFractionAnalyzer analyzer = new InfiniteContinuedFractionAnalyzer();
        int result = analyzer.FindNumberOfFractionsContainingMoreDigitsInNumeratorThanDenominatorWithinX_Expansions(numberOfExpansions);

        Assert.assertEquals(expected, result);
    }
}
