import junit.framework.Assert;
import org.junit.Test;

/**
 * Go IntelliJ IDEA!
 * User: Austin
 * Date: 4/15/12
 * Time: 6:35 PM
 */
public class IrrationalDecimalFractionIndexerTest {
    @Test
    public void ShouldFind12thDigitInDecimalMadeOfConcatenatedPositiveIntegers() {
        int index = 12;
        int expected = 1;

        IrrationalDecimalFractionIndexer indexer = new IrrationalDecimalFractionIndexer();
        int result = indexer.GetNthDigitInDecimalMadeOfConcatenatedPositiveIntegers(index);

        Assert.assertEquals(expected, result);
    }

    @Test
    public void ShouldFind11thDigitInDecimalMadeOfConcatenatedPositiveIntegers() {
        int index = 11;
        int expected = 0;

        IrrationalDecimalFractionIndexer indexer = new IrrationalDecimalFractionIndexer();
        int result = indexer.GetNthDigitInDecimalMadeOfConcatenatedPositiveIntegers(index);

        Assert.assertEquals(expected, result);
    }

    @Test
    public void ShouldFind13thDigitInDecimalMadeOfConcatenatedPositiveIntegers() {
        int index = 15;
        int expected = 2;

        IrrationalDecimalFractionIndexer indexer = new IrrationalDecimalFractionIndexer();
        int result = indexer.GetNthDigitInDecimalMadeOfConcatenatedPositiveIntegers(index);

        Assert.assertEquals(expected, result);
    }

    @Test
    public void ShouldFindValueOf12thAnd15thDigits() {
        int expected = 3;
        IrrationalDecimalFractionIndexer indexer = new IrrationalDecimalFractionIndexer();
        int result = indexer.GetNthDigitInDecimalMadeOfConcatenatedPositiveIntegers(12) + indexer.GetNthDigitInDecimalMadeOfConcatenatedPositiveIntegers(15);

        Assert.assertEquals(expected, result);
    }

    @Test
    public void ShouldFindValueOf1000000thDigit() {
        int index = 1000000;
        int expected = 1;

        IrrationalDecimalFractionIndexer indexer = new IrrationalDecimalFractionIndexer();
        int result = indexer.GetNthDigitInDecimalMadeOfConcatenatedPositiveIntegers(index);

        Assert.assertEquals(expected, result);
    }

    //Problem 40
    @Test
    public void ShouldSolveProblem40() {
        //d1 * d10 ... * d1000000
        int expected = 210;

        IrrationalDecimalFractionIndexer indexer = new IrrationalDecimalFractionIndexer();
        int result = indexer.GetNthDigitInDecimalMadeOfConcatenatedPositiveIntegers(1000000)
                * indexer.GetNthDigitInDecimalMadeOfConcatenatedPositiveIntegers(10)
                * indexer.GetNthDigitInDecimalMadeOfConcatenatedPositiveIntegers(100)
                * indexer.GetNthDigitInDecimalMadeOfConcatenatedPositiveIntegers(1000)
                * indexer.GetNthDigitInDecimalMadeOfConcatenatedPositiveIntegers(10000)
                * indexer.GetNthDigitInDecimalMadeOfConcatenatedPositiveIntegers(100000);
        Assert.assertEquals(expected, result);
    }
}
