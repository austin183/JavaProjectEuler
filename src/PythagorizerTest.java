import junit.framework.Assert;
import org.junit.Test;

/**
 * Go IntelliJ IDEA!
 * User: Austin
 * Date: 2/4/12
 * Time: 2:23 PM
 */
public class PythagorizerTest {
    @Test
    public void ShouldGetTrueFor345() {
        int a = 3;
        int b = 4;
        int c = 5;

        Pythagorizer pythagorizer = new Pythagorizer();
        Assert.assertTrue(pythagorizer.IsTriplet(a, b, c));
    }

    @Test
    public void ShouldGetFalseFor234() {
        int a = 2;
        int b = 3;
        int c = 4;

        Pythagorizer pythagorizer = new Pythagorizer();
        Assert.assertFalse(pythagorizer.IsTriplet(a, b, c));
    }

    @Test
    public void ShouldGetCountOf3ForPythagoreanTripletsThatAddTo120()
    {
        int value = 120;
        int expected = 3;

        Pythagorizer pythagorizer = new Pythagorizer();
        int result = pythagorizer.GetCountOfPythagoreanTripletsThatSumsTo(value);

        Assert.assertEquals(expected, result);
    }
}
