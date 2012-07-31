import Poker.Hand;
import Poker.PlayingCard;
import Poker.PokerHandRank;
import Poker.PokerHandValue;
import junit.framework.Assert;
import org.junit.Test;

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
    public void ShouldRemoveAllCardsWithValueOf2()
    {
        Hand hand = new Hand("2C 2S 2D 2H 3C");
        String expected = "3C";

        hand.RemoveAllCardsOfValue("2");
        String result = hand.toString();

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
    public void ShouldIdentifyA2KHandAsNotConsecutive()
    {
        String hand = "AD AH 2C 2C KS";
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
    public void ShouldIdentifyHandAsStraightFlushWith5AsHighValue()
    {
        String hand = "2S 3S 4S 5S AS";

        String expected = "5";

        PokerHandComparer comparer = new PokerHandComparer();
        String result = comparer.IsStraightFlush(hand);

        Assert.assertEquals(expected, result);
    }

    @Test
    public void ShouldIdentifyHandAsStraightFlushWith6AsHighValue()
    {
        String hand = "2S 3S 4S 5S 6S";

        String expected = "6";

        PokerHandComparer comparer = new PokerHandComparer();
        String result = comparer.IsStraightFlush(hand);

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
        String  expected = "T";

        PokerHandComparer comparer = new PokerHandComparer();
        String result = comparer.IsFlush(hand);

        Assert.assertEquals(expected, result);
    }

    @Test
    public void ShouldNotIdentifyFlush()
    {
        String hand = "2S 4S 6S 8D TC";
        String expected = "";

        PokerHandComparer comparer = new PokerHandComparer();
        String result = comparer.IsFlush(hand);

        Assert.assertEquals(expected, result);
    }

    @Test
    public void ShouldIdentifyStraight()
    {
        String hand = "2S 3C 4D 5D 6D";
        String expected = "6";

        PokerHandComparer comparer = new PokerHandComparer();
        String  result = comparer.IsStraight(hand);

        Assert.assertEquals(expected, result);
    }

    @Test
    public void ShouldIdentifyFullHouse2sOver3s()
    {
        String hand = "2D 3D 2S 3S 2C";
        String expected1 = "23";

        PokerHandComparer comparer = new PokerHandComparer();
        String result = comparer.FullHouse(hand);

        Assert.assertEquals(expected1, result);
    }

    @Test
    public void ShouldIdentifyFullHouse3sOver2s()
    {
        String hand = "2D 3D 2S 3S 3C";
        String expected1 = "32";

        PokerHandComparer comparer = new PokerHandComparer();
        String result = comparer.FullHouse(hand);

        Assert.assertEquals(expected1, result);
    }

    @Test
    public void ShouldNotIdentifyFullHouse()
    {
        String hand = "2D 3D 2S 3S 4C";
        String expected1 = "";

        PokerHandComparer comparer = new PokerHandComparer();
        String result = comparer.FullHouse(hand);

        Assert.assertEquals(expected1, result);
    }

    @Test
    public void ShouldDetermineRankOfHandAsTwoPair3s()
    {
        String hand = "2D 3D 2S 3S 4C";

        PokerHandComparer comparer = new PokerHandComparer();
        PokerHandValue expected = new PokerHandValue("32", PokerHandRank.Two_Pair);

        PokerHandValue result = comparer.GetHandRank(new Hand(hand));

        Assert.assertTrue(expected.compareTo(result) == 0);
    }

    @Test
    public void ShouldCompareValuesOfTwoPair_2KUnderA2()
    {
        String firstValues = "2K";
        String secondValues = "A2";

        int expected = -1;

        PokerHandValue hand1 = new PokerHandValue(firstValues, PokerHandRank.Two_Pair);
        PokerHandValue hand2 = new PokerHandValue(secondValues, PokerHandRank.Two_Pair);

        int result = hand1.compareTo(hand2);
        Assert.assertEquals(expected, result);
    }

    @Test
    public void ShouldCompareValuesOfTwoPair_AKOverA2()
    {
        String hand1 = "AC AS KH KH 7S";
        String hand2 = "AD AH 2C 2C KS";

        boolean expected = true;

        PokerHandComparer comparer = new PokerHandComparer();
        boolean result = comparer.Hand1BeatsHand2(hand1, hand2);

        Assert.assertEquals(expected, result);
    }

    @Test
    public void ShouldCompareValuesOfTwoPairAKEqualsKA()
    {
        String hand1 = "AC AS KH KH 7S";
        String hand2 = "AD AH KC 7C KS";

        boolean expected = false;

        PokerHandComparer comparer = new PokerHandComparer();
        boolean result = comparer.Hand1BeatsHand2(hand1, hand2);

        Assert.assertEquals(expected, result);
    }

    @Test
    public void ShouldCompareValuesOfOnePairAsWithKingHighCardBeating7HighCard()
    {
        String hand1 = "AC AS 2H 3H 7S";
        String hand2 = "AD AH 2C 3C KS";

        boolean expected = false;

        PokerHandComparer comparer = new PokerHandComparer();
        boolean result = comparer.Hand1BeatsHand2(hand1, hand2);

        Assert.assertEquals(expected, result);
    }

    @Test
    public void ShouldFindTwoPairA4BeatsKHigh()
    {
        String hand1 = "7C 5H KC QH JD";
        String hand2 = "AS KH 4C AD 4S";

        boolean expected = false;

        PokerHandComparer comparer = new PokerHandComparer();
        boolean result = comparer.Hand1BeatsHand2(hand1, hand2);

        Assert.assertEquals(expected, result);
    }


    @Test
    public void ShouldFindHand1RoyalFlushToBeatHand2StraightFlush()
    {
        String hand1 = "TS JS QS KS AS";
        String hand2 = "2S 3S 4S 5S 6S";
        boolean expected = true;

        PokerHandComparer comparer = new PokerHandComparer();
        boolean result = comparer.Hand1BeatsHand2(hand1, hand2);

        Assert.assertEquals(expected, result);
    }

    //Problem 54
    @Test
    public void ShouldFindCountOfHandsWhereHand1BeatsHand2()
    {
        SupportFiles files = new SupportFiles();
        String pokerFile = files.Location + "54.poker.txt";
        int expected = 376;

        PokerHandComparer comparer = new PokerHandComparer();
        int result = comparer.GetCountOfHandsWhereHand1BeatsHand2(pokerFile);

        Assert.assertEquals(expected, result);
    }
}
