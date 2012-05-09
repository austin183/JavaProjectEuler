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
        List<Fraction> expected = new ArrayList<Fraction>();
        expected.add(new Fraction(16, 64));
        expected.add(new Fraction(26, 65));
        expected.add(new Fraction(19, 95));
        expected.add(new Fraction(49, 98));

        UnorthodoxFractionFinder finder = new UnorthodoxFractionFinder();
        List<Fraction> result = finder.GetUnorthodoxFractions();

        Assert.assertEquals(expected.get(0).Numerator, result.get(0).Numerator);
        Assert.assertEquals(expected.get(1).Numerator, result.get(1).Numerator);
        Assert.assertEquals(expected.get(2).Numerator, result.get(2).Numerator);
        Assert.assertEquals(expected.get(3).Numerator, result.get(3).Numerator);

        Assert.assertEquals(expected.get(0).Denominator, result.get(0).Denominator);
        Assert.assertEquals(expected.get(1).Denominator, result.get(1).Denominator);
        Assert.assertEquals(expected.get(2).Denominator, result.get(2).Denominator);
        Assert.assertEquals(expected.get(3).Denominator, result.get(3).Denominator);
    }
}
