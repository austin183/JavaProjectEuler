import java.math.BigInteger;

/**
 * Created with IntelliJ IDEA.
 * User: austin
 * Date: 8/3/12
 * Time: 7:48 PM
 * To change this template use File | Settings | File Templates.
 */
class MaximumDigitalSumizer {
    public int GetDigitalSum(int a, int b) {
        int toReturn = 0;
        String  c = new BigInteger(Integer.toString(a)).pow(b).toString();
        for(int i = 0; i < c.length(); i++)
        {
            toReturn += Integer.parseInt(c.substring(i, i + 1));
        }
        return toReturn;
    }

    public int GetMaximumDigitalSumOfAToBUnder(int a, int b) {
        int toReturn = 0;
        for(int i = 1; i <= a; i++)
        {
            for(int j = 1; j<= b; j++)
            {
                int currentSum = GetDigitalSum(i, j);
                if(toReturn < currentSum)
                    toReturn = currentSum;
            }
        }
        return toReturn;
    }
}
