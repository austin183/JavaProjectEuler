import junit.framework.Assert;
import org.junit.Ignore;
import org.junit.Test;

/**
 * Go IntelliJ IDEA!
 * User: Austin
 * Date: 3/29/12
 * Time: 7:58 AM
 */
public class CircularPrimeFinderTest {
    @Test
    public void ShouldRecognize197AsCircularPrime() {
        int candidate = 197;
        boolean expected = true;

        PrimeFactorizer factorizer = new PrimeFactorizer();
        CircularPrimeFinder finder = new CircularPrimeFinder(factorizer);
        boolean result = finder.IsCircularPrime(candidate);

        Assert.assertEquals(expected, result);
    }

    @Test
    public void ShouldRecognize13AsCircularPrime() {
        int candidate = 13;
        boolean expected = true;

        PrimeFactorizer factorizer = new PrimeFactorizer();
        CircularPrimeFinder finder = new CircularPrimeFinder(factorizer);
        boolean result = finder.IsCircularPrime(candidate);

        Assert.assertEquals(expected, result);
    }

    @Test
    public void ShouldRecognize2AsCircularPrime() {
        int candidate = 11;
        boolean expected = true;

        PrimeFactorizer factorizer = new PrimeFactorizer();
        CircularPrimeFinder finder = new CircularPrimeFinder(factorizer);
        boolean result = finder.IsCircularPrime(candidate);

        Assert.assertEquals(expected, result);
    }

    @Test
    public void ShouldRecognize29AsNotACircularPrime() {
        int candidate = 29;
        boolean expected = false;

        PrimeFactorizer factorizer = new PrimeFactorizer();
        CircularPrimeFinder finder = new CircularPrimeFinder(factorizer);
        boolean result = finder.IsCircularPrime(candidate);

        Assert.assertEquals(expected, result);
    }

    @Test
    public void ShouldRecognize127AsNotCircularPrime() {
        int candidate = 127;
        boolean expected = false;

        PrimeFactorizer factorizer = new PrimeFactorizer();
        CircularPrimeFinder finder = new CircularPrimeFinder(factorizer);
        boolean result = finder.IsCircularPrime(candidate);

        Assert.assertEquals(expected, result);
    }

    @Test
    public void ShouldRecognize701AsNotCircularPrime() {
        int candidate = 701;
        boolean expected = false;

        PrimeFactorizer factorizer = new PrimeFactorizer();
        CircularPrimeFinder finder = new CircularPrimeFinder(factorizer);
        boolean result = finder.IsCircularPrime(candidate);

        Assert.assertEquals(expected, result);
    }

    //Problem 35
    @Test
    @Ignore("Slow test.  About 2 or 3 mins")
    public void ShouldGetCountOfAllCircularPrimesBelow1million() {
        int expected = 55;

        PrimeFactorizer factorizer = new PrimeFactorizer("C:\\Temp\\PrimeWork\\PrimesUnder1million.txt");
        CircularPrimeFinder finder = new CircularPrimeFinder(factorizer);

        int result = finder.GetCountOfAllCircularPrimesInKnownPrimes();

        Assert.assertEquals(expected, result);
    }

}
