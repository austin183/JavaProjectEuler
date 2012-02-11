import junit.framework.Assert;
import org.junit.Test;

import java.math.BigInteger;

/**
 * Created by IntelliJ IDEA.
 * User: Austin
 * Date: 2/10/12
 * Time: 8:35 PM
 * To change this template use File | Settings | File Templates.
 */
public class BigIntegerMathTest {
    @Test
    public void ShouldGetSumOfNumbersFromFile()
    {
        BigIntegerMath math = new BigIntegerMath();
        BigInteger sum = math.GetSumOfNumbersInFile("C:\\Temp\\ProjectEuler\\13.SumOfOneHundred50DigitNumbers.txt");

        Assert.assertEquals(new BigInteger("5537376230390876637302048746832985971773659831892672"), sum);
    }
}
