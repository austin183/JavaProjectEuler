import junit.framework.Assert;
import org.junit.Test;

import java.util.Dictionary;
import java.util.HashMap;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: austin
 * Date: 7/22/12
 * Time: 8:08 PM
 * To change this template use File | Settings | File Templates.
 */
public class PokerHandComparerTest {

    @Test
    public void ShouldParseHand()
    {
        String hand = "2C 3D 4H 6S 7H";

        Hand result = new Hand(hand);

        Assert.assertTrue(result.ContainsCard(new PlayingCard("2", "C")));
        Assert.assertTrue(result.ContainsCard(new PlayingCard("3", "D")));
        Assert.assertTrue(result.ContainsCard(new PlayingCard("4", "H")));
        Assert.assertTrue(result.ContainsCard(new PlayingCard("6", "S")));
        Assert.assertTrue(result.ContainsCard(new PlayingCard("7", "H")));
    }

    @Test
    public void ShouldReturnHandAsString()
    {
        String expected = "2C 3D 4H 6S 7H";
        Hand input = new Hand();
        input.AddCard("2", "C");
        input.AddCard("3", "D");
        input.AddCard("4", "H");
        input.AddCard("6", "S");
        input.AddCard("7", "H");

        String result = input.toString();
        Assert.assertEquals(expected, result);
    }

    @Test
    public void ShouldIdentifyHandAsSameSuit()
    {
        String hand = "TS KS QS JS AS";

        boolean expected = true;

        Hand thisHand = new Hand(hand);
        boolean result = thisHand.IsSameSuit();

        Assert.assertEquals(expected, result);
    }

    @Test
    public void ShouldFindTenOfAnySuit()
    {
        String hand = "TS KS QS JS AS";
        boolean expected = true;

        Hand thisHand = new Hand(hand);
        boolean result = thisHand.ContainsCardOfAnySuit("T");

        Assert.assertEquals(expected, result);
    }

    @Test
    public void ShouldNotFind2OfAnySuit()
    {
        String hand = "TS KS QS JS AS";
        boolean expected = false;

        Hand thisHand = new Hand(hand);
        boolean result = thisHand.ContainsCardOfAnySuit("2");

        Assert.assertEquals(expected, result);
    }

    @Test
    public void ShouldOrderHandByValue()
    {
        String hand = "3S 2S 5S 4S 2D";
        String expected1 = "2S 2D 3S 4S 5S";
        String expected2 = "2D 2S 3S 4S 5S";
        Hand result = new Hand(hand).OrderByValue();

        Assert.assertTrue((expected1.compareTo(result.toString()) == 0
                || expected2.compareTo(result.toString()) == 0));
    }

    @Test
    public void ShouldIdentifyHandAsNotConsecutive()
    {
        String hand = "AS 2S 3S 4S 6S";
        boolean expected = false;

        Hand thisHand = new Hand(hand);
        boolean result = thisHand.IsConsecutive();

        Assert.assertEquals(expected, result);
    }


    @Test
    public void ShouldIdentifyHandAsConsecutive()
    {
        String hand = "5S 2S 3S 4S 6S";
        boolean expected = true;

        Hand thisHand = new Hand(hand);
        boolean result = thisHand.IsConsecutive();

        Assert.assertEquals(expected, result);
    }

    @Test
    public void ShouldIdentifyHandWithAceAsBeginningAsConsecutive()
    {
        String hand = "AS 2S 3S 4S 5S";
        boolean expected = true;

        Hand thisHand = new Hand(hand);
        boolean result = thisHand.IsConsecutive();

        Assert.assertEquals(expected, result);
    }

    @Test
    public void ShouldIdentifyHandAsHavingFourTwosAndOneAce()
    {
        String hand = "AS 2S 2H 2D 2C";
        Hand thisHand = new Hand(hand);

        Map<String, Integer> expected = new HashMap<String, Integer>();
        expected.put("2", 4);
        expected.put("A", 1);

        Map<String, Integer> result = thisHand.GetNumberOfKinds();

        Assert.assertEquals(expected, result);
    }

