import junit.framework.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * Go IntelliJ IDEA!
 * User: Austin
 * Date: 3/18/12
 * Time: 10:53 PM
 */
public class CoinPermutizerTest {

    @Test
    public void ShouldPermute1Coin() {
        int target = 200;
        int expected = 1;

        List<Integer> coinList = new ArrayList<Integer>();
        coinList.add(1);

        CoinPermutizer permutizer = new CoinPermutizer(target, coinList);
        int result = permutizer.GetNumberPermutations();

        Assert.assertEquals(expected, result);

    }

    @Test
    public void ShouldPermute2Coins() {
        int target = 200;
        int expected = 2;

        List<Integer> coinList = new ArrayList<Integer>();
        coinList.add(1);
        coinList.add(200);

        CoinPermutizer permutizer = new CoinPermutizer(target, coinList);

        int result = permutizer.GetNumberPermutations();

        Assert.assertEquals(expected, result);
    }

    @Test
    public void ShouldPermute3Coins() {
        int target = 200;
        int expected = 4;

        List<Integer> coinList = new ArrayList<Integer>();
        coinList.add(1);
        coinList.add(100);
        coinList.add(200);

        CoinPermutizer permutizer = new CoinPermutizer(target, coinList);

        int result = permutizer.GetNumberPermutations();

        Assert.assertEquals(expected, result);
    }

    @Test
    public void ShouldPermute4Coins() {
        int target = 25;
        int expected = 13;

        List<Integer> coinList = new ArrayList<Integer>();
        coinList.add(1);
        coinList.add(5);
        coinList.add(10);
        coinList.add(25);

        CoinPermutizer permutizer = new CoinPermutizer(target, coinList);

        int result = permutizer.GetNumberPermutations();

        Assert.assertEquals(expected, result);
    }

    @Test
    public void ShouldPermute8Coins() {
        int target = 200;
        int expected = 73682;

        List<Integer> coinList = new ArrayList<Integer>();
        coinList.add(1);
        coinList.add(2);
        coinList.add(5);
        coinList.add(10);
        coinList.add(20);
        coinList.add(50);
        coinList.add(100);
        coinList.add(200);

        CoinPermutizer permutizer = new CoinPermutizer(target, coinList);

        int result = permutizer.GetNumberPermutations();

        Assert.assertEquals(expected, result);
    }

}
