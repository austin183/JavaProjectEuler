/**
 * Created by IntelliJ IDEA.
 * User: Austin
 * Date: 2/4/12
 * Time: 2:23 PM
 * To change this template use File | Settings | File Templates.
 */
class Pythagorizer {
    public boolean IsTriplet(int a, int b, int c)
    {
        return (a < b) && (b < c) &&
                (Math.pow(a, 2) + Math.pow(b, 2) == Math.pow(c, 2));
    }
}
