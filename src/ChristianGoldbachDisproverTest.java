import org.junit.Assert;
import org.junit.Test;

/**
 * Go IntelliJ IDEA!
 * User: Austin
 * Date: 5/8/12
 * Time: 8:02 PM
 */
public class ChristianGoldbachDisproverTest {
    @Test
    public void ShouldRecognize3IsNotOddComposite()
    {
        boolean expected = false;
        int value = 3;

        ChristianGoldbachDisprover disprover = new ChristianGoldbachDisprover();
        boolean result = disprover.IsOddComposite(value);

        Assert.assertEquals(expected, result);
    }

    @Test
    public void ShouldRecognize5778IsNotComposite()
    {
        boolean expected = false;
        int value = 5778;

        ChristianGoldbachDisprover disprover = new ChristianGoldbachDisprover();
        boolean result = disprover.IsOddComposite(value);

        Assert.assertEquals(expected, result);
    }

    @Test
    public void ShouldRecognize7IsNotOddComposite()
    {
        boolean expected = false;
        int value = 7;

        ChristianGoldbachDisprover disprover = new ChristianGoldbachDisprover();
        boolean result = disprover.IsOddComposite(value);

        Assert.assertEquals(expected, result);
    }

    @Test
    public void ShouldRecognize9IsNotComposite()
    {
        boolean expected = true;
        int value = 9;

        ChristianGoldbachDisprover disprover = new ChristianGoldbachDisprover();
        boolean result = disprover.IsOddComposite(value);

        Assert.assertEquals(expected, result);
    }

    @Test
    public void ShouldFind2IsTwiceASquare()
    {
        boolean expected = true;
        int value = 2;

        ChristianGoldbachDisprover disprover = new ChristianGoldbachDisprover();
        boolean result = disprover.IsTwiceASquare(value);

        Assert.assertEquals(expected, result);
    }

    @Test
    public void ShouldFind4IsNotTwiceASquare()
    {
        boolean expected = false;
        int value = 4;

        ChristianGoldbachDisprover disprover = new ChristianGoldbachDisprover();
        boolean result = disprover.IsTwiceASquare(value);

        Assert.assertEquals(expected, result);
    }

    @Test
    public void ShouldFind8IsTwiceASquare()
    {
        boolean expected = true;
        int value = 8;

        ChristianGoldbachDisprover disprover = new ChristianGoldbachDisprover();
        boolean result = disprover.IsTwiceASquare(value);

        Assert.assertEquals(expected, result);
    }

    @Test
    public void ShouldFind9CanBeWrittenAsTheSumOfAPrimeAndTwiceASquare()
    {
        boolean expected = true;
        int value = 9;

        ChristianGoldbachDisprover disprover = new ChristianGoldbachDisprover();
        boolean result = disprover.CanBeWrittenAsTheSumOfAPrimeAndTwiceASquare(value);

        Assert.assertEquals(expected, result);
    }

    @Test
    public void ShouldFind15CanBeWrittenAsTheSumOfAPrimeAndTwiceASquare()
    {
        boolean expected = true;
        int value = 15;

        ChristianGoldbachDisprover disprover = new ChristianGoldbachDisprover();
        boolean result = disprover.CanBeWrittenAsTheSumOfAPrimeAndTwiceASquare(value);

        Assert.assertEquals(expected, result);
    }

    @Test
    public void ShouldFind33CanBeWrittenAsTheSumOfAPrimeAndTwiceASquare()
    {
        boolean expected = true;
        int value = 33;

        ChristianGoldbachDisprover disprover = new ChristianGoldbachDisprover();
        boolean result = disprover.CanBeWrittenAsTheSumOfAPrimeAndTwiceASquare(value);

        Assert.assertEquals(expected, result);
    }

    @Test
    public void ShouldFind16CanNotBeWrittenAsTheSumOfAPrimeAndTwiceASquare()
    {
        boolean expected = false;
        int value = 16;

        ChristianGoldbachDisprover disprover = new ChristianGoldbachDisprover();
        boolean result = disprover.CanBeWrittenAsTheSumOfAPrimeAndTwiceASquare(value);

        Assert.assertEquals(expected, result);
    }

    @Test
    public void ShouldFindSmallestOddCompositeThatCannotBeWrittenAsTheSumOfPrimeAndTwiceASquare()
    {
        int expected = 5777;
        ChristianGoldbachDisprover disprover = new ChristianGoldbachDisprover();
        long result = disprover.FindSmallestOddCompositeThatCannotBeWrittenAsTheSumOfPrimeAndTwiceASquare();

        Assert.assertEquals(expected,result);
    }
}
