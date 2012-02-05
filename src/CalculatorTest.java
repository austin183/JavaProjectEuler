import junit.framework.Assert;
import org.junit.Ignore;
import org.junit.Test;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: Austin
 * Date: 1/30/12
 * Time: 9:37 PM
 * To change this template use File | Settings | File Templates.
 */
public class CalculatorTest
{
    @Test
    public void ShouldCalculate23() throws Exception {
       int[] multiples = {3, 5};
       int maxValue = 10;

       Calculator calculator = new Calculator();
       int result = calculator.CalculateSumFromMultiplesUnderMaxValue(multiples, maxValue);

       Assert.assertEquals(23, result);
    }

    @Test
    public void ShouldCalculateSomething() throws Exception {
        int[] multiples = {3, 5};
        int maxValue = 1000;

        Calculator calculator = new Calculator();
        int result = calculator.CalculateSumFromMultiplesUnderMaxValue(multiples, maxValue);

        Assert.assertEquals(233168, result);
    }

    @Test
    public void ShouldCalculateEvenFibSeqNumbersUnder89()
    {
        int start1 = 1;
        int start2 = 2;
        int maxValue = 100;

        Calculator calculator = new Calculator();
        int result = calculator.CalculateFibSeqUnderMaxValue(start1, start2, maxValue);

        Assert.assertEquals(44, result);
    }

    @Test
    public void ShouldCalculateEvenFibSeqNumbersUnder4million()
    {
        int start1 = 1;
        int start2 = 2;
        int maxValue = 4000000;

        Calculator calculator = new Calculator();
        int result = calculator.CalculateFibSeqUnderMaxValue(start1, start2, maxValue);

        Assert.assertEquals(4613732, result);
    }

    @Test
    public void ShouldGetPrimeFactorsUnder26()
    {
        BigInteger maxValue = new BigInteger("26");

        Calculator calculator = new Calculator();
        BigInteger result = calculator.GetLargestPrimeFactor(maxValue);

        Assert.assertTrue("Expecting 13", result.compareTo(new BigInteger("13")) == 0);
    }

    @Test
    public void ShouldGetPrimeFactorsUnder38()
    {
        BigInteger maxValue = new BigInteger("38");

        Calculator calculator = new Calculator();
        BigInteger result = calculator.GetLargestPrimeFactor(maxValue);

        Assert.assertTrue("Expecting 19", result.compareTo(new BigInteger("19")) == 0);
    }

    @Test
    public void ShouldGetPrimeFactorsUnder1670()
    {
        BigInteger maxValue = new BigInteger("1670");

        Calculator calculator = new Calculator();
        BigInteger result = calculator.GetLargestPrimeFactor(maxValue);

        Assert.assertTrue("Expecting 167 but was " + result.toString(), result.compareTo(new BigInteger("167")) == 0);
    }

    @Test
    public void ShouldGetPrimeFactorsUnder15()
    {
        BigInteger maxValue = new BigInteger("15");

        Calculator calculator = new Calculator();
        BigInteger result = calculator.GetLargestPrimeFactor(maxValue);

        Assert.assertTrue("Expecting 5", result.compareTo(new BigInteger("5")) == 0);
    }

    @Test
    public void ShouldGetPrimeFactorsUnder13195()
    {
        BigInteger maxValue = new BigInteger("13195");

        Calculator calculator = new Calculator();
        BigInteger result = calculator.GetLargestPrimeFactor(maxValue);

        Assert.assertTrue("Expecting 29", result.compareTo(new BigInteger("29")) == 0);
    }

    @Test
    public void ShouldGetPrimeFactorsUnder600851475143()
    {
        BigInteger maxValue = new BigInteger("600851475143");

        Calculator calculator = new Calculator();
        BigInteger result = calculator.GetLargestPrimeFactor(maxValue);

        Assert.assertTrue("Expecting 6857 but was " + result.toString(), result.compareTo(new BigInteger("6857")) == 0);
    }
    
    @Test
    public void ShouldGetLargestPalindromeFromTwoNumbers2Digits()
    {
        int digits = 2;
        
        Calculator calculator = new Calculator();
        int result = calculator.GetLargestPalindromeByTwoNumbersXDigits(digits);
        
        Assert.assertEquals(9009, result);
    }

    @Test
    public void ShouldGetLargestPalindromeFromTwoNumbers3Digits()
    {
        int digits = 3;

        Calculator calculator = new Calculator();
        int result = calculator.GetLargestPalindromeByTwoNumbersXDigits(digits);

        Assert.assertEquals(906609, result);
    }

    @Test
    public void ShouldGetLargestPalindromeFromTwoNumbers4Digits()
    {
        int digits = 4;

        Calculator calculator = new Calculator();
        int result = calculator.GetLargestPalindromeByTwoNumbersXDigits(digits);

        Assert.assertEquals(99000099, result);
    }

    @Test
    public void ShouldGetSmallestNumberDivisibleByNumbersBelow10()
    {
        int numbersBelow = 10;

        Calculator calculator = new Calculator();
        int result = calculator.GetSmallestNumberDivisibleByAllNumbersBelowNumber(numbersBelow);

        Assert.assertEquals(2520, result);
    }

    @Test
    @Ignore("Runs kinda slowly")
    public void ShouldGetSmallestNumberDivisibleByNumbersBelow20()
    {
        int numbersBelow = 20;

        Calculator calculator = new Calculator();
        int result = calculator.GetSmallestNumberDivisibleByAllNumbersBelowNumber(numbersBelow);

        Assert.assertEquals(232792560, result);
    }

    @Test
    public void ShouldGetDifferenceBetweenSumOfSquaresAndSquaresOfSumForNumbersBelow10()
    {
        int firstNnumbers = 10;

        Calculator calculator = new Calculator();
        int result = calculator.GetDifferenceBetweenSumOfSquaresAndSquareOfSumForFirstNnumbers(firstNnumbers);

        Assert.assertEquals(2640, result);
    }

    @Test
    public void ShouldGetDifferenceBetweenSumOfSquaresAndSquaresOfSumForNumbersBelow100()
    {
        int firstNnumbers = 100;

        Calculator calculator = new Calculator();
        int result = calculator.GetDifferenceBetweenSumOfSquaresAndSquareOfSumForFirstNnumbers(firstNnumbers);

        Assert.assertEquals(25164150, result);
    }

    @Test
    public void ShouldGetHighestProductOf5DigitsInAStringOfConsecutiveDigits()
    {
        Calculator calculator = new Calculator();
        int result = calculator.GetHighestProductof5DigitsInAStringOfConsecutiveDigits();

        Assert.assertEquals(40824, result);
    }
    
    @Test
    public void ShouldGetPythagoreanTripletThatSumsTo1000()
    {
        int value = 1000;
        Calculator calculator = new Calculator();
        PythagoreanTriplet result = calculator.GetFirstPythagoreanTripletThatSumsTo(value);

        Assert.assertEquals(31875000, result.GetProductOfTriplet());
    }

    @Test
    @Ignore("Manual Test to generate more Primes for the PrimeRecord")
    public void ShouldWritePrimesToFile()
    {
        BigInteger maxValue = new BigInteger("5000000");

        PrimeFactorizer primeFactorizer = new PrimeFactorizer();
        primeFactorizer.MakePrimesList(maxValue);
    }
}
