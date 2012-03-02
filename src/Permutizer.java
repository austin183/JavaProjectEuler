import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Go IntelliJ IDEA!
 * User: Austin
 * Date: 2/18/12
 * Time: 6:30 PM
 */
public class Permutizer {
    public List<String> Permute(String permuteThis)
    {
        List<Integer> toPermute = new ArrayList<Integer>();
        for(int i = 0; i < permuteThis.length(); i++)
        {
            toPermute.add(Integer.parseInt(permuteThis.substring(i, i+1)));
        }

        return Permute(toPermute);
    }

    private List<String> Permute(List<Integer> toPermute) {
        List<String> toReturn = new ArrayList<String>();
        Collections.sort(toPermute);
        
        for(int i = 0; i < toPermute.size(); i++)
        {

        }
        return null;
    }
}
