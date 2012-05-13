import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Go IntelliJ IDEA!
 * User: Austin
 * Date: 2/18/12
 * Time: 6:30 PM
 */
class Permutizer {
    public List<String> Permute(String permuteThis) {
        List<Integer> toPermute = GetIntList(permuteThis);

        return Permute(toPermute);
    }

    private List<Integer> GetIntList(String permuteThis) {
        List<Integer> toPermute = new ArrayList<Integer>();
        for (int i = 0; i < permuteThis.length(); i++) {
            toPermute.add(Integer.parseInt(permuteThis.substring(i, i + 1)));
        }
        return toPermute;
    }

    public String GetNthPermutation(String permuteThis, int n) {
        List<Integer> toPermute = GetIntList(permuteThis);
        Collections.sort(toPermute);
        for (int i = 0; i < n; i++)
            toPermute = GetNextResult(toPermute);
        return GetStringValue(toPermute);
    }

    private List<String> Permute(List<Integer> toPermute) {
        List<String> toReturn = new ArrayList<String>();
        Collections.sort(toPermute);
        String permutation = GetStringValue(toPermute);

        while (!permutation.equals("")) {
            toReturn.add(permutation);
            List<Integer> nextPermutation = GetNextResult(toPermute);
            permutation = GetStringValue(nextPermutation);
        }
        return toReturn;
    }

    public String GetNextPermutation(String permuteThis) {
        List<Integer> toPermute = GetIntList(permuteThis);
        return GetStringValue(GetNextResult(toPermute));
    }

    public String GetPreviousPermutation(String permuteThis) {
        List<Integer> toPermute = GetIntList(permuteThis);
        return GetStringValue(GetPreviousResult(toPermute));
    }

    private List<Integer> GetPreviousResult(List<Integer> toPermute) {
        if(toPermute.size() < 2) return new ArrayList<Integer>();

        int i = toPermute.size() - 2;
        int i1 = toPermute.size() - 1;

        while(true)
        {
            if(toPermute.get(i) > toPermute.get(i1))
            {
                int j = toPermute.size() - 1;
                while (!(toPermute.get(i) > toPermute.get(j)))
                    j--;
                Swap(toPermute, i, j);
                Reverse(toPermute, i1);
                return toPermute;
            }
            if(i == 0)
            {
                return new ArrayList<Integer>();
            }
            i--;
            i1--;
        }
    }

    //Thank you MyCareerStack!
    //http://www.mycareerstack.com/codes/15/permutation-with-duplicates/
    private List<Integer> GetNextResult(List<Integer> toPermute) {
        if(toPermute.size() < 2) return new ArrayList<Integer>();

        int i = toPermute.size() - 2;
        int i1 = toPermute.size() - 1;

        while(true)
        {
            if(toPermute.get(i) < toPermute.get(i1))
            {
                int j = toPermute.size() - 1;
                while (!(toPermute.get(i) < toPermute.get(j)))
                    j--;
                Swap(toPermute, i, j);
                Reverse(toPermute, i1);
                return toPermute;
            }
            if(i == 0)
            {
                return new ArrayList<Integer>();
            }
            i--;
            i1--;
        }
    }

    private void Swap(List<Integer> toPermute, int i, int k) {
        int temp = toPermute.get(i);
        toPermute.set(i, toPermute.get(k));
        toPermute.set(k, temp);
    }

    private String GetStringValue(List<Integer> intList) {
        String toReturn = "";
        for (Integer number : intList) {
            toReturn += number.toString();
        }
        return toReturn;
    }

    void Reverse(List<Integer> toPermute, int start)
    {
        int end = toPermute.size() - 1;
        while(start < end)
        {
            Swap(toPermute, start, end);
            start++;
            end--;
        }

    }
}
