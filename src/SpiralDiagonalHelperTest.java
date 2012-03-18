import junit.framework.Assert;
import org.junit.Test;

/**
 * Go IntelliJ IDEA!
 * User: Austin
 * Date: 3/18/12
 * Time: 2:21 PM
 */
public class SpiralDiagonalHelperTest {
    @Test
    public void ShouldFindSumOfDiagonalPointsAtLevel1()
    {
        int level = 1;
        int expected = 4;

        SpiralDiagonalHelper helper = new SpiralDiagonalHelper();
        int result = helper.GetSumDiagonalsPointsAtLevel(level);

        Assert.assertEquals(expected, result);
    }

    @Test
    public void ShouldFindSumOfDiagonalPointsAtLevel3()
    {
        int level = 3;
        int expected = 24;

        SpiralDiagonalHelper helper = new SpiralDiagonalHelper();
        int result = helper.GetSumDiagonalsPointsAtLevel(level);

        Assert.assertEquals(expected, result);
    }

    @Test
    public void ShouldFindSumOfFullDiagonalsToLevel3()
    {
        int level = 3;
        int expected = 28;

        SpiralDiagonalHelper helper = new SpiralDiagonalHelper();
        int result = helper.GetSumOffullDiagonalsToLevel(level);

        Assert.assertEquals(expected, result);
    }

    @Test
    public void ShouldFindSumOfFullDiagonalsToLevel5()
    {
        int level = 5;
        int expected = 101;

        SpiralDiagonalHelper helper = new SpiralDiagonalHelper();
        int result = helper.GetSumOffullDiagonalsToLevel(level);

        Assert.assertEquals(expected, result);
    }

    @Test
    public void ShouldFindSumOfFullDiagonalsToLevel1001()
    {
        int level = 1001;
        int expected = 669171001;

        SpiralDiagonalHelper helper = new SpiralDiagonalHelper();
        int result = helper.GetSumOffullDiagonalsToLevel(level);

        Assert.assertEquals(expected, result);
    }
}
