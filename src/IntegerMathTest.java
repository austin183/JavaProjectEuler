import junit.framework.Assert;
import org.junit.Test;

/**
 * Go IntelliJ IDEA!
 * User: Austin
 * Date: 3/18/12
 * Time: 3:29 PM
 */
public class IntegerMathTest {
    @Test
    public void ShouldGet1ToThe0Power()
    {
        int a = 1;
        int b = 0;
        int expected = 1;

        IntegerMath math = new IntegerMath();
        int result = math.Pow(a, b);

        Assert.assertEquals(expected, result);
    }

    @Test
    public void ShouldGet2ToThe3Power()
    {
        int a = 2;
        int b = 3;
        int expected = 8;

        IntegerMath math = new IntegerMath();
        int result = math.Pow(a, b);

        Assert.assertEquals(expected, result);
    }

    @Test
    public void ShouldGet8ToThe4Power()
    {
        int a = 8;
        int b = 4;
        int expected = 4096;

        IntegerMath math = new IntegerMath();
        int result = math.Pow(a, b);

        Assert.assertEquals(expected, result);
    }
}
