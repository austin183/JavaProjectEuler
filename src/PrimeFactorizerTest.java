import junit.framework.Assert;
import org.junit.Test;

/**
 * Go IntelliJ IDEA!
 * User: Austin
 * Date: 4/10/12
 * Time: 6:58 PM
 */
public class PrimeFactorizerTest {
    @Test
    public void ShoulRecognize3797AsPrimeAndTruncatablyPrimeBothDirections() {
        int candidate = 3797;
        boolean expected = true;

        PrimeFactorizer factorizer = new PrimeFactorizer();
        boolean result = factorizer.IsPrimeAndTruncatablyPrimeBothDirections(candidate);

        Assert.assertEquals(expected, result);
    }

    @Test
    public void ShoulRecognize10AsNotPrimeAndTruncatablyPrimeBothDirections() {
        int candidate = 10;
        boolean expected = false;

        PrimeFactorizer factorizer = new PrimeFactorizer();
        boolean result = factorizer.IsPrimeAndTruncatablyPrimeBothDirections(candidate);

        Assert.assertEquals(expected, result);
    }

    @Test
    public void ShouldFind1999993ToBePrime()
    {
        int candidate = 1999993;

        boolean expected = true;

        PrimeFactorizer factorizer = new PrimeFactorizer();
        boolean result = factorizer.IsPrime(candidate, false);

        Assert.assertEquals(expected, result);
    }

}
