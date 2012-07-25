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

    public boolean IsStraightFlush(String hand) {
        Hand thisHand = new Hand(hand);
        return thisHand.IsSameSuit() && thisHand.IsConsecutive();
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

    public boolean IsFlush(String hand) {
        return new Hand(hand).IsSameSuit();
    }

    public boolean IsStraight(String hand) {
        return new Hand(hand).IsConsecutive();
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



}
