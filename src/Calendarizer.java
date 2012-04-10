import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * Go IntelliJ IDEA!
 * User: Austin
 * Date: 2/18/12
 * Time: 1:47 PM
 */
class Calendarizer {

    private final SimpleDateFormat stringFormat = new SimpleDateFormat("MM/dd/yyyy");
    private final SimpleDateFormat weekFormat = new SimpleDateFormat("EEEE");

    public String GetDayOfWeek(String dateString) {
        Date date = null;
        try {
            date = stringFormat.parse(dateString);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return GetDayOfWeek(date);
    }

    String GetDayOfWeek(Date date) {
        return weekFormat.format(date);
    }

    public int GetNumberTimeDayWasFirstOfMonth(String dayOfWeek, String startDate, String endDate) {
        Date stDate = null;
        Date edDate = null;

        int toReturn = 0;
        try {
            stDate = stringFormat.parse(startDate);
            edDate = stringFormat.parse(endDate);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        Calendar currentMonth = Calendar.getInstance();
        currentMonth.setTime(stDate);
        while (currentMonth.getTime().before(edDate) || currentMonth.getTime().equals(edDate)) {
            if (GetDayOfWeek(currentMonth.getTime()).compareTo(dayOfWeek) == 0) toReturn++;
            currentMonth.add(Calendar.MONTH, 1);
        }
        return toReturn;
    }
}
