/**
 * Go IntelliJ IDEA!
 * User: Austin
 * Date: 2/4/12
 * Time: 11:57 AM
 */
class Palindromizer {
    public boolean IsPalindrome(int candidate) {
        String sCanditate = String.valueOf(candidate);
        return IsPalindromeString(sCanditate);
    }

    public boolean IsBinaryPalindrome(int candidate) {
        String sBinCandidate = Integer.toBinaryString(candidate);
        return IsPalindromeString(sBinCandidate);
    }

    private boolean IsPalindromeString(String sCanditate) {
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
