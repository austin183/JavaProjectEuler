package FractionalMath;

import junit.framework.Assert;
import org.junit.Test;

import java.math.BigInteger;

/**
 * Created with IntelliJ IDEA.
 * User: austin
 * Date: 8/24/12
 * Time: 8:04 PM
 * To change this template use File | Settings | File Templates.
 */
public class BigFractionTest {
    @Test
    public void ShouldAdd2To1Over2()
    {
        BigFraction givenBigFraction = new BigFraction(new BigInteger("1"),new BigInteger("2"));
        int givenInteger = 2;

        BigFraction expected = new BigFraction(new BigInteger("5"), new BigInteger("2"));

        BigFraction result = givenBigFraction.Add(givenInteger);

        Assert.assertEquals(0, expected.compareTo(result));
    }

    @Test
    public void ShouldAdd2To1Over3()
    {
        BigFraction givenBigFraction = new BigFraction(new BigInteger("1"),new BigInteger("3"));
        int givenInteger = 2;

        BigFraction expected = new BigFraction(new BigInteger("7"), new BigInteger("3"));

        BigFraction result = givenBigFraction.Add(givenInteger);

        Assert.assertEquals(0, expected.compareTo(result));
    }

    @Test
    public void ShouldFind1Over_5Over2()
    {
        BigFraction given = new BigFraction(new BigInteger("5"), new BigInteger("2"));
        BigFraction expected = new BigFraction(new BigInteger("10"),new BigInteger("25")).Reduced();

        BigFraction result = new BigFraction(new BigInteger("1"), given).Reduced();

        Assert.assertEquals(0, expected.compareTo(result));
    }

    @Test
    public void ShouldReduce2Over4To1Over2()
    {
        BigFraction given = new BigFraction(new BigInteger("2"), new BigInteger("4"));

        BigFraction expected = new BigFraction(new BigInteger("1"), new BigInteger("2"));

        BigFraction result = new BigFraction(given).Reduced();

        Assert.assertEquals(0, result.compareTo(expected));
    }

    @Test
    public void ShouldFind3Over2ToBeGreaterThan1Over2()
    {
        BigFraction given = new BigFraction(new BigInteger("3"), new BigInteger("2"));

        BigFraction expected = new BigFraction(new BigInteger("1"), new BigInteger("2"));

        BigFraction result = new BigFraction(given).Reduced();

        Assert.assertEquals(1, result.compareTo(expected));
    }

    @Test
    public void ShouldFind1Over2ToBeGreaterThan3Over2()
    {
        BigFraction given = new BigFraction(new BigInteger("1"), new BigInteger("2"));

        BigFraction expected = new BigFraction(new BigInteger("3"), new BigInteger("2"));

        BigFraction result = new BigFraction(given).Reduced();

        Assert.assertEquals(-1, result.compareTo(expected));
    }

    @Test
    public void ShouldFindGreatestCommonFactorOf2Over4ToBe2()
    {
        BigFraction given = new BigFraction(new BigInteger("2"), new BigInteger("4"));

        BigInteger expected = new BigInteger("2");

        BigInteger result = new BigFraction(given).GreatestCommonFactor();

        Assert.assertEquals(0, expected.compareTo(result));
    }
}
