import java.util.ArrayList;
import java.util.List;

/**
 * Go IntelliJ IDEA!
 * User: Austin
 * Date: 5/9/12
 * Time: 9:52 PM
 */
class PermutativePrimeFinder
{
    public String IsPermutativePrimeIncreasingSeries(int value) {
        Permutizer permutizer = new Permutizer();
        PrimeFactorizer primeFactorizer = new PrimeFactorizer();

        List<Integer> primes = new ArrayList<Integer>();
        String currentValue = Integer.toString(value);
        do{
            if(primeFactorizer.IsPrime(Integer.parseInt(currentValue), true))
                primes.add(Integer.parseInt(currentValue));
            currentValue = permutizer.GetNextPermutation(currentValue);
        }while(!currentValue.equals(""));

        if(primes.size() >= 3)
        {
            for(int i = primes.size() - 1; i >= 0; i--)
            {
                for(int j = i - 1; j >= 0; j--)
                {
                    int difference = primes.get(i) - primes.get(j);
                    if(primes.contains(primes.get(j) - difference))
                        return Integer.toString(primes.get(j) - difference)
                                + Integer.toString(primes.get(j))
                                + Integer.toString(primes.get(i));
                }
            }
        }
        return "";
    }
}
