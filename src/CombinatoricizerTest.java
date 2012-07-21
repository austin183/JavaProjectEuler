import org.junit.Assert;
import org.junit.Test;

import java.math.BigInteger;

/**
 * Created with IntelliJ IDEA.
 * User: austin
 * Date: 7/20/12
 * Time: 10:12 PM
 * To change this template use File | Settings | File Templates.
 */
public class CombinatoricizerTest {
    @Test
    public void ShouldFind5C3Equals10()
    {
        int n = 5;
        int r = 3;

        int expected = 10;

        Combinatoricizer combinatoricizer = new Combinatoricizer();
        int result = combinatoricizer.Calculate_nCr(n, r);

        Assert.assertEquals(expected, result);
    }

    @Test
    public void ShouldFindBig5C3Equals10()
    {
        int n = 5;
        int r = 3;

        BigInteger expected = new BigInteger("10");

        Combinatoricizer combinatoricizer = new Combinatoricizer();
        BigInteger result = combinatoricizer.Calculate_Big_nCr(n, r);

        Assert.assertEquals(expected, result);
    }

    @Test
    public void ShouldFind23C10Equals1144066()
    {
        int n = 23;
        int r = 10;

        BigInteger expected = new BigInteger("1144066");

        Combinatoricizer combinatoricizer = new Combinatoricizer();
        BigInteger result = combinatoricizer.Calculate_Big_nCr(n, r);

        Assert.assertEquals(expected, result);
    }

    //Problem 53
    @Test
    public void ShouldFindCountOfValuesForFor_n_1Thru100Where_nCr_ValueIsGreaterThan1Million()
    {
        int expected = 4075;

        Combinatoricizer combinatoricizer = new Combinatoricizer();

        int result = combinatoricizer.FindCountOfValuesForFor_n_1Thru100Where_nCr_ValueIsGreaterThan1Million();

        Assert.assertEquals(expected, result);
    }
}
