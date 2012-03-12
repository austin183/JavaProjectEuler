import java.util.ArrayList;
import java.util.List;

/**
 * Go IntelliJ IDEA!
 * User: Austin
 * Date: 3/12/12
 * Time: 8:34 AM
 */
class RecurringCycleFinder {
    public int FindCycleLength(int input) {
        int remainder = 1;
        int currentLength = 0;
        List<Integer> remainderList = new ArrayList<Integer>();
        do {
            currentLength++;
            remainderList.add(remainder);

            remainder = (remainder * 10) % input;
            if (remainder == 0) {
                currentLength = 0;
            }
            if (remainderList.contains(remainder)) {
                return currentLength - remainderList.indexOf(remainder);
            }
        } while (remainder > 1);
        return currentLength;
    }
}
