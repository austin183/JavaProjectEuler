package FractionalMath;

import junit.framework.Assert;
import org.junit.Test;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: austin
 * Date: 8/25/12
 * Time: 11:09 AM
 * To change this template use File | Settings | File Templates.
 */
public class BigFactorizerTest {
    @Test
    public void ShouldGetFactorsOf4()
    {
        BigInteger given = new BigInteger("4");
        List<BigInteger> expected = new ArrayList<BigInteger>();
        expected.add(new BigInteger("1"));
        expected.add(new BigInteger("2"));

        BigFactorizer factorizer = new BigFactorizer();
        List<BigInteger> result = factorizer.GetFactorsOf(given);

        Assert.assertEquals(expected.get(0), result.get(0));
        Assert.assertEquals(expected.get(1), result.get(1));
    }

    @Test
    public void ShouldGetFactorsOf1()
    {
        BigInteger given = new BigInteger("1");
        List<BigInteger> expected = new ArrayList<BigInteger>();
        expected.add(new BigInteger("1"));

        BigFactorizer factorizer = new BigFactorizer();
        List<BigInteger> result = factorizer.GetFactorsOf(given);

        Assert.assertEquals(expected.get(0), result.get(0));
    }

    @Test
    public void ShouldGetFactorsOf2()
    {
        BigInteger given = new BigInteger("2");
        List<BigInteger> expected = new ArrayList<BigInteger>();
        expected.add(new BigInteger("1"));
        expected.add(new BigInteger("2"));

        BigFactorizer factorizer = new BigFactorizer();
        List<BigInteger> result = factorizer.GetFactorsOf(given);

        Assert.assertEquals(expected.get(0), result.get(0));
        Assert.assertEquals(expected.get(1), result.get(1));
    }

    @Test
    public void ShouldGetFactorsOf3()
    {
        BigInteger given = new BigInteger("3");
        List<BigInteger> expected = new ArrayList<BigInteger>();
        expected.add(new BigInteger("1"));
        expected.add(new BigInteger("3"));

        BigFactorizer factorizer = new BigFactorizer();
        List<BigInteger> result = factorizer.GetFactorsOf(given);

        Assert.assertEquals(expected.get(0), result.get(0));
        Assert.assertEquals(expected.get(1), result.get(1));
    }


    @Test
    public void ShouldGetFactorsOf18()
    {
        BigInteger given = new BigInteger("18");
        List<BigInteger> expected = new ArrayList<BigInteger>();
        expected.add(new BigInteger("1"));
        expected.add(new BigInteger("2"));
        expected.add(new BigInteger("3"));
        expected.add(new BigInteger("6"));
        expected.add(new BigInteger("9"));

        BigFactorizer factorizer = new BigFactorizer();
        List<BigInteger> result = factorizer.GetFactorsOf(given);

        Assert.assertEquals(expected.get(0), result.get(0));
        Assert.assertEquals(expected.get(1), result.get(1));
        Assert.assertEquals(expected.get(2), result.get(2));
        Assert.assertEquals(expected.get(3), result.get(3));
        Assert.assertEquals(expected.get(4), result.get(4));
    }
}

