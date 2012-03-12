import junit.framework.Assert;
import org.junit.Test;

/**
 * Go IntelliJ IDEA!
 * User: Austin
 * Date: 2/18/12
 * Time: 2:45 PM
 */
public class AmicablePairizerTest {
    @Test
    public void ShouldFindSumOfProperDivisorsFor220() {
        int toTest = 220;

        AmicablePairizer amicablePairizer = new AmicablePairizer();
        int result = amicablePairizer.GetSumOfProperDivisors(toTest);

        Assert.assertEquals(284, result);
    }

    @Test
    public void ShouldFindSumOfProperDivisorsFor284() {
        int toTest = 284;

        AmicablePairizer amicablePairizer = new AmicablePairizer();
        int result = amicablePairizer.GetSumOfProperDivisors(toTest);

        Assert.assertEquals(220, result);
    }

    @Test
    public void ShouldRecognizeAmicablePair() {
        int first = 220;
        int second = 284;

        AmicablePairizer amicablePairizer = new AmicablePairizer();
        boolean result = amicablePairizer.IsAmicablePair(first, second);

        Assert.assertEquals(true, result);
    }

    @Test
    public void ShouldGetSumOfAllAmicablePairsUnder10000() {
        int toTest = 10000;

        AmicablePairizer amicablePairizer = new AmicablePairizer();
        int result = amicablePairizer.GetSumOfAmicableNumbersUnder(toTest);

        Assert.assertEquals(31626, result);
    }
}
