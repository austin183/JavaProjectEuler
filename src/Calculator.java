import java.io.*;
import java.math.BigInteger;
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
    
    public int GetSmallestNumberDivisibleByAllNumbersBelowNumber(int allNumbersBelow)
    {
        int candidate = allNumbersBelow * (allNumbersBelow - 1) - 1;
        boolean haveNotFoundGoodCandidate = true;
        while(haveNotFoundGoodCandidate)
        {
            candidate ++;
            haveNotFoundGoodCandidate = false;
            for(int i = 1; i <= allNumbersBelow; i++)
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
            String DIGIT_STRING = "C:\\Temp\\PrimeWork\\1000DigitString.txt";
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

    public long GetLargestPrimeFactor(long maxValue) {
        PrimeFactorizer PrimeFactorizer = new PrimeFactorizer();

        return  PrimeFactorizer.GetLargestPrimeFactor(maxValue);
    }

    public int GetHighestProductOfValuesInGrid(Gridizer gridizer, int sequenceSize) {
        int toReturn = 0;
        for(int x = 0; x < gridizer.GetGrid().size(); x++)
        {
            for (int y = 0; y < gridizer.GetGrid().get(x).size(); y++)
            {
                int productDown = gridizer.GetProductDown(x, y, sequenceSize);
                int productRight = gridizer.GetProductRight(x, y, sequenceSize);
                int productDownAndRight = gridizer.GetProductDownAndRight(x, y, sequenceSize);
                int productDownAndLeft = gridizer.GetProductDownAndLeft(x, y, sequenceSize);
                
                if(productDown > toReturn) toReturn = productDown;
                if(productRight > toReturn) toReturn = productRight;
                if(productDownAndRight > toReturn) toReturn = productDownAndRight;
                if(productDownAndLeft > toReturn) toReturn = productDownAndLeft;
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
        
        while(currentNumDivisors < numDivisors)
        {
            triangleNumber = triangulizer.GetTriangleNumberAt(triangleIndex);
            currentNumDivisors = factorizer.GetNumberFactorsOf(triangleNumber);
            
            triangleIndex++;
            if(triangleIndex % 100 == 0)
            {
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
}
