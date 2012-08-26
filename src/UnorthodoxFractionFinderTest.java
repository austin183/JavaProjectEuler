import FractionalMath.DoubleFraction;
import junit.framework.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * Go IntelliJ IDEA!
 * User: Austin
 * Date: 3/28/12
 * Time: 8:08 AM
 */
public class UnorthodoxFractionFinderTest {
    @Test
    public void ShouldFind49Over98AsUnorthodox() {
        double numerator = 49;
        double denominator = 98;

        boolean expected = true;

        UnorthodoxFractionFinder finder = new UnorthodoxFractionFinder();
        boolean result = finder.IsUnorthodoxFraction(numerator, denominator);

        Assert.assertEquals(expected, result);
    }

    @Test
    public void ShouldFind50Over90AsUnorthodox() {
        double numerator = 50;
        double denominator = 90;

        boolean expected = false;

        UnorthodoxFractionFinder finder = new UnorthodoxFractionFinder();
        boolean result = finder.IsUnorthodoxFraction(numerator, denominator);

        Assert.assertEquals(expected, result);
    }

    //Problem 33
    @Test
    public void ShouldFindListOfUnorthodoxFractionsBetween10Over11And98Over99() {
        List<DoubleFraction> expected = new ArrayList<DoubleFraction>();
        expected.add(new DoubleFraction(16.0, 64.0));
        expected.add(new DoubleFraction(26.0, 65.0));
        expected.add(new DoubleFraction(19.0, 95.0));
        expected.add(new DoubleFraction(49.0, 98.0));

        UnorthodoxFractionFinder finder = new UnorthodoxFractionFinder();
        List<DoubleFraction> result = finder.GetUnorthodoxFractions();

        Assert.assertEquals(expected.get(0).getNumerator(), result.get(0).getNumerator());
        Assert.assertEquals(expected.get(1).getNumerator(), result.get(1).getNumerator());
        Assert.assertEquals(expected.get(2).getNumerator(), result.get(2).getNumerator());
        Assert.assertEquals(expected.get(3).getNumerator(), result.get(3).getNumerator());

        Assert.assertEquals(expected.get(0).getDenominator(), result.get(0).getDenominator());
        Assert.assertEquals(expected.get(1).getDenominator(), result.get(1).getDenominator());
        Assert.assertEquals(expected.get(2).getDenominator(), result.get(2).getDenominator());
        Assert.assertEquals(expected.get(3).getDenominator(), result.get(3).getDenominator());
    }
}
