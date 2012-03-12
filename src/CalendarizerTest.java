import junit.framework.Assert;
import org.junit.Test;

/**
 * Go IntelliJ IDEA!
 * User: Austin
 * Date: 2/18/12
 * Time: 1:47 PM
 */
public class CalendarizerTest {
    @Test
    public void ShouldGetDayByDate() {
        Calendarizer calendarizer = new Calendarizer();

        String result = calendarizer.GetDayOfWeek("2/18/2012");

        Assert.assertEquals("Saturday", result);
    }

    @Test
    public void ShouldGetNumberOfSundaysThatWereFirstOfTheMonthBetween111901And12312000() {
        String startDate = "1/1/1901";
        String endDate = "12/31/2000";

        Calendarizer calendarizer = new Calendarizer();

        int result = calendarizer.GetNumberTimeDayWasFirstOfMonth("Sunday", startDate, endDate);

        Assert.assertEquals(171, result);
    }

}
