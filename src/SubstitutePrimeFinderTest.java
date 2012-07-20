import org.junit.Assert;
import org.junit.Ignore;
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
        int expected = 6;
        int value = 13;

        SupportFiles files = new SupportFiles();
        PrimeFactorizer factorizer = new PrimeFactorizer(files.Location + "PrimesUnder1million.txt");

        SubstitutePrimeFinder finder = new SubstitutePrimeFinder(factorizer);
        int result = finder.GetHighestNumberPrimesFromSubstitution(value);

        Assert.assertEquals(expected, result);
    }

    @Test
    public void ShouldFindNumberPrimesInSubstitute121313()
    {
        int expected = 8;
        int value = 121313;

        SupportFiles files = new SupportFiles();
        PrimeFactorizer factorizer = new PrimeFactorizer(files.Location + "PrimesUnder1million.txt");

        SubstitutePrimeFinder finder = new SubstitutePrimeFinder(factorizer);
        int result = finder.GetHighestNumberPrimesFromSubstitution(value);

        Assert.assertEquals(expected, result);
    }

    @Test
    public void ShouldFindNumberPrimesInSubstitute1307()
    {
        int expected = 3;
        int value = 1307;

        SupportFiles files = new SupportFiles();
        PrimeFactorizer factorizer = new PrimeFactorizer(files.Location + "PrimesUnder1million.txt");

        SubstitutePrimeFinder finder = new SubstitutePrimeFinder(factorizer);
        int result = finder.GetHighestNumberPrimesFromSubstitution(value);

        Assert.assertEquals(expected, result);
    }

    @Test
    public void ShouldFindNumberPrimesInSubstitute56003()
    {
        int expected = 7;
        int value = 56003;

        SupportFiles files = new SupportFiles();
        PrimeFactorizer factorizer = new PrimeFactorizer(files.Location + "PrimesUnder1million.txt");

        SubstitutePrimeFinder finder = new SubstitutePrimeFinder(factorizer);
        int result = finder.GetHighestNumberPrimesFromSubstitution(value);

        Assert.assertEquals(expected, result);
    }

    @Test
    public void ShouldFindNumberPrimesInSubstitute120383()
    {
        int expected = 3;
        int value = 120383;

        SupportFiles files = new SupportFiles();
        PrimeFactorizer factorizer = new PrimeFactorizer(files.Location + "PrimesUnder1million.txt");

        SubstitutePrimeFinder finder = new SubstitutePrimeFinder(factorizer);
        int result = finder.GetHighestNumberPrimesFromSubstitution(value);

        Assert.assertEquals(expected, result);
    }

    @Test
    public void ShouldFindNumberPrimesInSubstitute2()
    {
        int expected = 1;
        int value = 2;

        SupportFiles files = new SupportFiles();
        PrimeFactorizer factorizer = new PrimeFactorizer(files.Location + "PrimesUnder1million.txt");

        SubstitutePrimeFinder finder = new SubstitutePrimeFinder(factorizer);
        int result = finder.GetHighestNumberPrimesFromSubstitution(value);

        Assert.assertEquals(expected, result);
    }

    @Test
    @Ignore("76 seconds slow")
    public void ShouldFindFirstSubstitutePrimeWithSevenPrimes()
    {
        int result = 0;
        int expected = 56003;
        SupportFiles files = new SupportFiles();
        PrimeFactorizer factorizer = new PrimeFactorizer(files.Location + "PrimesUnder1million.txt");

        SubstitutePrimeFinder finder = new SubstitutePrimeFinder(factorizer);
        for(int i = 99; i < 1000000; i++)
        {
            if(finder.GetHighestNumberPrimesFromSubstitution(i) == 7)
            {
                result = i;
                i = 1000000;
            }
        }
        Assert.assertEquals(expected, result);
    }

    @Test
    @Ignore("120 seconds slow")
    public void ShouldFindFirstSubstitutePrimeWithEightPrimes()
    {
        int result = 0;
        int expected = 121313;
        SupportFiles files = new SupportFiles();
        PrimeFactorizer factorizer = new PrimeFactorizer(files.Location + "PrimesUnder1million.txt");

        SubstitutePrimeFinder finder = new SubstitutePrimeFinder(factorizer);
        for(int i = 56003; i < 1000000; i++)
        {
            if(finder.GetHighestNumberPrimesFromSubstitution(i) == 8)
            {
                result = i;
                i = 1000000;
            }
        }
        Assert.assertEquals(expected, result);
    }
}
