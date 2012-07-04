import junit.framework.Assert;
import org.junit.Ignore;
import org.junit.Test;

import java.util.Date;

/**
 * Go IntelliJ IDEA!
 * User: Austin
 * Date: 1/30/12
 * Time: 9:37 PM
 */
public class CalculatorTest {
    @Test
    public void ShouldCalculateSumOfMultiplesOf3and5Under10() throws Exception {
        int[] multiples = {3, 5};
        int maxValue = 10;

        Calculator calculator = new Calculator();
        int result = calculator.CalculateSumFromMultiplesUnderMaxValue(multiples, maxValue);

        Assert.assertEquals(23, result);
    }

    //Problem 1
    @Test
    public void ShouldCalculateSumOfMultiples3and5Under1000() throws Exception {
        int[] multiples = {3, 5};
        int maxValue = 1000;

        Calculator calculator = new Calculator();
        int result = calculator.CalculateSumFromMultiplesUnderMaxValue(multiples, maxValue);

        Assert.assertEquals(233168, result);
    }

    @Test
    public void ShouldCalculateEvenFibSeqNumbersUnder89() {
        int start1 = 1;
        int start2 = 2;
        int maxValue = 100;

        Calculator calculator = new Calculator();
        int result = calculator.CalculateFibSeqUnderMaxValue(start1, start2, maxValue);

        Assert.assertEquals(44, result);
    }

    //Problem 2
    @Test
    public void ShouldCalculateEvenFibSeqNumbersUnder4million() {
        int start1 = 1;
        int start2 = 2;
        int maxValue = 4000000;

        Calculator calculator = new Calculator();
        int result = calculator.CalculateFibSeqUnderMaxValue(start1, start2, maxValue);

        Assert.assertEquals(4613732, result);
    }

    @Test
    public void ShouldGetPrimeFactorsUnder26() {
        long maxValue = 26;

        Calculator calculator = new Calculator();
        long result = calculator.GetLargestPrimeFactor(maxValue);

        Assert.assertEquals(13, result);
    }

    @Test
    public void ShouldGetPrimeFactorsUnder38() {
        long maxValue = 38;

        Calculator calculator = new Calculator();
        long result = calculator.GetLargestPrimeFactor(maxValue);

        Assert.assertEquals(19, result);
    }

    @Test
    public void ShouldGetPrimeFactorsUnder1670() {
        long maxValue = 1670;

        Calculator calculator = new Calculator();
        long result = calculator.GetLargestPrimeFactor(maxValue);

        Assert.assertEquals(167, result);
    }

    @Test
    public void ShouldGetPrimeFactorsUnder15() {
        long maxValue = 15;

        Calculator calculator = new Calculator();
        long result = calculator.GetLargestPrimeFactor(maxValue);

        Assert.assertEquals(5, result);
    }

    @Test
    public void ShouldGetPrimeFactorsUnder13195() {
        long maxValue = 13195;

        Calculator calculator = new Calculator();
        long result = calculator.GetLargestPrimeFactor(maxValue);

        Assert.assertEquals(29, result);
    }

    //Problem 3
    @Test
    public void ShouldGetPrimeFactorsUnder600851475143() {
        long maxValue = 600851475143L;

        Calculator calculator = new Calculator();
        long result = calculator.GetLargestPrimeFactor(maxValue);

        Assert.assertEquals(6857, result);
    }

    @Test
    public void ShouldGetLargestPalindromeFromTwoNumbers2Digits() {
        int digits = 2;

        Calculator calculator = new Calculator();
        int result = calculator.GetLargestPalindromeByTwoNumbersXDigits(digits);

        Assert.assertEquals(9009, result);
    }

    //Problem 4
    @Test
    public void ShouldGetLargestPalindromeFromTwoNumbers3Digits() {
        int digits = 3;

        Calculator calculator = new Calculator();
        int result = calculator.GetLargestPalindromeByTwoNumbersXDigits(digits);

        Assert.assertEquals(906609, result);
    }

