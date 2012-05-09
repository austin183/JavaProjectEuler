import junit.framework.Assert;
import org.junit.Test;

/**
 * Go IntelliJ IDEA!
 * User: Austin
 * Date: 3/26/12
 * Time: 7:58 PM
 */
public class PanDigitizerTest {
    @Test
    public void ShouldRecognizePartialPandigital() {
        int testValue = 12;
        boolean expected = true;

        PanDigitizer panDigitizer = new PanDigitizer();

        boolean result = panDigitizer.IsPartialPanDigital(testValue);

        Assert.assertEquals(expected, result);
    }

    @Test
    public void ShouldRecognize123456789AsPandigital() {
        int testValue = 123456789;
        boolean expected = true;

        PanDigitizer panDigitizer = new PanDigitizer();

        boolean result = panDigitizer.IsPanDigital1Through9(testValue);

        Assert.assertEquals(expected, result);
    }


    @Test
    public void ShouldRecognize321654987AsPandigital() {
        int testValue = 321654987;
        boolean expected = true;

        PanDigitizer panDigitizer = new PanDigitizer();

        boolean result = panDigitizer.IsPanDigital1Through9(testValue);

        Assert.assertEquals(expected, result);
    }

    @Test
    public void ShouldNotRecognize1AsPanDigital() {
        int testValue = 1;
        boolean expected = false;

        PanDigitizer panDigitizer = new PanDigitizer();

        boolean result = panDigitizer.IsPanDigital1Through9(testValue);

        Assert.assertEquals(expected, result);
    }

    @Test
    public void ShouldRecognize725439186AsPandigital() {
        int testValue = 725439186;
        boolean expected = true;

        PanDigitizer panDigitizer = new PanDigitizer();

        boolean result = panDigitizer.IsPanDigital1Through9(testValue);

        Assert.assertEquals(expected, result);
    }

    @Test
    public void ShouldFind7254ToBePandigitalWithCorrectMultiplicandAndMultiplier() {
        int testValue = 7254;
        boolean expected = true;

        PanDigitizer panDigitizer = new PanDigitizer();

        boolean result = panDigitizer.IsPanDigital1Through9WithMultiplicandAndMultiplier(testValue);

        Assert.assertEquals(expected, result);
    }

    //Problem 32
    @Test
    public void ShouldFindSumOfProductsWhereProductIsPandigital1Through9WithMultiplicandAndMultiplier() {
        int expected = 45228;

        PanDigitizer panDigitizer = new PanDigitizer();

        int result = panDigitizer.GetSumOfProductsWhereProductIsPandigital1Though9WithMultiplicandAndMultiplier();

        Assert.assertEquals(expected, result);
    }
}
