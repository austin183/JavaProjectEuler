/**
 * Created by IntelliJ IDEA.
 * User: Austin
 * Date: 2/4/12
 * Time: 11:57 AM
 * To change this template use File | Settings | File Templates.
 */
class Palindromizer {
    public boolean IsPalindrome(int candidate) {
        String sCanditate = String.valueOf(candidate);
        int start = 0;
        int end = sCanditate.length() - 1;
        while (start <= (sCanditate.length() / 2) && end >= (sCanditate.length() / 2)) {
            if (sCanditate.substring(start, start + 1).compareTo(sCanditate.substring(end, end + 1)) != 0)
                return false;
            start++;
            end--;
        }
        return true;
    }
}