    @Test
    public void ShouldGetLargestPalindromeFromTwoNumbers4Digits() {
        int digits = 4;

        Calculator calculator = new Calculator();
        int result = calculator.GetLargestPalindromeByTwoNumbersXDigits(digits);

        Assert.assertEquals(99000099, result);
    }

    @Test
    public void ShouldGetSmallestNumberDivisibleByNumbersBelow10() {
        int numbersBelow = 10;

        Calculator calculator = new Calculator();
        int result = calculator.GetSmallestNumberDivisibleByAllNumbersBelowNumber(numbersBelow);

        Assert.assertEquals(2520, result);
    }

    @Test
    public void ShouldGetDifferenceBetweenSumOfSquaresAndSquaresOfSumForNumbersBelow10() {
        int firstNnumbers = 10;

        Calculator calculator = new Calculator();
        int result = calculator.GetDifferenceBetweenSumOfSquaresAndSquareOfSumForFirstNnumbers(firstNnumbers);

        Assert.assertEquals(2640, result);
    }

    //Problem 6
    @Test
    public void ShouldGetDifferenceBetweenSumOfSquaresAndSquaresOfSumForNumbersBelow100() {
        int firstNnumbers = 100;

        Calculator calculator = new Calculator();
        int result = calculator.GetDifferenceBetweenSumOfSquaresAndSquareOfSumForFirstNnumbers(firstNnumbers);

        Assert.assertEquals(25164150, result);
    }

    //Problem 8
    @Test
    public void ShouldGetHighestProductOf5DigitsInAStringOfConsecutiveDigits() {
        Calculator calculator = new Calculator();
        int result = calculator.GetHighestProductof5DigitsInAStringOfConsecutiveDigits();

        Assert.assertEquals(40824, result);
    }

    //Problem 9
    @Test
    public void ShouldGetPythagoreanTripletThatSumsTo1000() {
        int value = 1000;
        Calculator calculator = new Calculator();
        PythagoreanTriplet result = calculator.GetFirstPythagoreanTripletThatSumsTo(value);

        Assert.assertEquals(31875000, result.GetProductOfTriplet());
    }

    //Problem 39
    @Test
    public void ShouldGetHighestCountOfPythagoreanTripletsForValuesUnder1000() {
        int max = 1000;
        int expected = 840;

        Calculator calculator = new Calculator();
        int result = calculator.GetHighestCountOfPythagoreanTripletsForValuesUnderMax(max);

        Assert.assertEquals(expected, result);
    }

    @Test
    public void ShouldGetSumOfPrimesUnder17() {
        int maxValue = 10;

        Calculator calculator = new Calculator();
        long result = calculator.GetSumPrimesUnderMaxValue(maxValue);

        Assert.assertEquals(17, result);
    }

    @Test
    public void ShouldGetHighestProductOf3ValuesFrom3x3File() {
        int sequenceSize = 3;
        SupportFiles files = new SupportFiles();
        Calculator calculator = new Calculator();
        Gridizer gridizer = new Gridizer();
        gridizer.InitializeGrid(files.Location + "11.3x3.txt");

        int result = calculator.GetHighestProductOfValuesInGrid(gridizer, sequenceSize);

        Assert.assertEquals(237699, result);
    }

    //Problem 11
    @Test
    public void ShouldGetHighestProductOf4ValuesFrom20x20File() {
        int sequenceSize = 4;

        Calculator calculator = new Calculator();
        Gridizer gridizer = new Gridizer();
        SupportFiles files = new SupportFiles();
        gridizer.InitializeGrid(files.Location + "11.20x20.txt");

        int result = calculator.GetHighestProductOfValuesInGrid(gridizer, sequenceSize);

        Assert.assertEquals(70600674, result);
    }

