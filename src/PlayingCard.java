/**
 * Created with IntelliJ IDEA.
 * User: austin
 * Date: 7/22/12
 * Time: 8:24 PM
 * To change this template use File | Settings | File Templates.
 */
class PlayingCard implements Comparable<PlayingCard> {
    public final String Value;
    public final String Suit;
    public final String ValueOrder = "23456789TJQKA";

    public PlayingCard(String value, String suit)
    {
        Value = value;
        Suit = suit;
    }

    public String toString()
    {
        return Value + Suit;
    }

    @Override
    public int compareTo(PlayingCard card) {
        int thisCard = ValueOrder.indexOf(Value);
        int thatCard = ValueOrder.indexOf(card.Value);

        if (thisCard == thatCard) return 0;
        if (thisCard > thatCard) return 1;
        else return -1;
    }
}
