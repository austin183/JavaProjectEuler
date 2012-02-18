import java.util.ArrayList;
import java.util.Dictionary;
import java.util.Hashtable;
import java.util.List;

/**
 * Go IntelliJ IDEA!
 * User: Austin
 * Date: 2/18/12
 * Time: 2:45 PM
 */
class AmicablePairizer {
    private final Dictionary<Integer, Integer> SumProperDivisors;
    public AmicablePairizer()
    {
        SumProperDivisors = new Hashtable<Integer, Integer>();
    }
    public int GetSumOfProperDivisors(int toTest) {
        if(SumProperDivisors.get(toTest) != null) return SumProperDivisors.get(toTest);

        Factorizer factorizer = new Factorizer();
        List<Integer> factors = factorizer.GetFactorsOf(toTest);
        int toReturn = 0;

        for(int factor : factors)
        {
            toReturn += factor;
        }
        return toReturn;
    }

    public boolean IsAmicablePair(int first, int second) {
        return first != second && (GetSumOfProperDivisors(first) == second && GetSumOfProperDivisors(second) == first);
    }

    public int GetSumOfAmicableNumbersUnder(int toTest) {
        int toReturn = 0;
        BuildSumOfDivisorsForTestSet(toTest);
        List<Integer> amicableNumbers = new ArrayList<Integer>();
        for(int i = 1; i< toTest; i++)
        {
            for(int j= 1; j< toTest; j++)
            {
                if(IsAmicablePair(i, j))
                {
                    if(!amicableNumbers.contains(i)) amicableNumbers.add(i);
                    if(!amicableNumbers.contains(j)) amicableNumbers.add(j);
                }
            }
        }
        for(int number : amicableNumbers)
        {
            toReturn += number;
        }
        return toReturn;
    }

    private void BuildSumOfDivisorsForTestSet(int toTest) {
        for(int i = 1; i < toTest; i++)
        {
            SumProperDivisors.put(i, GetSumOfProperDivisors(i));
        }
    }
}
