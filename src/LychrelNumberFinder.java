import java.math.BigInteger;

/**
 * Created with IntelliJ IDEA.
 * User: austin
 * Date: 8/3/12
 * Time: 6:43 PM
 * To change this template use File | Settings | File Templates.
 */
class LychrelNumberFinder {
    public boolean IsLychrel(BigInteger value) {
        Palindromizer palindromizer = new Palindromizer();
        BigInteger reverseValue;
        BigInteger newValue = value;
        for(int i = 0; i < 50; i++)
        {
            reverseValue = new BigInteger(new StringBuffer(newValue.toString()).reverse().toString());
            newValue = newValue.add(reverseValue);
            if(palindromizer.IsPalindromeString(newValue.toString()))
                return false;

        }
        return true;
    }


    public int FindLychrelNumbersBelowValue(int value) {
        int toReturn = 0;

        for(int i = 1; i <= value; i++)
        {
            if(IsLychrel(new BigInteger(Integer.toString(i))))
                toReturn++;
        }
        return toReturn;
    }
}
