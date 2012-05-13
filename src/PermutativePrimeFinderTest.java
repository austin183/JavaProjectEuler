import junit.framework.Assert;
import org.junit.Test;

/**
 * Go IntelliJ IDEA!
 * User: Austin
 * Date: 5/9/12
 * Time: 9:52 PM
 */
public class PermutativePrimeFinderTest
{
    @Test
    public void ShouldFind1487ToBePermutativePrime()
    {
        //Permutative Prime means three of the four permutations of the number are prime numbers
        PermutativePrimeFinder finder = new PermutativePrimeFinder();
        String expected = "148748178147";
        int value = 1487;

        String result = finder.IsPermutativePrimeIncreasingSeries(value);

        Assert.assertEquals(expected, result);
    }

    @Test
    public void ShouldFind1009NotPermutativePrime()
    {
        PermutativePrimeFinder finder = new PermutativePrimeFinder();
        String expected = "";
        int value = 1009;

        String result = finder.IsPermutativePrimeIncreasingSeries(value);

        Assert.assertEquals(expected, result);
    }
}