    @Test
    public void ShouldGetFirstTriangleNumberToHaveOverFiveDivisors() {
        int numDivisors = 5;

        Calculator calculator = new Calculator();
        long result = calculator.GetFirstTriangeNumberToHaveNumberDivisors(numDivisors);

        Assert.assertEquals(28, result);
    }

    //Problem 12
    @Test
    public void ShouldGetFirstTriangleNumberToHaveOverFiveHundredDivisors() {
        int numDivisors = 500;

        Calculator calculator = new Calculator();
        long result = calculator.GetFirstTriangeNumberToHaveNumberDivisors(numDivisors);

        Assert.assertEquals(76576500, result);
    }

    @Test
    public void ShouldGetGridRoutesFor2x2Grid() {
        //http://joaoff.com/2008/01/20/a-square-grid-path-problem/
        //for n -> 2n : (2n!) / n! (n!)
        Calculator calculator = new Calculator();

        long result = calculator.GetNumberRoutesThroughXbyXGrid(2, 2);
        Assert.assertEquals(6, result);
    }

    //Problem 15
    @Test
    public void ShouldGetGridRoutesFor20x20Grid() {
        //http://joaoff.com/2008/01/20/a-square-grid-path-problem/
        //for n -> 2n : (2n!) / n! (n!)
        Calculator calculator = new Calculator();

        long result = calculator.GetNumberRoutesThroughXbyXGrid(20, 20);
        Assert.assertEquals(137846528820L, result);
    }

    //Problem 17
    @Test
    public void ShouldGetSumOfCharactersToMake1To1000InWords() {
        Calculator calculator = new Calculator();

        int result = calculator.GetCharactersInWordsOneTo(1000);

        Assert.assertEquals(21124, result);
    }

    //Problem 5
    @Test
    @Ignore("Runs kinda slowly")
    public void ShouldGetSmallestNumberDivisibleByNumbersBelow20() {
        int numbersBelow = 20;

        Calculator calculator = new Calculator();
        int result = calculator.GetSmallestNumberDivisibleByAllNumbersBelowNumber(numbersBelow);

        Assert.assertEquals(232792560, result);
    }

    //Problem 26
    @Test
    public void ShouldFindLongestRecurringCycleForValuesUnder1000() {
        int max = 1000;
        Calculator calculator = new Calculator();
        int result = calculator.GetLongestRecurringCycleForValuesUnderMax(max);

        Assert.assertEquals(983, result);
    }

    @Test
    public void ShouldFindCountOfFirstConsecutivePrimeNumbersInQuadraticFormula1And41() {
        int a = 1;
        int b = 41;

        Calculator calculator = new Calculator();
        int result = calculator.GetCountOfFirstPrimeConsecutiveNumbersInQuadraticFormula(a, b);

        Assert.assertEquals(40, result);
    }

    @Test
    public void ShouldFindCountOfFirstConsecutivePrimeNumbersInQuadraticFormulaNeg79And1601() {
        int a = -79;
        int b = 1601;

        Calculator calculator = new Calculator();
        int result = calculator.GetCountOfFirstPrimeConsecutiveNumbersInQuadraticFormula(a, b);

        Assert.assertEquals(80, result);
    }

    @Test
    public void ShouldFindHighestCountOfFirstConsecutivePrimeNumbersInQuadraticFormulaForAorBNeg1000To1000() {
        int min = -1000;
        int max = 1000;

        Calculator calculator = new Calculator();
        int result = calculator.GetHighestCountOfFirstPrimeConsecutiveNumbersInQuadraticFormula(min, max);

        Assert.assertEquals(71, result);
    }

    //Problem 27
    @Test
    public void ShouldFindCoefficientOfAandBWithHighestCountOfFirstConsecutivePrimeNumbersInQuadraticFormulaForAorBNeg1000To1000() {
        int min = -1000;
        int max = 1000;

        Calculator calculator = new Calculator();
        int result = calculator.GetCoefficientOfAandBWithHighestCountOfFirstPrimeConsecutiveNumbersInQuadraticFormula(min, max);

        Assert.assertEquals(-59231, result);
    }

