import java.math.BigInteger;

/**
 * Created with IntelliJ IDEA.
 * User: austin
 * Date: 7/20/12
 * Time: 10:12 PM
 * To change this template use File | Settings | File Templates.
 */
class Combinatoricizer {

    public int Calculate_nCr(int n, int r) {
        Factorializer factorializer = new Factorializer();
        if(r == 0) return 1;

        return factorializer.FactorializeSmallNumber(n) / (factorializer.FactorializeSmallNumber(r) * factorializer.FactorializeSmallNumber(n - r));
    }

    public BigInteger Calculate_Big_nCr(int n, int r)
    {
        Factorializer factorializer = new Factorializer();

        return factorializer.Factorialize(n).divide(factorializer.Factorialize(r).multiply(factorializer.Factorialize(n - r)));
    }

    public int FindCountOfValuesForFor_n_1Thru100Where_nCr_ValueIsGreaterThan1Million() {
        int count = 0;

        for(int n = 1; n <= 100; n++)
        {
            for(int r = 1; r <= n; r++)
            {
                BigInteger value = Calculate_Big_nCr(n, r);
                if(value.compareTo(new BigInteger("1000000")) > 0)
                    count ++;
            }
        }
        return count;
    }
}
