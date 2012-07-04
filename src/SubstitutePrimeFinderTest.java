import org.junit.Assert;
import org.junit.Test;

/**
 * Go IntelliJ IDEA!
 * User: Austin
 * Date: 5/15/12
 * Time: 6:15 PM
 */
public class SubstitutePrimeFinderTest {
    @Test
    public void ShouldFindNumberPrimesInSubstitute13()
    {
        int expected = 0;
        int value = 13;

        SubstitutePrimeFinder finder = new SubstitutePrimeFinder();
        int result = finder.GetHighestNumberPrimesFromSubstitution(value);

        Assert.assertEquals(expected, result);
    }

    @Test
    public void ShouldFindNumberPrimesInSubstitute56003()
    {
        int expected = 0;
        int value = 56003;

        SubstitutePrimeFinder finder = new SubstitutePrimeFinder();
        int result = finder.GetHighestNumberPrimesFromSubstitution(value);

        Assert.assertEquals(expected, result);
    }

    @Test
    public void ShouldFindNumberPrimesInSubstitute2()
    {
        int expected = 1;
        int value = 2;

        SubstitutePrimeFinder finder = new SubstitutePrimeFinder();
        int result = finder.GetHighestNumberPrimesFromSubstitution(value);

        Assert.assertEquals(expected, result);
    }
}
