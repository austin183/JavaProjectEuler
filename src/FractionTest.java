import junit.framework.Assert;
import org.junit.Test;

/**
 * Created with IntelliJ IDEA.
 * User: austin
 * Date: 8/23/12
 * Time: 7:19 PM
 * To change this template use File | Settings | File Templates.
 */
public class FractionTest {

    @Test
    public void ShouldAdd2To1Over2()
    {
        Fraction givenFraction = new Fraction(1,2);
        int givenInteger = 2;

        Fraction expected = new Fraction(5, 2);

        Fraction result = givenFraction.Add(givenInteger);

        Assert.assertEquals(0, expected.compareTo(result));
    }

    @Test
    public void ShouldAdd2To1Over3()
    {
        Fraction givenFraction = new Fraction(1,3);
        int givenInteger = 2;

        Fraction expected = new Fraction(7, 3);

        Fraction result = givenFraction.Add(givenInteger);

        Assert.assertEquals(0, expected.compareTo(result));
    }

    @Test
    public void ShouldFind1Over_5Over2()
    {
        Fraction given = new Fraction(5, 2);
        Fraction expected = new Fraction(10,25).Reduced();

        Fraction result = new Fraction(1, given).Reduced();

        Assert.assertEquals(0, expected.compareTo(result));
    }

    @Test
    public void ShouldNormalize2point1Over2To21Over20()
    {
        Fraction given = new Fraction(2.1, 2);

        Fraction expected = new Fraction(21, 20);

        Assert.assertEquals(0, given.compareTo(expected));
    }


    @Test
    public void ShouldReduce2Over4To1Over2()
    {
        Fraction given = new Fraction(2, 4);

        Fraction expected = new Fraction(1, 2);

        Fraction result = new Fraction(given).Reduced();

        Assert.assertEquals(0, result.compareTo(expected));
    }

    @Test
    public void ShouldFind3Over2ToBeGreaterThan1Over2()
    {
        Fraction given = new Fraction(3, 2);

        Fraction expected = new Fraction(1, 2);

        Fraction result = new Fraction(given).Reduced();

        Assert.assertEquals(1, result.compareTo(expected));
    }

    @Test
    public void ShouldFind1Over2ToBeGreaterThan3Over2()
    {
        Fraction given = new Fraction(1, 2);

        Fraction expected = new Fraction(3, 2);

        Fraction result = new Fraction(given).Reduced();

        Assert.assertEquals(-1, result.compareTo(expected));
    }

    @Test
    public void ShouldFindGreatestCommonFactorOf2Over4ToBe2()
    {
        Fraction given = new Fraction(2, 4);

        int expected = 2;

        int result = new Fraction(given).GreatestCommonFactor();

        Assert.assertEquals(expected, result);
    }
}
