package FractionalMath;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: austin
 * Date: 8/25/12
 * Time: 11:09 AM
 * To change this template use File | Settings | File Templates.
 */
class BigFactorizer {


    public List<BigInteger> GetFactorsOf(BigInteger given) {
        List<BigInteger> toReturn = new ArrayList<BigInteger>();
        if(given.compareTo(BigInteger.ONE) >= 0)
        {
            toReturn.add(BigInteger.ONE);
        }
        if(given.compareTo(new BigInteger("2")) == 0)
        {
            toReturn.add(new BigInteger("2"));
        }

        for(BigInteger i = new BigInteger("2"); (i.divide(new BigInteger("2")).add(new BigInteger("2")).compareTo(given) <= 0); i = i.add(BigInteger.ONE))
        {
            if(given.remainder(i).compareTo(BigInteger.ZERO) == 0) toReturn.add(i);
        }
        return toReturn;
    }
}
