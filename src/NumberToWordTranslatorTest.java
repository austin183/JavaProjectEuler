import junit.framework.Assert;
import org.junit.Test;

/**
 * Go IntelliJ IDEA!
 * User: Austin
 * Date: 2/11/12
 * Time: 6:39 PM
 */
public class NumberToWordTranslatorTest {

    @Test
    public void ShouldGetWordFor1() {
        int number = 1;

        NumberToWordTranslator translator = new NumberToWordTranslator();
        String result = translator.GetWord(number);

        Assert.assertEquals("one", result);
    }

    @Test
    public void ShouldGetWordFor10() {
        int number = 10;

        NumberToWordTranslator translator = new NumberToWordTranslator();
        String result = translator.GetWord(number);

        Assert.assertEquals("ten", result);
    }

    @Test
    public void ShouldGetWordFor19() {
        int number = 19;

        NumberToWordTranslator translator = new NumberToWordTranslator();
        String result = translator.GetWord(number);

        Assert.assertEquals("nineteen", result);
    }

    @Test
    public void ShouldGetWordFor20() {
        int number = 20;

        NumberToWordTranslator translator = new NumberToWordTranslator();
        String result = translator.GetWord(number);

        Assert.assertEquals("twenty", result);
    }

    @Test
    public void ShouldGetWordFor21() {
        int number = 21;

        NumberToWordTranslator translator = new NumberToWordTranslator();
        String result = translator.GetWord(number);

        Assert.assertEquals("twentyone", result);
    }

    @Test
    public void ShouldGetWordFor39() {
        int number = 39;

        NumberToWordTranslator translator = new NumberToWordTranslator();
        String result = translator.GetWord(number);

        Assert.assertEquals("thirtynine", result);
    }

    @Test
    public void ShouldGetWordFor99() {
        int number = 99;

        NumberToWordTranslator translator = new NumberToWordTranslator();
        String result = translator.GetWord(number);

        Assert.assertEquals("ninetynine", result);
    }

    @Test
    public void ShouldGetWordFor100() {
        int number = 100;

        NumberToWordTranslator translator = new NumberToWordTranslator();
        String result = translator.GetWord(number);

        Assert.assertEquals("onehundred", result);
    }

    @Test
    public void ShouldGetWordFor101() {
        int number = 101;

        NumberToWordTranslator translator = new NumberToWordTranslator();
        String result = translator.GetWord(number);

        Assert.assertEquals("onehundredandone", result);
    }

    @Test
    public void ShouldGetWordFor219() {
        int number = 219;

        NumberToWordTranslator translator = new NumberToWordTranslator();
        String result = translator.GetWord(number);

        Assert.assertEquals("twohundredandnineteen", result);
    }

    @Test
    public void ShouldGetWordFor999() {
        int number = 999;

        NumberToWordTranslator translator = new NumberToWordTranslator();
        String result = translator.GetWord(number);

        Assert.assertEquals("ninehundredandninetynine", result);
    }

    @Test
    public void ShouldGetWordFor1000() {
        int number = 1000;

        NumberToWordTranslator translator = new NumberToWordTranslator();
        String result = translator.GetWord(number);

        Assert.assertEquals("onethousand", result);
    }
}
