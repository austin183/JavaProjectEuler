import junit.framework.Assert;
import org.junit.Ignore;
import org.junit.Test;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Go IntelliJ IDEA!
 * User: Austin
 * Date: 3/18/12
 * Time: 2:21 PM
 */
public class SpiralDiagonalHelperTest {
    @Test
    public void ShouldGetRatioOfPrimesInDiagonalsAtLevel1()
    {
        int level = 1;

        double expected = .6;

        SpiralDiagonalHelper helper = new SpiralDiagonalHelper();
        double result = helper.GetDiagonalPrimeRatiosAtLevel(level);

        Assert.assertEquals(expected, result);
    }

    @Test
    public void ShouldGetRatioOfPrimesInDiagonalsAtLevel2()
    {
        int level = 2;

        double expected = 0.5555555555555556;
        SpiralDiagonalHelper helper = new SpiralDiagonalHelper();
        double result = helper.GetDiagonalPrimeRatiosAtLevel(level);

        Assert.assertEquals(expected,result);
    }


    @Test
    public void ShouldGetRatioOfPrimesInDiagonalsAtLevel3()
    {
        int level = 3;

        double expected = 0.6153846153846154;
        SpiralDiagonalHelper helper = new SpiralDiagonalHelper();
        double result = helper.GetDiagonalPrimeRatiosAtLevel(level);

        Assert.assertEquals(expected,result);
    }

    //Problem 58
    @Test
    @Ignore("This test takes about 20 seconds to run")
    public void ShouldFindSideLengthOfLevelWhereRatioOfPrimesInDiagonalsFallsBelow10Percent()
    {
        double threshold = .1;

        int expected = 26241;

        SpiralDiagonalHelper helper = new SpiralDiagonalHelper();

        int result = helper.FindSideLengthOfLevelWhereRatioOfPrimesInDiagonalsFallsBelow10Percent(threshold);

        Assert.assertEquals(expected, result);
    }


    @Test
    public void ShouldGetCountOfNumbersAlongDiagonalAtLevel1()
    {
        int level = 1;

        int expected = 5;

        SpiralDiagonalHelper helper = new SpiralDiagonalHelper();
        int result = helper.GetCountOfNumbersAlongDiagonalAtLevel(level);

        Assert.assertEquals(expected, result);
    }

    @Test
    public void ShouldGetCountOfNumbersAlongDiagonalAtLevel2()
    {
        int level = 2;

        int expected = 9;

        SpiralDiagonalHelper helper = new SpiralDiagonalHelper();
        int result = helper.GetCountOfNumbersAlongDiagonalAtLevel(level);

        Assert.assertEquals(expected, result);
    }

    @Test
    public void ShouldGetCountOfNumbersAlongDiagonalAtLevel3()
    {
        int level = 3;

        int expected = 13;

        SpiralDiagonalHelper helper = new SpiralDiagonalHelper();
        int result = helper.GetCountOfNumbersAlongDiagonalAtLevel(level);

        Assert.assertEquals(expected, result);
    }

    @Test
    public void ShouldGetSideLengthAtLevel1()
    {
        int level = 1;
        int expected = 3;

        SpiralDiagonalHelper helper = new SpiralDiagonalHelper();
        int result = helper.GetSideLengthAtLevel(level);

        Assert.assertEquals(expected, result);
    }

    @Test
    public void ShouldGetListOfDiagonalValuesAtLevel1()
    {
        int level = 1;
        List<Integer> expected = new ArrayList<Integer>();
        expected.add(9);
        expected.add(7);
        expected.add(5);
        expected.add(3);

        SpiralDiagonalHelper helper = new SpiralDiagonalHelper();
        List<Integer>result = helper.GetDiagonalsAtLevel(level);

        Assert.assertEquals(expected.get(0), result.get(0));
        Assert.assertEquals(expected.get(1), result.get(1));
        Assert.assertEquals(expected.get(2), result.get(2));
        Assert.assertEquals(expected.get(3), result.get(3));
    }

    @Test
    public void ShouldGetListOfDiagonalValuesAtLevel2()
    {
        int level = 2;
        List<Integer> expected = new ArrayList<Integer>();
        expected.add(25);
        expected.add(21);
        expected.add(17);
        expected.add(13);

        SpiralDiagonalHelper helper = new SpiralDiagonalHelper();
        List<Integer>result = helper.GetDiagonalsAtLevel(level);

        Assert.assertEquals(expected.get(0), result.get(0));
        Assert.assertEquals(expected.get(1), result.get(1));
        Assert.assertEquals(expected.get(2), result.get(2));
        Assert.assertEquals(expected.get(3), result.get(3));
    }


    @Test
    public void ShouldFindSumOfDiagonalPointsAtLevel1() {
        int level = 1;
        int expected = 4;

        SpiralDiagonalHelper helper = new SpiralDiagonalHelper();
        int result = helper.GetSumDiagonalsPointsAtLevel(level);

        Assert.assertEquals(expected, result);
    }

    @Test
    public void ShouldFindSumOfDiagonalPointsAtLevel3() {
        int level = 3;
        int expected = 24;

        SpiralDiagonalHelper helper = new SpiralDiagonalHelper();
        int result = helper.GetSumDiagonalsPointsAtLevel(level);

        Assert.assertEquals(expected, result);
    }

    @Test
    public void ShouldFindSumOfFullDiagonalsToLevel3() {
        int level = 3;
        int expected = 25;

        SpiralDiagonalHelper helper = new SpiralDiagonalHelper();
        int result = helper.GetSumOffullDiagonalsToLevel(level);

        Assert.assertEquals(expected, result);
    }

    @Test
    public void ShouldFindSumOfFullDiagonalsToLevel5() {
        int level = 5;
        int expected = 101;

        SpiralDiagonalHelper helper = new SpiralDiagonalHelper();
        int result = helper.GetSumOffullDiagonalsToLevel(level);

        Assert.assertEquals(expected, result);
    }

    //Problem 28
    @Test
    public void ShouldFindSumOfFullDiagonalsToLevel1001() {
        int level = 1001;
        int expected = 669171001;

        SpiralDiagonalHelper helper = new SpiralDiagonalHelper();
        int result = helper.GetSumOffullDiagonalsToLevel(level);

        Assert.assertEquals(expected, result);
    }
}
