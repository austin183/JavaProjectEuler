import java.io.*;
import java.math.BigInteger;

/**
 * Created by IntelliJ IDEA.
 * User: Austin
 * Date: 1/30/12
 * Time: 9:31 PM
 * To change this template use File | Settings | File Templates.
 */
class Calculator {
    private final String DIGIT_STRING = "C:\\Temp\\PrimeWork\\1000DigitString.txt";

    public int CalculateSumFromMultiplesUnderMaxValue(int[] multiples, int maxValue) {
        int toReturn = 0;
        for(int i = 2; i < maxValue; i++)
        {
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

        while(second < maxValue)
        {
            if(first == start1 && start1 % 2 == 0)
                toReturn += first;
            if(second % 2 == 0)
                toReturn += second;

            int swapper = second;
            second = first + second;
            first = swapper;
        }
        return toReturn;
    }


    
    public int GetLargestPalindromeByTwoNumbersXDigits(int digits)
    {
        int toReturn = 0;

        int maxValue = (int) ((int) Math.pow((double)10, (double)digits) - (double)1);
        int minValue = (int) Math.pow((double)10, (double)digits - 1);
        Palindromizer palindromizer = new Palindromizer();
        
        for(int i = minValue; i <= maxValue; i++)
        {
            for (int j = minValue; j <= maxValue; j++)
            {
                int candidate = j * i;
                if(candidate > toReturn && palindromizer.IsPalindrome(candidate) )
                    toReturn = candidate;
            }
        }
        
        return toReturn;
    }
    
    public int GetSmallestNumberDivisibleByAllNumbersBelowNumber(int allNumberBelow)
    {
        int candidate = allNumberBelow * (allNumberBelow - 1) - 1;
        boolean haveNotFoundGoodCandidate = true;
        while(haveNotFoundGoodCandidate)
        {
            candidate ++;
            haveNotFoundGoodCandidate = false;
            for(int i = 1; i <= allNumberBelow; i++)
            {
                if(candidate % i != 0)
                {
                    haveNotFoundGoodCandidate = true;
                    break;
                }
            }
        }
        return candidate;
    }
    
    public int GetDifferenceBetweenSumOfSquaresAndSquareOfSumForFirstNnumbers(int allNumbersAtOrBelow)
    {
        int sumOfSquares = 0;
        int squareOfSum = 0;
        
        for(int i = 1; i <= allNumbersAtOrBelow; i++)
        {
            sumOfSquares += Math.pow((double)i, (double)2);
            squareOfSum += i;
        }
        squareOfSum = (int) Math.pow(squareOfSum, 2);

        return squareOfSum - sumOfSquares;
    }

    public int GetHighestProductof5DigitsInAStringOfConsecutiveDigits() {
        int highestValue = 0;
        FileInputStream fileInputStream = null;
        try {
            fileInputStream = new FileInputStream(DIGIT_STRING);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        DataInputStream in = new DataInputStream(fileInputStream);
        BufferedReader reader = new BufferedReader(new InputStreamReader(in));
        String line;
        try {
            while((line = reader.readLine()) != null)
            {

                for(int i = 0; i < line.length() - 5; i++)
                {
                    int product = GetProductOfDigits(line.substring(i, i + 5));
                    if(highestValue < product)
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
        for(int i = 0; i< substring.length(); i++)
        {
            toReturn *= Integer.parseInt(substring.substring(i, i + 1));
        }
        return toReturn;
    }

    public PythagoreanTriplet GetFirstPythagoreanTripletThatSumsTo(int value) {
        Pythagorizer pythagorizer = new Pythagorizer();
        for(int a = 1; a < value; a++)
        {
            for (int b = 1; b < value; b++)
            {
                for(int c = 1; c < value; c++)
                {
                    if(a + b + c == value && pythagorizer.IsTriplet(a, b, c))
                        return new PythagoreanTriplet(a, b, c);
                }
            }
        }
        return null;
    }

    public long GetSumPrimesUnderMaxValue(int maxValue) {

        PrimeFactorizer PrimeFactorizer = new PrimeFactorizer();

        return PrimeFactorizer.GetSumPrimesUnderMaxValue(maxValue);
    }

    public BigInteger GetLargestPrimeFactor(BigInteger maxValue) {
        BigInteger toReturn;
        BigIntPrimeFactorizer bigIntPrimeFactorizer = new BigIntPrimeFactorizer();

        toReturn =  bigIntPrimeFactorizer.GetLargestKnownPrimeFactorForValuesUnderMaxKnownPrime(maxValue);
        if(toReturn != null) return toReturn;

        return bigIntPrimeFactorizer.GetLargetPrimeFactorOverMaxKnowPrime(maxValue);
    }
}
