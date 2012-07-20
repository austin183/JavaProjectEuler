import org.junit.Assert;
import org.junit.Test;

/**
 * Created with IntelliJ IDEA.
 * User: austin
 * Date: 7/19/12
 * Time: 10:39 PM
 * To change this template use File | Settings | File Templates.
 */
public class NumbersWithSameDigitsInMultiplesFinderTest {
    @Test
    public void ShouldFind125874ToHaveTheSameDigitsAsItsDoubledValue ()
    {
        int toTest = 125874;
        int toReach = 2;
        boolean expected = true;

        NumbersWithSameDigitsInMultiplesFinder finder = new NumbersWithSameDigitsInMultiplesFinder();
        boolean result = finder.VerifyThatAllDigitsInXAreContainedInMultiplesUpTo(toTest, toReach);

        Assert.assertEquals(expected, result);
    }

    @Test
    public void ShouldFind125874ToNotHaveTheSameDigitsAsItsTripledValue ()
    {
        int toTest = 125874;
        int toReach = 3;
        boolean expected = false;

        NumbersWithSameDigitsInMultiplesFinder finder = new NumbersWithSameDigitsInMultiplesFinder();
        boolean result = finder.VerifyThatAllDigitsInXAreContainedInMultiplesUpTo(toTest, toReach);

        Assert.assertEquals(expected, result);
    }

    @Test
    public void ShouldFind125875ToNotHaveTheSameDigitsAsItsDoubledValue ()
    {
        int toTest = 125875;
        int toReach = 2;
        boolean expected = false;

        NumbersWithSameDigitsInMultiplesFinder finder = new NumbersWithSameDigitsInMultiplesFinder();
        boolean result = finder.VerifyThatAllDigitsInXAreContainedInMultiplesUpTo(toTest, toReach);

        Assert.assertEquals(expected, result);
    }


    //Problem 52
    @Test
    public void ShouldFindSmallestValueThatHasTheSameDigitsThroughFirstSixMultiples ()
    {
        int expected = 142857;
        int upTo = 6;

        NumbersWithSameDigitsInMultiplesFinder finder = new NumbersWithSameDigitsInMultiplesFinder();
        int result = finder.FindSmallestPositiveIntegerForMultiplesUpToX(upTo);

        Assert.assertEquals(expected, result);
    }
}
