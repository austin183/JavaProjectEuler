import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Go IntelliJ IDEA!
 * User: Austin
 * Date: 2/8/12
 * Time: 12:48 PM
 */
class Factorizer {

    public int GetNumberFactorsOf(long numberToTest) {
        int numFactors = 1;
        Map<Long, Integer> factorOccurrences = GetNumberOccurrencesOfPrimes(numberToTest);

        for (int i : factorOccurrences.values()) {
            numFactors *= i + 1;
        }
        return numFactors;
    }

    public int GetNumberPrimeFactorsOf(long numberToTest) {
        Map<Long, Integer> factorOccurrences = GetNumberOccurrencesOfPrimes(numberToTest);
        return factorOccurrences.keySet().size();
    }

    Map<Long, Integer> GetNumberOccurrencesOfPrimes(long numberToTest) {
        Map<Long, Integer> toReturn = new HashMap<Long, Integer>();
        for (long i = 2; i < numberToTest; i++) {
            if (numberToTest % i == 0) {
                if (toReturn.containsKey(i))
                    toReturn.put(i, toReturn.get(i) + 1);
                else toReturn.put(i, 1);

                numberToTest = numberToTest / i;
                i = 1;
            }
        }
        if (numberToTest > 1) {
            if (toReturn.containsKey(numberToTest))
                toReturn.put(numberToTest, toReturn.get(numberToTest) + 1);
            else toReturn.put(numberToTest, 1);
        }
        return toReturn;
    }

    public List<Integer> GetFactorsOf(int toTest) {
        List<Integer> toReturn = new ArrayList<Integer>();
        for (int i = 1; i < (toTest / 2) + 2; i++) {
            if (toTest % i == 0) toReturn.add(i);
        }
        return toReturn;
    }
}
