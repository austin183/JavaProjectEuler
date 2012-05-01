/**
 * Go IntelliJ IDEA!
 * User: Austin
 * Date: 4/15/12
 * Time: 6:35 PM
 */
class IrrationalDecimalFractionIndexer {
    private String DecimalValue = "";
    private int LastAddedValue = 0;

    private void BuildDecimalValueToNumberOfDigits(int maxLength) {
        while (DecimalValue.length() < maxLength) {
            LastAddedValue++;
            System.out.println("Adding " + LastAddedValue + " to DecimalValue");
            DecimalValue += Integer.toString(LastAddedValue);
        }
    }

    public int GetNthDigitInDecimalMadeOfConcatenatedPositiveIntegers(int index) {
        BuildDecimalValueToNumberOfDigits(index);
        return Integer.parseInt(DecimalValue.substring(index - 1, index));
    }
}