    @Test
    public void ShouldGetCountOfDistinctSequenceFromAtoBthPowerAnBBetween2And5() {
        int min = 2;
        int max = 5;
        int expected = 15;

        Calculator calculator = new Calculator();
        int result = calculator.GetCountOfDistinctSequenceFromAToBthPowerBetween(min, max);

        Assert.assertEquals(expected, result);
    }

    //Problem 29
    @Test
    public void ShouldGetCountOfDistinctSequenceFromAtoBthPowerAnBBetween2And100() {
        int min = 2;
        int max = 100;
        int expected = 9183;

        Calculator calculator = new Calculator();
        int result = calculator.GetCountOfDistinctSequenceFromAToBthPowerBetween(min, max);

        Assert.assertEquals(expected, result);
    }

    @Test
    public void ShouldGetSumOfAllDigitsThatCanBeWrittenAsSumOf4PowerOfDigits() {
        int power = 4;
        int expected = 19316;

        Calculator calculator = new Calculator();
        int result = calculator.GetSumOfAllDigitsThatCanBeWrittenAsSumOfPowerOfDigits(power);

        Assert.assertEquals(expected, result);
    }

    //Problem 30
    @Test
    public void ShouldGetSumOfAllDigitsThatCanBeWrittenAsSumOf5PowerOfDigits() {
        int power = 5;
        int expected = 443839;

        Calculator calculator = new Calculator();
        int result = calculator.GetSumOfAllDigitsThatCanBeWrittenAsSumOfPowerOfDigits(power);

        Assert.assertEquals(expected, result);
    }

    //Problem 36
    @Test
    public void ShouldGetSumOfAllNumbersUnder1MillionWhichArePalindromicInBase10And2() {
        int limit = 1000000;
        int expected = 872187;

        Calculator calculator = new Calculator();

        int result = calculator.GetSumOfAllNumbersUnder1MillionWhichArePalindromicInBase10And2UnderLimit(limit);

        Assert.assertEquals(expected, result);
    }

    //Problem 38
    @Test
    public void ShouldFindLargest1Through9PandigitalFoundUsingConcatenatedProductOfAnIntegerWith12NList() {
        String expected = "932718654";

        Calculator calculator = new Calculator();
        String result = calculator.GetLargest1Through9PandigitalFoundUsingConcatenatedProductOfAnIntegerWith12NList();

        Assert.assertEquals(expected, result);
    }

    //Problem 41
    @Test
    public void ShouldFindLargestPandigitalPrime() {
        Calculator calculator = new Calculator();
        int result = calculator.GetLargestPandigitalPrime();

        Assert.assertEquals(7652413, result);
    }

    //Problem 42
    @Test
    public void ShouldFindCountWordsThatSummedNumericallyAreTriangleNumbers()
    {
        int expected = 162;
        SupportFiles files = new SupportFiles();
        String filepath = files.Location + "42.TriangleWords.txt";

        Calculator calculator = new Calculator();
        int result = calculator.FindCountWordsThatSummedNumericallyAreTriangleNumbers(filepath);

        Assert.assertEquals(expected, result);
    }

    //Problem 44
    @Test
    public void ShouldFindLowestPentagonalPairWhereSumAndDifferenceAreAlsoPentagonal()
    {
        int expected = 5482660;

        Calculator calculator = new Calculator();
        int result = calculator.FindLowestPentagonalPairWhereSumAndDifferenceAreAlsoPentagonal();

        Assert.assertEquals(expected, result);
    }

    @Test
    public void ShouldFindThat40755IsTriPentHexagonalNumber()
    {
        boolean expected = true;
        int value = 40755;

        Calculator calculator = new Calculator();
        boolean result = calculator.IsTriPentHexagonalNumber(value);

        Assert.assertEquals(expected, result);
    }

