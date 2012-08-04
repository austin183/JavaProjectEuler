package Poker;

import java.util.*;

/**
 * Created with IntelliJ IDEA.
 * User: austin
 * Date: 7/22/12
 * Time: 8:21 PM
 * To change this template use File | Settings | File Templates.
 */
public class Hand {
    private final List<PlayingCard> playingCards;

    public Hand(String hand)
    {
        playingCards = new ArrayList<PlayingCard>();
        String[] splitHand = hand.split(" ");
        for (String s : splitHand) {
            AddCard(s.substring(0,1), s.substring(1,2));
        }
    }

    public Hand()
    {
        playingCards = new ArrayList<PlayingCard>();
    }

    public boolean IsSameSuit()
    {
        if(playingCards.size() < 5) return false;
        String currentSuit = "";
        for (PlayingCard playingCard : playingCards) {
            if(!(playingCard.Suit.compareTo(currentSuit) == 0 || currentSuit.isEmpty()))
                return false;
            currentSuit = playingCard.Suit;
        }
        return true;
    }

    public void AddCard(String value, String suit)
    {
        playingCards.add(new PlayingCard(value, suit));
    }

    public void RemoveCard(String value, String suit)
    {
        PlayingCard card = new PlayingCard(value, suit);
        if (!ContainsCard(card)) {
            return;
        }
        for(int i = playingCards.size() - 1; i > 0; i--)
        {
            PlayingCard currentCard = playingCards.get(i);
            if(currentCard.compareTo(card) == 0)
            {
                playingCards.remove(i);
            }
        }
    }

    public boolean ContainsCard(PlayingCard card) {
        for (PlayingCard playingCard : playingCards) {
            if (playingCard.Value.compareTo(card.Value) == 0 && playingCard.Suit.compareTo(card.Suit) == 0)
                return true;
        }
        return false;
    }

    public boolean IsConsecutive()
    {
        if(playingCards.size() < 5) return false;
        Collections.sort(playingCards);
        int currentIndex = 0;
        int count = 0;
         for (PlayingCard playingCard : playingCards) {
            int thisCardIndex = playingCard.ValueOrder.indexOf(playingCard.Value);
            if(currentIndex != 0 || count > 0)
            {
                if(count == 4
                && playingCards.get(0).Value.equals("2")
                && playingCards.get(4).Value.equals("A")) return true;

                if(thisCardIndex - currentIndex != 1) return false;
            }
            count ++;
            currentIndex = thisCardIndex;
        }
        return true;
    }

    public boolean ContainsCardOfAnySuit(String value)
    {
        for (PlayingCard playingCard: playingCards)
        {
            if(playingCard.Value.compareTo(value) == 0)
                return true;
        }
        return false;
    }

    @Override
    public String toString()
    {
        String toReturn = "";
        for (PlayingCard playingCard : playingCards) {
            if(toReturn.length() == 0)
                toReturn += playingCard.toString();
            else toReturn += " " + playingCard.toString();
        }
        return toReturn;
    }

    public Hand OrderByValue() {
        Collections.sort(playingCards);
        return this;
    }

    public Map<String, Integer> GetNumberOfKinds() {
        Map<String, Integer> toReturn = new HashMap<String, Integer>();
        for(PlayingCard playingCard : playingCards)
        {
            if(!toReturn.containsKey(playingCard.Value))
                toReturn.put(playingCard.Value, 0);
            int toIncrement = toReturn.get(playingCard.Value);
            toIncrement++;
            toReturn.put(playingCard.Value, toIncrement);
        }
        return toReturn;
    }

    public String GetHighestSingleCardInHand() {
        Map<String, Integer> numberOfKinds = GetNumberOfKinds();
        String toReturn = "";
        for (Map.Entry<String, Integer> entry : numberOfKinds.entrySet()) {
            if(entry.getValue() == 1)
            {
                if(toReturn.equals(""))
                    toReturn = entry.getKey();
                else if (new PlayingCard(entry.getKey(), "").compareTo(new PlayingCard(toReturn, "")) == 1)
                    toReturn = entry.getKey();
            }
        }
        return toReturn;
    }

    public Hand RemoveAllCardsOfValue(String value) {
        for(int i = playingCards.size() -1; i >= 0; i--)
        {
            if(playingCards.get(i).Value.equals(value))
                playingCards.remove(i);
        }
        return this;
    }
}
