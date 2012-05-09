import junit.framework.Assert;
import org.junit.Test;

/**
 * Go IntelliJ IDEA!
 * User: Austin
 * Date: 2/8/12
 * Time: 12:48 PM
 */
public class FactorizerTest {

    @Test
    public void ShouldGetNumberOfFactorsOf28() {
        int numberToTest = 28;
        Factorizer factorizer = new Factorizer();

        int result = factorizer.GetNumberFactorsOf(numberToTest);

        Assert.assertEquals(6, result);
    }

    @Test
    public void ShouldGetNumberOfFactorsOf441() {
        int numberToTest = 441;
        Factorizer factorizer = new Factorizer();

        int result = factorizer.GetNumberFactorsOf(numberToTest);

        Assert.assertEquals(9, result);
    }

    @Test
    public void ShouldGetNumberOfFactorsOf360() {
        int numberToTest = 360;
        Factorizer factorizer = new Factorizer();

        int result = factorizer.GetNumberFactorsOf(numberToTest);

        Assert.assertEquals(24, result);
    }

    @Test
    public void ShouldGetNumberPrimeFactorsOf14()
    {
        int numberToTest = 14;
        Factorizer factorizer = new Factorizer();

        int result = factorizer.GetNumberPrimeFactorsOf(numberToTest);

        Assert.assertEquals(2, result);
    }

    @Test
    public void ShouldGetNumberPrimeFactorsOf644()
    {
        int numberToTest = 644;
        Factorizer factorizer = new Factorizer();

        int result = factorizer.GetNumberPrimeFactorsOf(numberToTest);

        Assert.assertEquals(3, result);
    }

}
