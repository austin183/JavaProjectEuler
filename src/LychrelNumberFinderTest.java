import junit.framework.Assert;
import org.junit.Test;

import java.math.BigInteger;

/**
 * Created with IntelliJ IDEA.
 * User: austin
 * Date: 8/3/12
 * Time: 6:43 PM
 * To change this template use File | Settings | File Templates.
 */
public class LychrelNumberFinderTest {
    @Test
    public void ShouldFind47ToNotBeLychrel()
    {
        BigInteger value = new BigInteger("47");
        boolean expected = false;

        LychrelNumberFinder finder = new LychrelNumberFinder();
        boolean result = finder.IsLychrel(value);

        Assert.assertEquals(expected, result);
    }

    @Test
    public void ShouldFine196ToBeLychrel()
    {
        BigInteger value = new BigInteger("196");
        boolean expected = true;

        LychrelNumberFinder finder = new LychrelNumberFinder();
        boolean result = finder.IsLychrel(value);

        Assert.assertEquals(expected, result);
    }

    //Problem 55
    @Test
    public void ShouldFindCountOfAllLychrelNumbersBelow10000()
    {
        int value = 10000;
        int expected = 249;

        LychrelNumberFinder finder = new LychrelNumberFinder();
        int result = finder.FindLychrelNumbersBelowValue(value);

        Assert.assertEquals(expected, result);
    }

}
