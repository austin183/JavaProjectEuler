/**
 * Created with IntelliJ IDEA.
 * User: austin
 * Date: 7/19/12
 * Time: 10:38 PM
 * To change this template use File | Settings | File Templates.
 */
class NumbersWithSameDigitsInMultiplesFinder {

    public int FindSmallestPositiveIntegerForMultiplesUpToX(int x)
    {
        int i = 1;

        while(i < Integer.MAX_VALUE)
        {
            if(VerifyThatAllDigitsInXAreContainedInMultiplesUpTo(i, x))
                return i;
            i++;
        }
        return 0;
    }

    public boolean VerifyThatAllDigitsInXAreContainedInMultiplesUpTo(int x, int upTo) {
        for(int i = 2; i <= upTo; i++)
        {
            if(!AllDigitsExistFromXInY(x, i * x))
                return false;
        }
        return true;
    }

    private boolean AllDigitsExistFromXInY(int x, int y) {
        String xDigits = Integer.toString(x);
        String yDigits = Integer.toString(y);

        if(xDigits.length() != yDigits.length()) return false;

        for(int i = 0; i < xDigits.length(); i++)
        {

            int indexOfY = yDigits.indexOf(xDigits.charAt(i));
            if (indexOfY == -1) {
                return false;
            }
            yDigits = yDigits.substring(0, indexOfY) + yDigits.substring(indexOfY + 1, yDigits.length());
        }
        return true;
    }
}
