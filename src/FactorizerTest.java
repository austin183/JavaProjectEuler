import junit.framework.Assert;
import org.junit.Test;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: Austin
 * Date: 2/8/12
 * Time: 12:48 PM
 * To change this template use File | Settings | File Templates.
 */
public class FactorizerTest {

    @Test
    public void ShouldGetNumberOfFactorsOf28()
    {
        int numberToTest = 28;
        Factorizer factorizer = new Factorizer();

        int result = factorizer.GetNumberFactorsOf(numberToTest);

        Assert.assertEquals(6, result);
    }

    @Test
    public void ShouldGetNumberOfFactorsOf441()
    {
        int numberToTest = 441;
        Factorizer factorizer = new Factorizer();

        int result = factorizer.GetNumberFactorsOf(numberToTest);

        Assert.assertEquals(9, result);
    }

    @Test
    public void ShouldGetNumberOfFactorsOf360()
    {
        int numberToTest = 360;
        Factorizer factorizer = new Factorizer();

        int result = factorizer.GetNumberFactorsOf(numberToTest);

        Assert.assertEquals(24, result);
    }
}
