import java.io.*;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: Austin
 * Date: 1/30/12
 * Time: 9:31 PM
 * To change this template use File | Settings | File Templates.
 */
class Calculator {

    public int CalculateSumFromMultiplesUnderMaxValue(int[] multiples, int maxValue) {
        int toReturn = 0;
        for (int i = 2; i < maxValue; i++) {
            for (int multiple : multiples) {
                if (i % multiple == 0) {
                    toReturn += i;
                    break;
                }
            }
        }
        return toReturn;
    }

    public int CalculateFibSeqUnderMaxValue(int start1, int start2, int maxValue) {
        int toReturn = 0;

        int first = start1;
        int second = start2;

        while (second < maxValue) {
            if (first == start1 && start1 % 2 == 0)
                toReturn += first;
            if (second % 2 == 0)
                toReturn += second;

            int swapper = second;
            second = first + second;
            first = swapper;
        }
        return toReturn;
    }


    public int GetLargestPalindromeByTwoNumbersXDigits(int digits) {
        int toReturn = 0;

        int maxValue = (int) ((int) Math.pow((double) 10, (double) digits) - (double) 1);
        int minValue = (int) Math.pow((double) 10, (double) digits - 1);
        Palindromizer palindromizer = new Palindromizer();

        for (int i = minValue; i <= maxValue; i++) {
            for (int j = minValue; j <= maxValue; j++) {
                int candidate = j * i;
                if (candidate > toReturn && palindromizer.IsPalindrome(candidate))
                    toReturn = candidate;
            }
        }

        return toReturn;
    }

    public int GetSmallestNumberDivisibleByAllNumbersBelowNumber(int allNumbersBelow) {
        int candidate = allNumbersBelow * (allNumbersBelow - 1) - 1;
        boolean haveNotFoundGoodCandidate = true;
        while (haveNotFoundGoodCandidate) {
            candidate++;
            haveNotFoundGoodCandidate = false;
            for (int i = 1; i <= allNumbersBelow; i++) {
                if (candidate % i != 0) {
                    haveNotFoundGoodCandidate = true;
                    break;
                }
            }
        }
        return candidate;
    }

    public int GetDifferenceBetweenSumOfSquaresAndSquareOfSumForFirstNnumbers(int allNumbersAtOrBelow) {
        int sumOfSquares = 0;
        int squareOfSum = 0;

        for (int i = 1; i <= allNumbersAtOrBelow; i++) {
            sumOfSquares += Math.pow((double) i, (double) 2);
            squareOfSum += i;
        }
        squareOfSum = (int) Math.pow(squareOfSum, 2);

        return squareOfSum - sumOfSquares;
    }

