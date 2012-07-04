import java.util.ArrayList;
import java.util.List;

/**
 * Go IntelliJ IDEA!
 * User: Austin
 * Date: 5/15/12
 * Time: 6:12 PM
 */
public class SubstitutePrimeFinder {

    public int GetHighestNumberPrimesFromSubstitution(int subValue) {
        PrimeFactorizer factorizer = new PrimeFactorizer("C:\\Temp\\ProjectEuler\\PrimesUnder1million.txt");
        if(!factorizer.IsKnownPrime(subValue)) return 0;
        List<Integer> values = GetListOfValues(subValue);
        if(values.size() == 1) return 1;
        int count = 0;
        for(int i = 0; i < values.size() - 1; i++)
        {
            int currentCount = 0;
            int j = 0;
            if(i == 0) j = 1;

            while(j <= 9)
            {
                List<Integer> currentValues =  SetValues(values, i, j);
                if(factorizer.IsKnownPrime(GetIntFromList(currentValues)))
                    currentCount++;
                j++;
            }
            if(currentCount > count)
                count = currentCount;
        }
        return count;
    }

    public List<Integer> SetValues(List<Integer> values, int pattern, int value)
    {
        List<Integer> toReturn = new ArrayList<Integer>(values);
        String onOff = Integer.toBinaryString(pattern + 1);
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
