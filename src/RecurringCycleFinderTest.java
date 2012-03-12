import junit.framework.Assert;
import org.junit.Test;

/**
 * Go IntelliJ IDEA!
 * User: Austin
 * Date: 3/12/12
 * Time: 8:34 AM
 */
public class RecurringCycleFinderTest {

    @Test
    public void ShouldFindRecurringCycleFor1Over3() {
        int input = 3;
        int expected = 1;
        RecurringCycleFinder finder = new RecurringCycleFinder();
        int result = finder.FindCycleLength(input);

        Assert.assertEquals(expected, result);
    }

    @Test
    public void ShouldFindNoRecurringCycleFor1Over2() {
        int input = 2;
        int expected = 0;
        RecurringCycleFinder finder = new RecurringCycleFinder();
        int result = finder.FindCycleLength(input);

        Assert.assertEquals(expected, result);
    }

    @Test
    public void ShouldFindRecurringCycleFor1Over6() {
        int input = 6;
        int expected = 1;
        RecurringCycleFinder finder = new RecurringCycleFinder();
        int result = finder.FindCycleLength(input);

        Assert.assertEquals(expected, result);
    }

    @Test
    public void ShouldFindRecurringCycleFor1Over7() {
        int input = 7;
        int expected = 6;
        RecurringCycleFinder finder = new RecurringCycleFinder();
        int result = finder.FindCycleLength(input);

        Assert.assertEquals(expected, result);
    }

    @Test
    public void ShouldFindRecurringCycleFor1Over14() {
        int input = 14;
        int expected = 6;
        RecurringCycleFinder finder = new RecurringCycleFinder();
        int result = finder.FindCycleLength(input);

        Assert.assertEquals(expected, result);
    }

}
