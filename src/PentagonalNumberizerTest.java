import junit.framework.Assert;
import org.junit.Test;

/**
 * Go IntelliJ IDEA!
 * User: Austin
 * Date: 5/2/12
 * Time: 10:35 PM
 */
public class PentagonalNumberizerTest {
    @Test
    public void ShouldFindPentagonalNumberAt1()
    {
        int expected = 1;

        PentagonalNumberizer numberizer = new PentagonalNumberizer();
        int result = numberizer.GetPentagonalNumberAt(1);

        Assert.assertEquals(expected, result);
    }

    @Test
    public void ShouldFindPentagonalNumberAt2()
    {
        int expected = 5;

        PentagonalNumberizer numberizer = new PentagonalNumberizer();
        int result = numberizer.GetPentagonalNumberAt(2);

        Assert.assertEquals(expected, result);
    }

    @Test
    public void ShouldFindPentagonalNumberAt3()
    {
        int expected = 12;

        PentagonalNumberizer numberizer = new PentagonalNumberizer();
        int result = numberizer.GetPentagonalNumberAt(3);

        Assert.assertEquals(expected, result);
    }

    @Test
    public void ShouldRecognize1AsPentagonal()
    {
        boolean expected = true;

        PentagonalNumberizer numberizer = new PentagonalNumberizer();
        boolean result = numberizer.IsPentagonalNumber(1);

        Assert.assertEquals(expected, result);
    }

    @Test
    public void ShouldRecognize2AsNotPentagonal()
    {
        boolean expected = false;

        PentagonalNumberizer numberizer = new PentagonalNumberizer();
        boolean result = numberizer.IsPentagonalNumber(2);

        Assert.assertEquals(expected, result);
    }

    @Test
    public void ShouldRecognize5AsPentagonal()
    {
        boolean expected = true;

        PentagonalNumberizer numberizer = new PentagonalNumberizer();
        boolean result = numberizer.IsPentagonalNumber(5);

        Assert.assertEquals(expected, result);
    }
}
