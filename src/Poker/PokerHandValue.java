package Poker;

/**
 * Created with IntelliJ IDEA.
 * User: austin
 * Date: 7/30/12
 * Time: 7:57 PM
 * To change this template use File | Settings | File Templates.
 */
public class PokerHandValue implements Comparable<PokerHandValue>
{
    public final String Value;
    private final PokerHandRank Rank;

    public PokerHandValue(String value, PokerHandRank rank)
    {
        Value = value;
        Rank = rank;
    }

    @Override
    public int compareTo(PokerHandValue pokerHandValue) {

        if(Value.equals(pokerHandValue.Value) && Rank.equals(pokerHandValue.Rank))
            return 0;

        if(Rank.compareTo(pokerHandValue.Rank) == 0 && Rank == PokerHandRank.Two_Pair)
            return CompareTwoPair(pokerHandValue);

        if(Rank.compareTo(pokerHandValue.Rank) == 0)
            return new PlayingCard(Value, "").compareTo(new PlayingCard(pokerHandValue.Value, ""));

        if(Rank.compareTo(pokerHandValue.Rank) > 0)
            return 1;

        if(Rank.compareTo(pokerHandValue.Rank) < 0)
            return -1;

        if(new PlayingCard(Value, "").compareTo(new PlayingCard(pokerHandValue.Value, "")) > 0)
            return 1;
        return -1;
    }

    private int CompareTwoPair(PokerHandValue pokerHandValue) {
        Hand thisHand = new Hand();
        Hand otherHand = new Hand();

        thisHand.AddCard(Value.substring(0, 1), "");
        thisHand.AddCard(Value.substring(1, 2), "");

        otherHand.AddCard(pokerHandValue.Value.substring(0, 1), "");
        otherHand.AddCard(pokerHandValue.Value.substring(1, 2), "");

        if(thisHand.GetHighestSingleCardInHand().equals(otherHand.GetHighestSingleCardInHand()))
        {
            thisHand.RemoveCard(thisHand.GetHighestSingleCardInHand(), "");
            otherHand.RemoveCard(otherHand.GetHighestSingleCardInHand(), "");
        }
        return CompareCardValues(thisHand.GetHighestSingleCardInHand(), otherHand.GetHighestSingleCardInHand());
    }

    private int CompareCardValues(String value1, String value2)
    {
        return new PlayingCard(value1, "").compareTo(new PlayingCard(value2, ""));
    }
}
