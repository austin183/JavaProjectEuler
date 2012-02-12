import junit.framework.Assert;
import org.junit.Ignore;
import org.junit.Test;

import java.math.BigInteger;
import java.util.Date;

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
        long maxValue = 26;

        Calculator calculator = new Calculator();
        long result = calculator.GetLargestPrimeFactor(maxValue);

        Assert.assertEquals(13, result);
    }

    @Test
    public void ShouldGetPrimeFactorsUnder38()
    {
        long maxValue = 38;

        Calculator calculator = new Calculator();
        long result = calculator.GetLargestPrimeFactor(maxValue);

        Assert.assertEquals(19, result);
    }

    @Test
    public void ShouldGetPrimeFactorsUnder1670()
    {
        long maxValue = 1670;

        Calculator calculator = new Calculator();
        long result = calculator.GetLargestPrimeFactor(maxValue);

        Assert.assertEquals(167, result);
    }

    @Test
    public void ShouldGetPrimeFactorsUnder15()
    {
        long maxValue = 15;

        Calculator calculator = new Calculator();
        long result = calculator.GetLargestPrimeFactor(maxValue);

        Assert.assertEquals(5, result);
    }

    @Test
    public void ShouldGetPrimeFactorsUnder13195()
    {
        long maxValue = 13195;

        Calculator calculator = new Calculator();
        long result = calculator.GetLargestPrimeFactor(maxValue);

        Assert.assertEquals(29, result);
    }

    @Test
    public void ShouldGetPrimeFactorsUnder600851475143()
    {
        long maxValue = 600851475143L;

        Calculator calculator = new Calculator();
        long result = calculator.GetLargestPrimeFactor(maxValue);

        Assert.assertEquals(6857, result);
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
    public void ShouldGetSumOfPrimesUnder17()
    {
        int maxValue = 10;

        Calculator calculator = new Calculator();
        long result = calculator.GetSumPrimesUnderMaxValue(maxValue);

        Assert.assertEquals(17, result);
    }
    
    @Test
    public void ShouldGetHighestProductOf3ValuesFrom3x3File()
    {
        int sequenceSize = 3;
        
        Calculator calculator = new Calculator();
        Gridizer gridizer = new Gridizer();
        gridizer.InitializeGrid("C:\\Temp\\GridWork\\11.3x3.txt");

        int result = calculator.GetHighestProductOfValuesInGrid(gridizer, sequenceSize);

        Assert.assertEquals(237699, result);
    }

    @Test
    public void ShouldGetHighestProductOf4ValuesFrom20x20File()
    {
        int sequenceSize = 4;

        Calculator calculator = new Calculator();
        Gridizer gridizer = new Gridizer();
        gridizer.InitializeGrid("C:\\Temp\\GridWork\\11.20x20.txt");

        int result = calculator.GetHighestProductOfValuesInGrid(gridizer, sequenceSize);

        Assert.assertEquals(70600674, result);
    }

    @Test
    public void ShouldGetFirstTriangleNumberToHaveOverFiveDivisors()
    {
        int numDivisors = 5;

        Calculator calculator = new Calculator();
        long result = calculator.GetFirstTriangeNumberToHaveNumberDivisors(numDivisors);

        Assert.assertEquals(28, result);
    }

    @Test
    public void ShouldGetFirstTriangleNumberToHaveOverFiveHundredDivisors()
    {
        int numDivisors = 500;

        Calculator calculator = new Calculator();
        long result = calculator.GetFirstTriangeNumberToHaveNumberDivisors(numDivisors);

        Assert.assertEquals(76576500, result);
    }

    @Test
    public void ShouldGetGridRoutesFor2x2Grid()
    {
        //http://joaoff.com/2008/01/20/a-square-grid-path-problem/
        //for n -> 2n : (2n!) / n! (n!)
        Calculator calculator = new Calculator();

        long result = calculator.GetNumberRoutesThroughXbyXGrid(2, 2);
        Assert.assertEquals(6, result);
    }

    @Test
    public void ShouldGetGridRoutesFor20x20Grid()
    {
        //http://joaoff.com/2008/01/20/a-square-grid-path-problem/
        //for n -> 2n : (2n!) / n! (n!)
        Calculator calculator = new Calculator();

        long result = calculator.GetNumberRoutesThroughXbyXGrid(20, 20);
        Assert.assertEquals(137846528820L, result);
    }

    @Test
    public void ShouldGetSumOfCharactersToMake1To1000InWords()
    {
        Calculator calculator = new Calculator();

        int result = calculator.GetCharactersInWordsOneTo(1000);

        Assert.assertEquals(21124, result);
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
    @Ignore("Verrry Slow.  Like 23 minutes slow!")
    public void ShouldGetSumOfPrimesUnder2000000()
    {
        Date start = new Date();

        int maxValue = 2000000;

        Calculator calculator = new Calculator();
        long result = calculator.GetSumPrimesUnderMaxValue(maxValue);

        Date end = new Date();
        int timeInSeconds = (int) ((end.getTime() - start.getTime())/1000);
        System.out.println(Integer.toString(timeInSeconds));

        Assert.assertEquals(0, result);
    }

    @Test
    @Ignore("Manual Test to generate more Primes for the PrimeRecord")
    public void ShouldWritePrimesToFile()
    {
        int maxValue = 2000000;

        PrimeFactorizer PrimeFactorizer = new PrimeFactorizer();
        PrimeFactorizer.MakePrimesList(maxValue, "C:\\Temp\\PrimeTemp.txt");
    }
}
