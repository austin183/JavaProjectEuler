import java.util.List;

/**
 * Go IntelliJ IDEA!
 * User: Austin
 * Date: 5/18/12
 * Time: 8:37 AM
 */
public class ListManipulator {

    public void Swap(List<Integer> toPermute, int i, int k) {
        int temp = toPermute.get(i);
        toPermute.set(i, toPermute.get(k));
        toPermute.set(k, temp);
    }

    public void Reverse(List<Integer> toPermute, int start)
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
