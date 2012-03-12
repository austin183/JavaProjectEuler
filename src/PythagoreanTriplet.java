/**
 * Created by IntelliJ IDEA.
 * User: Austin
 * Date: 2/4/12
 * Time: 2:35 PM
 * To change this template use File | Settings | File Templates.
 */
public class PythagoreanTriplet {
    private final int A;
    private final int B;
    private final int C;

    public PythagoreanTriplet(int a, int b, int c) {
        A = a;
        B = b;
        C = c;
    }

    public int GetProductOfTriplet() {
        return A * B * C;
    }
}
