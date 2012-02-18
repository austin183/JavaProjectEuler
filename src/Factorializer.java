import java.math.BigInteger;

/**
 * Created by IntelliJ IDEA.
 * User: Austin
 * Date: 2/10/12
 * Time: 9:32 PM
 * To change this template use File | Settings | File Templates.
 */
class Factorializer {
    public BigInteger Factorialize(int factorialize) {
        BigInteger toReturn = BigInteger.ONE;
        for(int n = 1; n <= factorialize; n++)
        {
            toReturn = toReturn.multiply(new BigInteger(Integer.toString(n)));
        }
        return toReturn;
    }

    public int GetSumOfDigitsInFactorialization(int factorialize) {
        String digits = Factorialize(factorialize).toString();
        int toReturn = 0;
        for (int i = 0; i < digits.length(); i++)
        {
            toReturn += Integer.parseInt(digits.substring(i, i+1));
        }
        return toReturn;
    }
}