    //Problem 45
    @Test
    public void ShouldFindNextTriPentHexagonalNumberAfterHex143()
    {
        long expected = 1533776805;
        int hexStart = 144;

        Calculator calculator = new Calculator();
        long result = calculator.FindNextTriPentHexagonalNumberAfterHex(hexStart);

        Assert.assertEquals(expected, result);
    }

    //Problem 49
    @Test
    public void ShouldFindOtherPermutativePrimeIncreasingSeriesOtherThan1487()
    {
        String expected = "296962999629";

        Calculator calculator = new Calculator();
        String result = calculator.GetPermutativePrimeNot1487();

        Assert.assertEquals(expected, result);
    }

    //Problem 47
    @Test
    @Ignore("21 seconds slow")
    public void ShouldFindFirstOfFirstFourConsecutiveIntegersToHave4DistinctPrimeFactors()
    {
        int expected = 134043;

        Calculator calculator = new Calculator();
        int result = calculator.FindFirstOfFirstFourConsecutiveIntegersToHave4DistinctPrimeFactors();

        Assert.assertEquals(expected, result);
    }

    @Test
    public void ShouldFindLongestSumOfConsecutivePrimesUnder100()
    {
        int max = 100;
        int expected = 41;

        Calculator calculator = new Calculator();
        int result = calculator.FindLongestSumOfConsecutivePrimesUnderMax(max);

        Assert.assertEquals(expected, result);
    }

    @Test
    public void ShouldFindLongestSumOfConsecutivePrimesUnder1000()
    {
        int max = 1000;
        int expected = 953;

        Calculator calculator = new Calculator();
        int result = calculator.FindLongestSumOfConsecutivePrimesUnderMax(max);

        Assert.assertEquals(expected, result);
    }

    //Problem 50
    @Test
    @Ignore("5 - 6 mins slow")
    public void ShouldFindLongestSumOfConsecutivePrimesUnder1000000()
    {
        int max = 1000000;
        int expected = 997651;

        Calculator calculator = new Calculator();
        int result = calculator.FindLongestSumOfConsecutivePrimesUnderMax(max);

        Assert.assertEquals(expected, result);
    }


    //Problem 43
    @Test
    @Ignore("29 seconds Slow Test")
    public void ShouldFindSumOfPandigitalNumbersWithAscendingPrimeSubStringDivisibilityProperty()
    {
        long expected = 16695334890l;

        Calculator calculator = new Calculator();
        long result = calculator.FindSumOfPandigitalNumbersWithAscendingPrimeSubStringDivisibilityProperty();

        Assert.assertEquals(expected, result);
    }

    //Problem 37
    @Test
    @Ignore("Slow like a minute")
    public void ShouldFindSumOfOnly11PrimesThatAreTruncatableBothDirections() {
        int expected = 748317;

        Calculator calculator = new Calculator();
        int result = calculator.GetSumOfOnly11PrimesThatAreTruncatableBothDirections();

        Assert.assertEquals(expected, result);
    }


    @Test
    @Ignore("Verrry Slow.  Like 23 minutes slow!")
    public void ShouldGetSumOfPrimesUnder2000000() {
        Date start = new Date();

        int maxValue = 2000000;

        Calculator calculator = new Calculator();
        long result = calculator.GetSumPrimesUnderMaxValue(maxValue);

        Date end = new Date();
        int timeInSeconds = (int) ((end.getTime() - start.getTime()) / 1000);
        System.out.println(Integer.toString(timeInSeconds));

        Assert.assertEquals(0, result);
    }

    @Test
    @Ignore("Manual Test to generate more Primes for the PrimeRecord")
    public void ShouldWritePrimesToFile() {
        int maxValue = 2000000;

        PrimeFactorizer PrimeFactorizer = new PrimeFactorizer();
        PrimeFactorizer.MakePrimesList(maxValue, "C:\\Temp\\PrimeTemp.txt");
    }
}
