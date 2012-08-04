import Poker.Hand;
import Poker.PokerHandRank;
import Poker.PokerHandValue;

import java.io.BufferedReader;
import java.io.IOException;
import java.math.BigInteger;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: austin
 * Date: 7/22/12
 * Time: 8:07 PM
 * To change this template use File | Settings | File Templates.
 */
class PokerHandComparer {


    public boolean IsRoyalFlush(String hand) {
        Hand thisHand = new Hand(hand);
        return thisHand.IsSameSuit() &&
                thisHand.ContainsCardOfAnySuit("T") &&
                thisHand.ContainsCardOfAnySuit("J") &&
                thisHand.ContainsCardOfAnySuit("Q") &&
                thisHand.ContainsCardOfAnySuit("K") &&
                thisHand.ContainsCardOfAnySuit("A");
    }

    public String IsStraightFlush(String hand) {
        Hand thisHand = new Hand(hand);
        if (thisHand.IsSameSuit() && thisHand.IsConsecutive())
            if(thisHand.ContainsCardOfAnySuit("2") && thisHand.ContainsCardOfAnySuit("A"))
                return "5";
            else  return thisHand.GetHighestSingleCardInHand();
        return "";
    }


    public String FourOfAKind(String hand) {
        return GetValueOfCardsThatOccurXTimes(hand, 4);
    }


    public String ThreeOfAKind(String hand) {
        return GetValueOfCardsThatOccurXTimes(hand, 3);
    }

    public String OnePair(String hand) {
        return GetValueOfCardsThatOccurXTimes(hand, 2);
    }

    public String TwoPair(String hand) {
        String orderedHand = new Hand(hand).OrderByValue().toString();
        String firstPair = OnePair(orderedHand);
        if(firstPair.equals("")) return "";
        int firstPairIndex = orderedHand.indexOf(firstPair);
        int firstPairLastIndex = orderedHand.lastIndexOf(firstPair);
        String remainingHand = orderedHand.substring(0, firstPairIndex) + orderedHand.substring(firstPairLastIndex + 2, orderedHand.length()).replace("  ", " ").trim();
        String secondPair = OnePair(remainingHand);
        if(secondPair.equals("")) return "";
        return firstPair + secondPair;
    }

    public String IsFlush(String hand) {
        Hand thisHand = new Hand(hand);
        if(thisHand.IsSameSuit())
            return thisHand.GetHighestSingleCardInHand();
        return "";
    }

    public String IsStraight(String hand) {
        Hand thisHand = new Hand(hand);
        if(thisHand.IsConsecutive())
            return thisHand.GetHighestSingleCardInHand();
        return "";
    }

    String GetValueOfCardsThatOccurXTimes(String hand, int x)
    {
        Map<String, Integer> numberOfKinds = new Hand(hand).GetNumberOfKinds();
        if(!numberOfKinds.containsValue(x)) return "";
        for (Map.Entry<String, Integer> entry : numberOfKinds.entrySet()) {
            if(entry.getValue() == x) return entry.getKey();
        }
        return "";
    }


    public String FullHouse(String hand) {
        String threeOfAKind = ThreeOfAKind(hand);
        String twoOfAKind = OnePair(hand);

        if((!threeOfAKind.equals("") && !twoOfAKind.equals("")))
            return threeOfAKind + twoOfAKind;
        return "";
    }


    public boolean Hand1BeatsHand2(String hand1, String hand2) {
        Hand firstHand = new Hand(hand1);
        Hand secondHand = new Hand(hand2);

        PokerHandValue firstHandRank = GetHandRank(firstHand);
        PokerHandValue secondHandRank = GetHandRank(secondHand);

        while (firstHandRank.compareTo(secondHandRank) == 0 && !firstHand.toString().equals(""))
        {
            switch (firstHandRank.Rank) {
                case Four_Of_A_Kind:
                case One_Pair:
                case Three_Of_A_Kind:
                case High_Card:
                case Flush:
                case Straight:
                case Straight_Flush:
                    firstHand.RemoveAllCardsOfValue(firstHandRank.Value);
                    secondHand.RemoveAllCardsOfValue(secondHandRank.Value);
                    break;

                case Two_Pair:
                case Full_House:
                    for (int i = 0; i < firstHandRank.Value.length(); i++) {
                        firstHand.RemoveAllCardsOfValue(firstHandRank.Value.substring(i, i + 1));
                        secondHand.RemoveAllCardsOfValue(firstHandRank.Value.substring(i, i + 1));
                    }
                    break;
            }

            if(firstHand.toString().equals("") || secondHand.toString().equals(""))
                return false;

            firstHandRank = GetHandRank(firstHand);
            secondHandRank = GetHandRank(secondHand);
        }

        return !(firstHand.toString().equals("") && secondHand.toString().equals("")) && firstHandRank.compareTo(secondHandRank) > 0;

    }

    public PokerHandValue GetHandRank(Hand hand) {
        String thisHand = hand.toString();
        if(IsRoyalFlush(thisHand)) return new PokerHandValue("", PokerHandRank.Royal_Flush);
        if(!IsStraightFlush(thisHand).equals("")) return new PokerHandValue(IsStraight(thisHand), PokerHandRank.Straight_Flush);
        if(!FourOfAKind(thisHand).equals("")) return new PokerHandValue(FourOfAKind(thisHand), PokerHandRank.Four_Of_A_Kind);
        if(!FullHouse(thisHand).equals("")) return new PokerHandValue(FullHouse(thisHand),  PokerHandRank.Full_House);
        if(!IsFlush(thisHand).equals("")) return new PokerHandValue(IsFlush(thisHand), PokerHandRank.Flush);
        if(!IsStraight(thisHand).equals(""))return new PokerHandValue(IsStraight(thisHand), PokerHandRank.Straight);
        if(!ThreeOfAKind(thisHand).equals("")) return new PokerHandValue(ThreeOfAKind(thisHand), PokerHandRank.Three_Of_A_Kind);
        if(!TwoPair(thisHand).equals("")) return new PokerHandValue(TwoPair(thisHand), PokerHandRank.Two_Pair);
        if(!OnePair(thisHand).equals("")) return new PokerHandValue(OnePair(thisHand), PokerHandRank.One_Pair);
        return new PokerHandValue(hand.GetHighestSingleCardInHand(), PokerHandRank.High_Card);
    }


    public int GetCountOfHandsWhereHand1BeatsHand2(String pokerFile) {
        FileHelper helper = new FileHelper();
        BufferedReader reader = helper.GetReader(pokerFile);
        String line;
        int count = 0;
        try {
            while ((line = reader.readLine()) != null) {
                String hand1 = line.substring(0, 14);
                String hand2 = line.substring(15, 29);
                if(Hand1BeatsHand2(hand1, hand2))
                    count++;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return count;
    }
}