    @Test
    public void ShouldIdentifyHighestSingleCardInHand()
    {
        String hand = "2S 3S 4S AS 5S";
        String expected = "A";

        Hand thisHand = new Hand(hand);
        String result = thisHand.GetHighestSingleCardInHand();

        Assert.assertEquals(expected, result);
    }

    @Test
    public void ShouldIdentifyHandAsRoyalFlush()
    {
        String hand = "TS KS QS JS AS";

        boolean expected = true;

        PokerHandComparer comparer = new PokerHandComparer();
        boolean result = comparer.IsRoyalFlush(hand);

        Assert.assertEquals(expected, result);
    }

    @Test
    public void ShouldIdentifyHandAsStraightFlush()
    {
        String hand = "2S 3S 4S 5S AS";

        boolean expected = true;

        PokerHandComparer comparer = new PokerHandComparer();
        boolean result = comparer.IsStraightFlush(hand);

        Assert.assertEquals(expected, result);
    }

    @Test
    public void ShouldIdentifyNoFourOfAKinds()
    {
        String hand = "2S 2D 3H 2C AS";

        String expected = "";

        PokerHandComparer comparer = new PokerHandComparer();
        String result = comparer.FourOfAKind(hand);

        Assert.assertEquals(expected, result);
    }

    @Test
    public void ShouldIdentifyFourOfAKindOf2s()
    {
        String hand = "2S 2D 2H 2C AS";

        String expected = "2";

        PokerHandComparer comparer = new PokerHandComparer();
        String result = comparer.FourOfAKind(hand);

        Assert.assertEquals(expected, result);
    }

    @Test
    public void ShouldIdentifyFourOfAKindOfAces()
    {
        String hand = "2S AD AH AC AS";

        String expected = "A";

        PokerHandComparer comparer = new PokerHandComparer();
        String result = comparer.FourOfAKind(hand);

        Assert.assertEquals(expected, result);
    }

    @Test
    public void ShouldIdentifyThreeOfAKindOfAces()
    {
        String hand = "2S 3S AS AD AC";

        String expected = "A";

        PokerHandComparer comparer = new PokerHandComparer();
        String result = comparer.ThreeOfAKind(hand);

        Assert.assertEquals(expected, result);
    }

    @Test
    public void ShouldIdentifyPairOfAces()
    {
        String hand = "2S 3S 4S AD AC";

        String expected = "A";

        PokerHandComparer comparer = new PokerHandComparer();
        String result = comparer.OnePair(hand);

        Assert.assertEquals(expected, result);
    }

    @Test
    public void ShouldIdentifyTwoPairAcesAnd2s()
    {
        String hand = "2S AS 3D 2C AD";

        String expected1 = "2A";
        String expected2 = "A2";

        PokerHandComparer comparer = new PokerHandComparer();
        String result = comparer.TwoPair(hand);

        Assert.assertTrue(result.equals(expected1) || result.equals(expected2));
    }

    @Test
    public void ShouldIdentifyFlush()
    {
        String hand = "2S 4S 6S 8S TS";
        boolean  expected = true;

        PokerHandComparer comparer = new PokerHandComparer();
        boolean result = comparer.IsFlush(hand);

        Assert.assertEquals(expected, result);
    }

    @Test
    public void ShouldIdentifyStraight()
    {
        String hand = "2S 3C 4D 5D 6D";
        boolean expected = true;

        PokerHandComparer comparer = new PokerHandComparer();
        boolean  result = comparer.IsStraight(hand);

        Assert.assertEquals(expected, result);
    }

    @Test
    public void ShouldIdentifyFullHouse()
    {
        String hand = "2D 3D 2S 3S 2C";
        String expected1 = "23";
        String expected2 = "32";

        Assert.assertTrue(false);
    }

}
