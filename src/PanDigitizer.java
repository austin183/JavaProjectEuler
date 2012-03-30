import java.util.HashMap;
import java.util.Map;

/**
 * Go IntelliJ IDEA!
 * User: Austin
 * Date: 3/26/12
 * Time: 7:58 PM
 */
class PanDigitizer {

    private boolean IsPanDigital1Through9(String value) {
        Map<Integer, Boolean> usedNumbers = InitializeNumberMap();

        if (value.contains("0")) return false;
        for (int i = 0; i < value.length(); i++) {
            int currentValue = Integer.parseInt(value.substring(i, i + 1));
            if (!usedNumbers.get(currentValue)) {
                usedNumbers.put(currentValue, true);
            } else return false;
        }
        return AllNumbersUsed(usedNumbers);
    }

    public boolean IsPanDigital1Through9(int testValue) {
        String value = Integer.toString(testValue);
        return IsPanDigital1Through9(value);
    }

    public boolean IsPartialPanDigital(int testValue) {
        Map<Integer, Boolean> usedNumbers = InitializeNumberMap();
        String value = Integer.toString(testValue);
        if (value.contains("0")) return false;
        for (int i = 0; i < value.length(); i++) {
            int currentValue = Integer.parseInt(value.substring(i, i + 1));
            if (!usedNumbers.get(currentValue)) {
                usedNumbers.put(currentValue, true);
            } else return false;
        }
        return true;
    }

    private boolean AllNumbersUsed(Map<Integer, Boolean> usedNumbers) {
        for (int i = 1; i <= 9; i++) {
            if (!usedNumbers.get(i))
                return false;
        }
        return true;
    }

    private Map<Integer, Boolean> InitializeNumberMap() {
        Map<Integer, Boolean> toReturn = new HashMap<Integer, Boolean>();
        for (int i = 1; i <= 9; i++) {
            toReturn.put(i, false);
        }
        return toReturn;
    }

    public boolean IsPanDigital1Through9WithMultiplicandAndMultiplier(int testValue) {
        if (IsPartialPanDigital(testValue)) {

            for (int i = 1; i < testValue; i++) {
                if (testValue % i == 0
                        && IsPartialPanDigital(i)
                        && IsPartialPanDigital(testValue / i)) {
                    String toTest = Integer.toString(testValue) + Integer.toString(i) + Integer.toString(testValue / i);

                    if (IsPanDigital1Through9(toTest)) return true;
                }
            }
        }
        return false;
    }

    public int GetSumOfProductsWhereProductIsPandigital1Though9WithMultiplicandAndMultiplier() {
        int toReturn = 0;
        for (int i = 1; i <= 45000; i++) //Chosen because it seemed like no other numbers(up to 140k would be pandigital)
        {
            if (IsPanDigital1Through9WithMultiplicandAndMultiplier(i)) {
                toReturn += i;
            }
        }
        return toReturn;
    }
}
