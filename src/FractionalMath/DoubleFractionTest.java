package FractionalMath;

import junit.framework.Assert;
import org.junit.Test;

/**
 * Created with IntelliJ IDEA.
 * User: austin
 * Date: 8/23/12
 * Time: 7:19 PM
 * To change this template use File | Settings | File Templates.
 */
public class DoubleFractionTest {

    @Test
    public void ShouldAdd2To1Over2()
    {
        DoubleFraction givenFraction = new DoubleFraction(1.0,2.0);
        int givenInteger = 2;

        DoubleFraction expected = new DoubleFraction(5.0, 2.0);

        DoubleFraction result = givenFraction.Add(givenInteger);

        Assert.assertEquals(0, expected.compareTo(result));
    }

    @Test
    public void ShouldAdd2To1Over3()
    {
        DoubleFraction givenFraction = new DoubleFraction(1.0,3.0);
        int givenInteger = 2;

        DoubleFraction expected = new DoubleFraction(7.0, 3.0);

        DoubleFraction result = givenFraction.Add(givenInteger);

        Assert.assertEquals(0, expected.compareTo(result));
    }

    @Test
    public void ShouldFind1Over_5Over2()
    {
        DoubleFraction given = new DoubleFraction(5.0, 2.0);
        DoubleFraction expected = new DoubleFraction(10.0,25.0).Reduced();

        DoubleFraction result = new DoubleFraction(1, given).Reduced();

        Assert.assertEquals(0, expected.compareTo(result));
    }

    @Test
    public void ShouldNormalize2point1Over2To21Over20()
    {
        DoubleFraction given = new DoubleFraction(2.1, 2.0);

        DoubleFraction expected = new DoubleFraction(21.0, 20.0);

        Assert.assertEquals(0, given.compareTo(expected));
    }


    @Test
    public void ShouldReduce2Over4To1Over2()
    {
        DoubleFraction given = new DoubleFraction(2.0, 4.0);

        DoubleFraction expected = new DoubleFraction(1.0, 2.0);

        DoubleFraction result = new DoubleFraction(given).Reduced();

        Assert.assertEquals(0, result.compareTo(expected));
    }

    @Test
    public void ShouldFind3Over2ToBeGreaterThan1Over2()
    {
        DoubleFraction given = new DoubleFraction(3.0, 2.0);

        DoubleFraction expected = new DoubleFraction(1.0, 2.0);

        DoubleFraction result = new DoubleFraction(given).Reduced();

        Assert.assertEquals(1, result.compareTo(expected));
    }

    @Test
    public void ShouldFind1Over2ToBeGreaterThan3Over2()
    {
        DoubleFraction given = new DoubleFraction(1.0, 2.0);

        DoubleFraction expected = new DoubleFraction(3.0, 2.0);

        DoubleFraction result = new DoubleFraction(given).Reduced();

        Assert.assertEquals(-1, result.compareTo(expected));
    }

    @Test
    public void ShouldFindGreatestCommonFactorOf2Over4ToBe2()
    {
        DoubleFraction given = new DoubleFraction(2.0, 4.0);

        int expected = 2;

        int result = new DoubleFraction(given).GreatestCommonFactor();

        Assert.assertEquals(expected, result);
    }
}
