import junit.framework.Assert;
import org.junit.Test;

import java.math.BigInteger;

/**
 * Created by IntelliJ IDEA.
 * User: Austin
 * Date: 2/10/12
 * Time: 9:32 PM
 * To change this template use File | Settings | File Templates.
 */
public class FactorializerTest {
    @Test
    public void ShouldGetFactoriall5() {
        int factorialize = 5;
        BigInteger expected = new BigInteger("120");

        Factorializer factorializer = new Factorializer();
        BigInteger result = factorializer.Factorialize(factorialize);

        Assert.assertEquals(expected, result);
    }

    @Test
    public void ShouldGetFactoriallSmallNumber5() {
        int factorialize = 5;
        int expected = 120;

        Factorializer factorializer = new Factorializer();
        int result = factorializer.FactorializeSmallNumber(factorialize);

        Assert.assertEquals(expected, result);
    }

    @Test
    public void ShouldGetFactorial400() {
        int factorialize = 400;
        Factorializer factorializer = new Factorializer();

        BigInteger result = factorializer.Factorialize(factorialize);

        Assert.assertEquals(new BigInteger("64034522846623895262347970319503005850702583026002959458684445942802397169186831436278478647463264676294350575035856810848298162883517435228961988646802997937341654150838162426461942352307046244325015114448670890662773914918117331955996440709549671345290477020322434911210797593280795101545372667251627877890009349763765710326350331533965349868386831339352024373788157786791506311858702618270169819740062983025308591298346162272304558339520759611505302236086810433297255194852674432232438669948422404232599805551610635942376961399231917134063858996537970147827206606320217379472010321356624613809077942304597360699567595836096158715129913822286578579549361617654480453222007825818400848436415591229454275384803558374518022675900061399560145595206127211192918105032491008000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000"), result);
    }

    @Test
    public void ShouldGetSumOfDigitsInFactorial() {
        int factorialize = 100;
        Factorializer factorializer = new Factorializer();

        int result = factorializer.GetSumOfDigitsInFactorialization(factorialize);

        Assert.assertEquals(648, result);
    }

    @Test
    public void ShouldGetSumOfFactorialsOfDigitsInNumber() {
        int candidate = 145;
        int expected = 145;

        Factorializer factorializer = new Factorializer();
        int result = factorializer.GetSumOfFactorialsOfDigitsInNumber(candidate);

        Assert.assertEquals(expected, result);
    }

    @Test
    public void ShouldGetSumOfAllNumbersWhichAreEqualToSumOfFactorialsOfDigitsInNumber() {
        int expected = 40730;

        Factorializer factorializer = new Factorializer();
        int result = factorializer.GetSumOfAllNumbersWhichAreEqualToSumOfFactorialsOfDigitsInNumber();

        Assert.assertEquals(expected, result);
    }
}
