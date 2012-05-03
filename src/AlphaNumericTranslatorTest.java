import junit.framework.Assert;
import org.junit.Test;

/**
 * Go IntelliJ IDEA!
 * User: Austin
 * Date: 5/2/12
 * Time: 9:39 PM
 */
public class AlphaNumericTranslatorTest {
    @Test
    public void ShouldTranslateAto1()
    {
        int expected = 1;

        AlphaNumericTranslator translator = new AlphaNumericTranslator();
        int result = translator.GetNumericValue('a');

        Assert.assertEquals(expected, result);
    }

    @Test
    public void ShouldTranslateBto2()
    {
        int expected = 2;

        AlphaNumericTranslator translator = new AlphaNumericTranslator();
        int result = translator.GetNumericValue('B');

        Assert.assertEquals(expected, result);
    }
}
