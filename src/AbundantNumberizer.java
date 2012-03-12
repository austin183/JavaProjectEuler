import java.util.ArrayList;
import java.util.List;

/**
 * Go IntelliJ IDEA!
 * User: Austin
 * Date: 2/18/12
 * Time: 5:17 PM
 */
class AbundantNumberizer {
    private final int Max = 28123;
    private List<Integer> AbundantNumbers;

    public boolean IsAbundantNumber(int number) {
        Factorizer factorizer = new Factorizer();
        int sumFactors = 0;
        for (Integer factor : factorizer.GetFactorsOf(number)) {
            if (factor != number) sumFactors += factor;
        }
        return sumFactors > number;
    }

    public List<Integer> GetAbundantNumbers() {
        List<Integer> toReturn = new ArrayList<Integer>();

        for (int i = 1; i <= Max; i++) {
            if (IsAbundantNumber(i)) {
                toReturn.add(i);
            }
        }
        return toReturn;
    }

    public int GetSumOfAllNumbersThatCannotBeWrittenAsTheSumOfTwoAbundantNumbers() {
        int toReturn = 0;
        for (int numberToTest = 1; numberToTest <= Max; numberToTest++) {
            if (numberToTest % 1000 == 0) System.out.println("Testing " + numberToTest + " CurrentSum: " + toReturn);
            if (!CanBeSummedByTwoAbundantNumbers(numberToTest)) toReturn += numberToTest;
        }
        return toReturn;
    }

    public boolean CanBeSummedByTwoAbundantNumbers(int number) {
        if (number < 24) return false;
        if (AbundantNumbers == null)
            AbundantNumbers = GetAbundantNumbers();

        for (int i = 0; AbundantNumbers.get(i) < number; i++) {
            if (AbundantNumbers.contains(number - AbundantNumbers.get(i))) return true;
        }
        return false;
    }
}
