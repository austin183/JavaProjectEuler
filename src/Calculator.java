import java.io.*;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

/**
 * Go IntelliJ IDEA!
 * User: Austin
 * Date: 1/30/12
 * Time: 9:31 PM
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
        String DIGIT_STRING = "C:\\Temp\\PrimeWork\\1000DigitString.txt";

        FileHelper fileHelper = new FileHelper();
        BufferedReader reader = fileHelper.GetReader(DIGIT_STRING);
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

    public int GetSumOfAllNumbersUnder1MillionWhichArePalindromicInBase10And2UnderLimit(int limit) {
        int toReturn = 0;

        Palindromizer palindromizer = new Palindromizer();
        for (int i = 1; i <= limit; i++) {
            if (palindromizer.IsBinaryPalindrome(i) && palindromizer.IsPalindrome(i))
                toReturn += i;
        }

        return toReturn;
    }

    public int GetSumOfOnly11PrimesThatAreTruncatableBothDirections() {
        int sumToReturn = 0;
        int count = 0;

        PrimeFactorizer factorizer = new PrimeFactorizer();
        for (int i = 11; count < 11; i++) {
            if (factorizer.IsPrimeAndTruncatablyPrimeBothDirections(i)) {
                sumToReturn += i;
                count++;
                System.out.println("Found " + i + ". " + count + " so far. Total: " + sumToReturn);
            }
            if (i % 100000 == 0)
                System.out.println("Testing " + i);
        }

        return sumToReturn;
    }

    public String GetLargest1Through9PandigitalFoundUsingConcatenatedProductOfAnIntegerWith12NList() {
        String currentCandidate = "987654321";
        String currentConcatenatedProduct;
        PanDigitizer digitizer = new PanDigitizer();
        Permutizer permutizer = new Permutizer();
        while (Integer.parseInt(currentCandidate) > Integer.parseInt("918273645")) {
            for (int i = 8; i > 1; i--) {
                int trialNumber = (int) (Integer.parseInt(currentCandidate) / Math.pow(10, i));
                currentConcatenatedProduct = Integer.toString(trialNumber);
                int k = 2;
                boolean isStillViable = true;
                while (isStillViable) {
                    currentConcatenatedProduct += Integer.toString(trialNumber * k);
                    if (currentCandidate.length() < currentConcatenatedProduct.length()) {
                        isStillViable = false;
                        continue;
                    }
                    if (!digitizer.IsPartialPanDigital(Integer.parseInt(currentConcatenatedProduct))) {
                        isStillViable = false;
                        continue;
                    }
                    if (digitizer.IsPanDigital1Through9(Integer.parseInt(currentConcatenatedProduct))) {
                        return currentConcatenatedProduct;
                    }
                }
            }
            currentCandidate = permutizer.GetPreviousPermutation(currentCandidate);

        }
        return currentCandidate;
    }

    public int GetHighestCountOfPythagoreanTripletsForValuesUnderMax(int max) {
        int toReturn = 0;
        int highestCount = 0;
        Pythagorizer pythagorizer = new Pythagorizer();
        for (int i = 1; i <= max; i++) {
            int currentCount = pythagorizer.GetCountOfPythagoreanTripletsThatSumsTo(i);
            if (highestCount < currentCount) {
                toReturn = i;
                highestCount = currentCount;
            }
        }
        return toReturn;
    }

    public int GetLargestPandigitalPrime() {
        //9,8,6, and 5 are out because 1 + ... n is divisible by three
        //I hypothesize that a 7 digit pandigital exists and can be found!
        Permutizer permutizer = new Permutizer();
        PrimeFactorizer factorizer = new PrimeFactorizer();
        String currentPandigitalString = "7654321";
        int currentPandigital = Integer.parseInt(currentPandigitalString);
        while (!factorizer.IsPrime(currentPandigital)) {
            currentPandigitalString = permutizer.GetPreviousPermutation(currentPandigitalString);
            currentPandigital = Integer.parseInt(currentPandigitalString);
        }

        return currentPandigital;
    }

    public long FindSumOfPandigitalNumbersWithAscendingPrimeSubStringDivisibilityProperty() {
        Permutizer permutizer = new Permutizer();
        long toReturn = 0;
        String currentPandigitalNumber = "0123456789";

        do{
            int twothreefour = Integer.parseInt(
                    currentPandigitalNumber.substring(1, 2)
                    + currentPandigitalNumber.substring(2, 3)
                    + currentPandigitalNumber.substring(3, 4) );

            int threefourfive = Integer.parseInt(
                    currentPandigitalNumber.substring(2, 3)
                    + currentPandigitalNumber.substring(3, 4)
                    + currentPandigitalNumber.substring(4, 5) );

            int fourfivesix = Integer.parseInt(
                    currentPandigitalNumber.substring(3, 4)
                    + currentPandigitalNumber.substring(4, 5)
                    + currentPandigitalNumber.substring(5, 6) );


            int fivesixseven = Integer.parseInt(
                            currentPandigitalNumber.substring(4, 5)
                            + currentPandigitalNumber.substring(5, 6)
                            + currentPandigitalNumber.substring(6, 7));

            int sixseveneight = Integer.parseInt(
                            currentPandigitalNumber.substring(5, 6)
                            + currentPandigitalNumber.substring(6, 7)
                            + currentPandigitalNumber.substring(7, 8));

            int seveneightnine = Integer.parseInt(
                    currentPandigitalNumber.substring(6, 7)
                            + currentPandigitalNumber.substring(7, 8)
                            + currentPandigitalNumber.substring(8, 9));

            int eightnineten = Integer.parseInt(
                    currentPandigitalNumber.substring(7, 8)
                            + currentPandigitalNumber.substring(8, 9)
                            + currentPandigitalNumber.substring(9, 10));

            if(twothreefour % 2 == 0 && threefourfive % 3 ==0 && fourfivesix % 5 == 0
                    && fivesixseven % 7 == 0 && sixseveneight % 11 == 0 && seveneightnine % 13== 0
                    && eightnineten % 17 == 0)
            {
                System.out.println("Adding " + currentPandigitalNumber + " to " + toReturn);
                toReturn += Long.parseLong(currentPandigitalNumber);
            }
            currentPandigitalNumber = permutizer.GetNextPermutation(currentPandigitalNumber);

        }while (!currentPandigitalNumber.equals(""));

        return toReturn;
    }

    public int FindCountWordsThatSummedNumericallyAreTriangleNumbers(String filepath) {
        int toReturn = 0;

        FileHelper fileHelper = new FileHelper();
        BufferedReader reader = fileHelper.GetReader(filepath);
        Triangulizer triangulizer = new Triangulizer();
        AlphaNumericTranslator translator = new AlphaNumericTranslator();
        String line;
        try {
            if ((line = reader.readLine()) != null) {
                String[] words = line.split(",");
                for (String word : words) {
                    int sum = translator.GetNumericValue(word);
                    if(triangulizer.IsTriangleNumber(sum))
                        toReturn++;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return toReturn;
    }

    public int FindLowestPentagonalPairWhereSumAndDifferenceAreAlsoPentagonal() {
        int toReturn = 0;
        int index = 1;

        PentagonalNumberizer numberizer = new PentagonalNumberizer();

        while(toReturn == 0)
        {
            index++;
            int pi = numberizer.GetPentagonalNumberAt(index);
            for(int i = 1; i < index; i++)
            {
                int pj = numberizer.GetPentagonalNumberAt(i);
                int pk = pi - pj;
                if(numberizer.IsPentagonalNumber(pk) && numberizer.IsPentagonalNumber(pk + pj) && numberizer.IsPentagonalNumber(Math.abs(pk - pj)))
                {
                    toReturn = Math.abs(pk - pj);
                }
            }
        }
        return toReturn;

    }

    public boolean IsTriPentHexagonalNumber(long value) {
        Triangulizer triangulizer = new Triangulizer();
        if(triangulizer.IsTriangleNumber(value))
        {
            PentagonalNumberizer pentagonalNumberizer = new PentagonalNumberizer();
            if(pentagonalNumberizer.IsPentagonalNumber(value))
            {
                HexagonalNumberizer hexagonalNumberizer = new HexagonalNumberizer();
                if(hexagonalNumberizer.IsHexagonalNumber(value))
                    return true;
            }
        }
        return false;
    }

    public long FindNextTriPentHexagonalNumberAfterHex(int hexStart) {
        HexagonalNumberizer hexagonalNumberizer = new HexagonalNumberizer();
        boolean go = true;
        long currentValue = 0;
        while(go)
        {
            currentValue =  hexagonalNumberizer.GetHexagonalNumberAt(hexStart);
            if(IsTriPentHexagonalNumber(currentValue))
                go = false;
            hexStart++;
        }
        return currentValue;
    }
}
