import junit.framework.Assert;
import org.junit.Test;

import java.math.BigInteger;

/**
 * Go IntelliJ IDEA!
 * User: Austin
 * Date: 2/10/12
 * Time: 8:35 PM
 */
public class BigIntegerMathTest {
    //Problem 13
    @Test
    public void ShouldGetSumOfNumbersFromFile() {
        SupportFiles files = new SupportFiles();
        BigIntegerMath math = new BigIntegerMath();
        BigInteger sum = math.GetSumOfNumbersInFile(files.Location + "13.SumOfOneHundred50DigitNumbers.txt");

        Assert.assertEquals(new BigInteger("5537376230390876637302048746832985971773659831892672"), sum);
    }

    @Test
    public void ShouldGet2ToThe1000() {
        BigInteger number = new BigInteger("2").pow(1000);
        Assert.assertEquals(new BigInteger("10715086071862673209484250490600018105614048117055336074437503883703510511249361224931983788156958581275946729175531468251871452856923140435984577574698574803934567774824230985421074605062371141877954182153046474983581941267398767559165543946077062914571196477686542167660429831652624386837205668069376"), number);
    }

    //Problem 16
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

    @Test
    public void ShouldFindLast4DigitsOfSumOfSequentiallyExponentialSeriesTo10()
    {
        BigIntegerMath math = new BigIntegerMath();
        String expected = "1317";
        int numberOfLastDigits = 4;
        int seriesTo = 10;

        String result = math.FindLastDigitsOfSumOfSequentiallyExponentialSeriesTo(numberOfLastDigits, seriesTo);

        Assert.assertEquals(expected, result);
    }

    //Problem 48
    @Test
    public void ShouldFindLast10DigitsOfSumOfSequentiallyExponentialSeriesTo1000()
    {
        BigIntegerMath math = new BigIntegerMath();
        String expected = "9110846700";
        int numberOfLastDigits = 10;
        int seriesTo = 1000;

        String result = math.FindLastDigitsOfSumOfSequentiallyExponentialSeriesTo(numberOfLastDigits, seriesTo);

        Assert.assertEquals(expected, result);
    }
}
