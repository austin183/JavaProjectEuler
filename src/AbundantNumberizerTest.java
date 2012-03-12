import junit.framework.Assert;
import org.junit.Ignore;
import org.junit.Test;

import java.util.List;

/**
 * Go IntelliJ IDEA!
 * User: Austin
 * Date: 2/18/12
 * Time: 5:17 PM
 */
public class AbundantNumberizerTest {
    @Test
    public void ShouldRecognize1Thru12AsNotAnAbundantNumber() {
        AbundantNumberizer numberizer = new AbundantNumberizer();
        for (int number = 1; number < 12; number++) {
            boolean result = numberizer.IsAbundantNumber(number);

            Assert.assertEquals(false, result);
        }
    }

    @Test
    public void ShouldRecognize12AsAnAbundantNumber() {
        AbundantNumberizer numberizer = new AbundantNumberizer();
        int number = 12;
        boolean result = numberizer.IsAbundantNumber(number);

        Assert.assertEquals(true, result);
    }

    @Test
    public void ShouldFindAllAbundantNumbers() {
        AbundantNumberizer numberizer = new AbundantNumberizer();
        List<Integer> abundantNumbers = numberizer.GetAbundantNumbers();

        Assert.assertEquals(6965, abundantNumbers.size());
    }

    @Test
    public void ShouldRecognize1CannotBeSummedByTwoAbundantNumbers() {
        int number = 1;

        AbundantNumberizer numberizer = new AbundantNumberizer();
        boolean result = numberizer.CanBeSummedByTwoAbundantNumbers(number);

        Assert.assertEquals(false, result);
    }

    @Test
    public void ShouldRecognize24CanBeSummedByTwoAbundantNumbers() {
        int number = 24;

        AbundantNumberizer numberizer = new AbundantNumberizer();
        boolean result = numberizer.CanBeSummedByTwoAbundantNumbers(number);

        Assert.assertEquals(true, result);
    }

    @Test
    @Ignore("Slow")
    public void ShouldFindSumOfAllNumbersThatCannotBeWrittenAsTheSumOfTwoAbundantNumbers() {
        AbundantNumberizer numberizer = new AbundantNumberizer();
        int result = numberizer.GetSumOfAllNumbersThatCannotBeWrittenAsTheSumOfTwoAbundantNumbers();

        Assert.assertEquals(4179871, result);
    }
}
