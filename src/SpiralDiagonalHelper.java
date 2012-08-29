import java.util.ArrayList;
import java.util.List;

/**
 * Go IntelliJ IDEA!
 * User: Austin
 * Date: 3/18/12
 * Time: 2:21 PM
 */
class SpiralDiagonalHelper {


    public int GetSumDiagonalsPointsAtLevel(int level) {
        return ((4 * (level * level)) - (6 * level) + 6);
    }


    public int GetSumOffullDiagonalsToLevel(int level) {
        int sum = 0;
        for (int i = 1; i <= level; i += 2) {
            sum += GetSumDiagonalsPointsAtLevel(i);
        }
        return sum - 3;
    }

    public int GetSideLengthAtLevel(int level) {
        return (level + 1) * 2 -1;
    }

    public List<Integer> GetDiagonalsAtLevel(int level) {
        List<Integer> toReturn = new ArrayList<Integer>(4);
        toReturn.add((int) Math.pow((2 * level) + 1, 2));
        toReturn.add(toReturn.get(0) - (2 * level));
        toReturn.add(toReturn.get(1) - (2 * level));
        toReturn.add(toReturn.get(2) - (2 * level));

        return toReturn;
    }

    private int GetCountOfPrimeCorners(int level, PrimeFactorizer factorizer)
    {
        int toReturn = 0;
        List<Integer> diagonalsAtLevel = GetDiagonalsAtLevel(level);
        if(factorizer.IsPrime(diagonalsAtLevel.get(0), factorizer.HasNoCache()))
        {
            toReturn++;
        }
        if(factorizer.IsPrime(diagonalsAtLevel.get(1), factorizer.HasNoCache()))
        {
            toReturn++;
        }
        if(factorizer.IsPrime(diagonalsAtLevel.get(2), factorizer.HasNoCache()))
        {
            toReturn++;
        }
        if(factorizer.IsPrime(diagonalsAtLevel.get(3), factorizer.HasNoCache()))
        {
            toReturn++;
        }
        return toReturn;
    }

    public int GetCountOfNumbersAlongDiagonalAtLevel(int level) {
        return (level * 4) + 1;
    }

    public double GetDiagonalPrimeRatiosAtLevel(int level) {
        PrimeFactorizer factorizer = new PrimeFactorizer();
        double ratio = 0;

        int numerator = 0;

        for(int i = 1; i <= level; i++)
        {
            numerator += GetCountOfPrimeCorners(i, factorizer);
            int denominator = GetCountOfNumbersAlongDiagonalAtLevel(i);
            ratio = (double)numerator / (double)denominator;
        }
        return ratio;
    }


    public int FindSideLengthOfLevelWhereRatioOfPrimesInDiagonalsFallsBelow10Percent(double threshold) {
        double ratio = 1;
        int currentLevel = 0;
        int numerator = 0;

        SupportFiles files = new SupportFiles();

        PrimeFactorizer factorizer = new PrimeFactorizer(files.Location + "PrimesUnder2million.txt");

        while (ratio >= threshold)
        {
            currentLevel++;

            numerator += GetCountOfPrimeCorners(currentLevel, factorizer);
            int denominator = GetCountOfNumbersAlongDiagonalAtLevel(currentLevel);
            ratio = (double)numerator / (double)denominator;
        }
        return GetSideLengthAtLevel(currentLevel);
    }
}
