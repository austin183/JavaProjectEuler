import junit.framework.Assert;
import org.junit.Test;

/**
 * Go IntelliJ IDEA!
 * User: Austin
 * Date: 5/8/12
 * Time: 6:21 PM
 */
public class HexagonalNumberizerTest {
    @Test
    public void ShouldFindHexagonalNumberAt1()
    {
        int expected = 1;

        HexagonalNumberizer numberizer = new HexagonalNumberizer();
        int result = numberizer.GetHexagonalNumberAt(1);

        Assert.assertEquals(expected, result);
    }

    @Test
    public void ShouldFindHexagonalNumberAt2()
    {
        int expected = 6;

        HexagonalNumberizer numberizer = new HexagonalNumberizer();
        int result = numberizer.GetHexagonalNumberAt(2);

        Assert.assertEquals(expected, result);
    }

    @Test
    public void ShouldFindHexagonalNumberAt3()
    {
        int expected = 15;

        HexagonalNumberizer numberizer = new HexagonalNumberizer();
        int result = numberizer.GetHexagonalNumberAt(3);

        Assert.assertEquals(expected, result);
    }

    @Test
    public void ShouldRecognize1AsHexagonal()
    {
        boolean expected = true;

        HexagonalNumberizer numberizer = new HexagonalNumberizer();
        boolean result = numberizer.IsHexagonalNumber(1);

        Assert.assertEquals(expected, result);
    }

    @Test
    public void ShouldRecognize2AsNotHexagonal()
    {
        boolean expected = false;

        HexagonalNumberizer numberizer = new HexagonalNumberizer();
        boolean result = numberizer.IsHexagonalNumber(2);

        Assert.assertEquals(expected, result);
    }

    @Test
    public void ShouldRecognize6AsHexagonal()
    {
        boolean expected = true;

        HexagonalNumberizer numberizer = new HexagonalNumberizer();
        boolean result = numberizer.IsHexagonalNumber(6);

        Assert.assertEquals(expected, result);
    }

    @Test
    public void ShouldRecognize45AsHexagonal()
    {
        boolean expected = true;

        HexagonalNumberizer numberizer = new HexagonalNumberizer();
        boolean result = numberizer.IsHexagonalNumber(45);

        Assert.assertEquals(expected, result);
    }
}
