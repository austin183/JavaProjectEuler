import java.util.ArrayList;
import java.util.List;

/**
 * Go IntelliJ IDEA!
 * User: Austin
 * Date: 3/28/12
 * Time: 8:08 AM
 */
class UnorthodoxFractionFinder {
    public boolean IsUnorthodoxFraction(double numerator, double denominator) {
        double enFirst = (int) numerator / 10;
        double enSecond = (int) numerator % 10;
        double deFirst = (int) denominator / 10;
        double deSecond = (int) denominator % 10;
        if (enFirst == deSecond && deSecond != 0) {
            if (numerator / denominator == enSecond / deFirst) return true;
        }

        if (enSecond == deFirst && deFirst != 0) {
            if (numerator / denominator == enFirst / deSecond) return true;
        }
        return false;  //To change body of created methods use File | Settings | File Templates.
    }

    public List<Fraction> GetUnorthodoxFractions() {
        List<Fraction> toReturn = new ArrayList<Fraction>();
        for (int denom = 11; denom <= 99; denom++) {
            for (int num = 10; num < denom; num++) {
                if (IsUnorthodoxFraction((double) num, (double) denom)) {
                    toReturn.add(new Fraction((double) num, (double) denom));
                }
            }
        }
        return toReturn;
    }
}
