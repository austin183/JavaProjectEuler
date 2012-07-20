import java.util.ArrayList;
import java.util.List;

/**
 * Go IntelliJ IDEA!
 * User: Austin
 * Date: 5/15/12
 * Time: 6:12 PM
 */
class SubstitutePrimeFinder {
    private final PrimeFactorizer _factorizer;
    public SubstitutePrimeFinder(PrimeFactorizer factorizer) {
        _factorizer = factorizer;
    }

    public int GetHighestNumberPrimesFromSubstitution(int subValue) {

        if(!_factorizer.IsKnownPrime(subValue)) return 0;
        List<Integer> values = GetListOfValues(subValue);
        List<Integer> primeList;
        if(values.size() == 1) return 1;
        int count = 0;
        for(int i = 0; values.size() > Integer.toBinaryString(i + 1).length(); i++)
        {
            primeList = new ArrayList<Integer>();
            int j = 0;

            while(j <= 9)
            {
                List<Integer> currentValues =  SetValues(values, i, j);
                int currentValue = GetIntFromList(currentValues);
                if(_factorizer.IsKnownPrime(currentValue)
                        && Integer.toString(currentValue).length() == Integer.toString(subValue).length())
                {
                    if(!primeList.contains(currentValue))
                        primeList.add(currentValue);
                }

                j++;
            }
            if(primeList.size() > count && primeList.contains(subValue))
                count = primeList.size();
            primeList.clear();
        }
        return count;
    }

    List<Integer> SetValues(List<Integer> values, int pattern, int value) throws ArrayIndexOutOfBoundsException
    {
        List<Integer> toReturn = new ArrayList<Integer>(values);
        String onOff = Integer.toBinaryString(pattern + 1);
        StringBuilder buffer = new StringBuilder(onOff);
        onOff = buffer.reverse().toString();
        for(int i = 0; i < onOff.length(); i++)
        {
            if(onOff.substring(i, i + 1).equals("1")) toReturn.set(i, value);
        }
        return toReturn;
    }

    private int GetIntFromList(List<Integer> values) {
        String temp = "";
        for(int i: values)
        {
            temp += Integer.toString(i);
        }
        return Integer.parseInt(temp);
    }

    private List<Integer> GetListOfValues(int subValue) {
        List<Integer> toReturn = new ArrayList<Integer>();
        String value = Integer.toString(subValue);
        for(int i = 0; i < value.length(); i++)
        {
            toReturn.add(Integer.parseInt(value.substring(i, i+1)));
        }
        return toReturn;
    }

}
