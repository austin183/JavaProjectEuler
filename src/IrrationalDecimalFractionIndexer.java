/**
 * Go IntelliJ IDEA!
 * User: Austin
 * Date: 4/15/12
 * Time: 6:35 PM
 */
class IrrationalDecimalFractionIndexer {
    public int GetNthDigitInDecimalMadeOfConcatenatedPositiveIntegers(int index) {
        int currentLength = 0;
        int currentNumber = 0;
        int thisLength = 0;
        while (currentLength < index) {
            currentNumber++;
            thisLength = Integer.toString(currentNumber).length();
            currentLength += thisLength;
        }
        int remainingLength = thisLength - (currentLength - index) - 1;
        return Integer.parseInt(Integer.toString(currentNumber).substring(remainingLength, remainingLength + 1));
    }
}