    public int GetHighestProductof5DigitsInAStringOfConsecutiveDigits() {
        int highestValue = 0;
        FileInputStream fileInputStream = null;
        try {
            String DIGIT_STRING = "C:\\Temp\\PrimeWork\\1000DigitString.txt";
            fileInputStream = new FileInputStream(DIGIT_STRING);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        DataInputStream in = new DataInputStream(fileInputStream);
        BufferedReader reader = new BufferedReader(new InputStreamReader(in));
        String line;
        try {
            while ((line = reader.readLine()) != null) {

                for (int i = 0; i < line.length() - 5; i++) {
                    int product = GetProductOfDigits(line.substring(i, i + 5));
                    if (highestValue < product)
                        highestValue = product;
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        return highestValue;
    }

    private int GetProductOfDigits(String substring) {
        int toReturn = 1;
        for (int i = 0; i < substring.length(); i++) {
            toReturn *= Integer.parseInt(substring.substring(i, i + 1));
        }
        return toReturn;
    }

    public PythagoreanTriplet GetFirstPythagoreanTripletThatSumsTo(int value) {
        Pythagorizer pythagorizer = new Pythagorizer();
        for (int a = 1; a < value; a++) {
            for (int b = a + 1; b < value; b++) {
                int c = value - a - b;

                if (pythagorizer.IsTriplet(a, b, c))
                    return new PythagoreanTriplet(a, b, c);
            }
        }
        return null;
    }

    public long GetSumPrimesUnderMaxValue(int maxValue) {

        PrimeFactorizer PrimeFactorizer = new PrimeFactorizer();

        return PrimeFactorizer.GetSumPrimesUnderMaxValue(maxValue);
    }

    public long GetLargestPrimeFactor(long maxValue) {
        PrimeFactorizer PrimeFactorizer = new PrimeFactorizer();

        return PrimeFactorizer.GetLargestPrimeFactor(maxValue);
    }

    public int GetHighestProductOfValuesInGrid(Gridizer gridizer, int sequenceSize) {
        int toReturn = 0;
        for (int x = 0; x < gridizer.GetGrid().size(); x++) {
            for (int y = 0; y < gridizer.GetGrid().get(x).size(); y++) {
                int productDown = gridizer.GetProductDown(x, y, sequenceSize);
                int productRight = gridizer.GetProductRight(x, y, sequenceSize);
                int productDownAndRight = gridizer.GetProductDownAndRight(x, y, sequenceSize);
                int productDownAndLeft = gridizer.GetProductDownAndLeft(x, y, sequenceSize);

                if (productDown > toReturn) toReturn = productDown;
                if (productRight > toReturn) toReturn = productRight;
                if (productDownAndRight > toReturn) toReturn = productDownAndRight;
                if (productDownAndLeft > toReturn) toReturn = productDownAndLeft;
            }
        }
        return toReturn;
    }

    public long GetFirstTriangeNumberToHaveNumberDivisors(int numDivisors) {
        int currentNumDivisors = 0;
        int triangleIndex = 1;
        long triangleNumber = 0;

        Triangulizer triangulizer = new Triangulizer();
        Factorizer factorizer = new Factorizer();

        while (currentNumDivisors < numDivisors) {
            triangleNumber = triangulizer.GetTriangleNumberAt(triangleIndex);
            currentNumDivisors = factorizer.GetNumberFactorsOf(triangleNumber);

            triangleIndex++;
            if (triangleIndex % 100 == 0) {
                System.out.println("Current Triangle Number: " + triangleNumber
                        + " Current Num Divisors: " + currentNumDivisors);
            }
        }
        return triangleNumber;
    }

    public long GetNumberRoutesThroughXbyXGrid(int m, int n) {
        Factorializer factorializer = new Factorializer();

        BigInteger mnBang = factorializer.Factorialize(m + n);
        BigInteger mBang = factorializer.Factorialize(m);
        BigInteger nBang = factorializer.Factorialize(n);

        BigInteger answer = mnBang.divide(mBang.multiply(nBang));
        return answer.longValue();
    }

    public int GetCharactersInWordsOneTo(int number) {
        int toReturn = 0;
        NumberToWordTranslator translator = new NumberToWordTranslator();
        for (int i = 1; i <= number; i++) {
            toReturn += translator.GetWord(i).length();
        }
        return toReturn;
    }

    public int GetLongestRecurringCycleForValuesUnderMax(int max) {
        int longestCycle = 0;
        int toReturn = 0;
        RecurringCycleFinder finder = new RecurringCycleFinder();
        for (int i = 1; i <= max; i++) {
            int length = finder.FindCycleLength(i);
            if (longestCycle < length) {
                longestCycle = length;
                toReturn = i;
            }

        }
        return toReturn;
    }

    public int GetCountOfFirstPrimeConsecutiveNumbersInQuadraticFormula(int a, int b) {
        PrimeFactorizer factorizer = new PrimeFactorizer();
        int count = 0;
        boolean stillPrime;
        do {
            int result = (count * count) + (a * count) + b;
            stillPrime = factorizer.IsPrime(Math.abs(result), true);
            if (stillPrime) count++;
        } while (stillPrime);
        return count;
    }

    public int GetHighestCountOfFirstPrimeConsecutiveNumbersInQuadraticFormula(int min, int max) {
        int toReturn = 0;
        for (int b = min; b <= max; b++) {
            for (int a = min; a <= max; a++) {
                int result = GetCountOfFirstPrimeConsecutiveNumbersInQuadraticFormula(a, b);
                if (toReturn < result) toReturn = result;
            }
        }
        return toReturn;
    }

    public int GetCoefficientOfAandBWithHighestCountOfFirstPrimeConsecutiveNumbersInQuadraticFormula(int min, int max) {
        int toReturn = 0;
        int highestCount = 0;
        List<Integer> primesBetweenMinAndMax = GetPrimesBetweenMinAndMax(min, max);
        for (Integer b : primesBetweenMinAndMax) {
            for (int a = min; a <= max; a++) {
                int result = GetCountOfFirstPrimeConsecutiveNumbersInQuadraticFormula(a, b);
                if (highestCount < result) {
                    highestCount = result;
                    toReturn = a * b;
                }
            }
        }
        return toReturn;
    }

    private List<Integer> GetPrimesBetweenMinAndMax(int min, int max) {
        List<Integer> toReturn = new ArrayList<Integer>();
        int realMax = Math.abs(min) < Math.abs(max) ? Math.abs(max) : Math.abs(min);
        PrimeFactorizer factorizer = new PrimeFactorizer();
        for (int i = 0; i <= realMax; i++) {
            if (factorizer.IsPrime(i, true)) {
                if (i < Math.abs(min)) toReturn.add(i * (min / Math.abs(min)));
                if (i < Math.abs(max)) toReturn.add(i * (max / Math.abs(max)));
            }
        }
        return toReturn;
    }

    public int GetCountOfDistinctSequenceFromAToBthPowerBetween(int min, int max) {
        List<Double> distinctValues = new ArrayList<Double>();
        for (int a = min; a <= max; a++) {
            for (int b = min; b <= max; b++) {
                double result = Math.pow(a, b);
                if (!distinctValues.contains(result)) distinctValues.add(result);
            }
        }
        return distinctValues.size();
    }

    public int GetSumOfAllDigitsThatCanBeWrittenAsSumOfPowerOfDigits(int power) {
        List<Integer> valuesThatCanBeWritten = new ArrayList<Integer>();
        IntegerMath math = new IntegerMath();
        int max = math.Pow(10, power + 1);
        for (int i = 2; i < max; i++) {
            if (GetSumOfDigits(i, power) == i) valuesThatCanBeWritten.add(i);
        }
        return GetSum(valuesThatCanBeWritten);
    }

    private int GetSum(List<Integer> valuesThatCanBeWritten) {
        int toReturn = 0;
        for (double i : valuesThatCanBeWritten) {
            toReturn += i;
        }
        return toReturn;
    }

    private double GetSumOfDigits(int value, int power) {
        double toReturn = 0;
        String digits = Integer.toString(value);
        IntegerMath math = new IntegerMath();
        for (int i = 0; i < digits.length(); i++) {
            int digit = Integer.parseInt(digits.substring(i, i + 1));
            toReturn += math.Pow(digit, power);
        }
        return toReturn;
    }
}
