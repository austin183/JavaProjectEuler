import junit.framework.Assert;
import org.junit.Test;

import java.math.BigInteger;

/**
 * Created with IntelliJ IDEA.
 * User: austin
 * Date: 8/3/12
 * Time: 7:48 PM
 * To change this template use File | Settings | File Templates.
 */
public class MaximumDigitalSumizerTest {
    @Test
    public void ShouldGetDigitalSumOf10ToThe100As1()
    {
        int a = 10;
        int b = 100;

        int expected = 1;

        MaximumDigitalSumizer sumizer = new MaximumDigitalSumizer();
        int result = sumizer.GetDigitalSum(a, b);

        Assert.assertEquals(expected, result);
    }

    @Test
    public void ShouldGetDigitalSumOf2ToThe4()
    {
        int a = 2;
        int b = 4;

        int expected = 7;

        MaximumDigitalSumizer sumizer = new MaximumDigitalSumizer();
        int result = sumizer.GetDigitalSum(a, b);

        Assert.assertEquals(expected, result);
    }

    //Problem 56
    @Test
    public void ShouldGetMaximumDigitalSumForNumbersUpTo100To100()
    {
        int a = 100;
        int b = 100;

        int expected = 972;

        MaximumDigitalSumizer sumizer = new MaximumDigitalSumizer();
        int result = sumizer.GetMaximumDigitalSumOfAToBUnder(a, b);

        Assert.assertEquals(expected, result);
    }


}
