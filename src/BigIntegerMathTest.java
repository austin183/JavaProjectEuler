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
    public void ShouldGetSumOfNumbersFromFile() {
        BigIntegerMath math = new BigIntegerMath();
        BigInteger sum = math.GetSumOfNumbersInFile("C:\\Temp\\ProjectEuler\\13.SumOfOneHundred50DigitNumbers.txt");

        Assert.assertEquals(new BigInteger("5537376230390876637302048746832985971773659831892672"), sum);
    }

    @Test
    public void ShouldGet2ToThe1000() {
        BigInteger number = new BigInteger("2").pow(1000);
        Assert.assertEquals(new BigInteger("10715086071862673209484250490600018105614048117055336074437503883703510511249361224931983788156958581275946729175531468251871452856923140435984577574698574803934567774824230985421074605062371141877954182153046474983581941267398767559165543946077062914571196477686542167660429831652624386837205668069376"), number);
    }

    @Test
    public void ShouldGetSumOfDigitsIn2ToThe1000() {
        BigIntegerMath math = new BigIntegerMath();
        int result = math.GetSumOfDigitsInNumber(new BigInteger("2").pow(1000));

        Assert.assertEquals(1366, result);
    }

    @Test
    public void ShouldGet3rdValueInFibonacciSequence() {
        BigIntegerMath math = new BigIntegerMath();
        int n = 3;
        BigInteger result = math.GetNthValueInFibonacciSequence(n, BigInteger.ONE, BigInteger.ONE);

        Assert.assertEquals(new BigInteger("2"), result);
    }

    @Test
    public void ShouldGet4thValueInFibonacciSequence() {
        BigIntegerMath math = new BigIntegerMath();
        int n = 4;
        BigInteger result = math.GetNthValueInFibonacciSequence(n, BigInteger.ONE, BigInteger.ONE);

        Assert.assertEquals(new BigInteger("3"), result);
    }

    @Test
    public void ShouldGet5thValueInFibonacciSequence() {
        BigIntegerMath math = new BigIntegerMath();
        int n = 5;
        BigInteger result = math.GetNthValueInFibonacciSequence(n, BigInteger.ONE, BigInteger.ONE);

        Assert.assertEquals(new BigInteger("5"), result);
    }

    @Test
    public void ShouldGet6thValueInFibonacciSequence() {
        BigIntegerMath math = new BigIntegerMath();
        int n = 6;
        BigInteger result = math.GetNthValueInFibonacciSequence(n, BigInteger.ONE, BigInteger.ONE);

        Assert.assertEquals(new BigInteger("8"), result);
    }

    @Test
    public void ShouldGetFirstFibonacciTermWith3Digits() {
        BigIntegerMath math = new BigIntegerMath();
        int n = 3;
        int result = math.GetFirstFibonacciTermWithNumberOfDigits(n, BigInteger.ONE, BigInteger.ONE);

        Assert.assertEquals(12, result);
    }

    @Test
    public void ShouldGetFirstFibonacciTermWith1000Digits() {
        BigIntegerMath math = new BigIntegerMath();
        int n = 1000;
        int result = math.GetFirstFibonacciTermWithNumberOfDigits(n, BigInteger.ONE, BigInteger.ONE);

        Assert.assertEquals(4782, result);
    }

}
