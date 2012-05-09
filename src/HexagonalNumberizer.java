/**
 * Go IntelliJ IDEA!
 * User: Austin
 * Date: 5/8/12
 * Time: 6:21 PM
 */
class HexagonalNumberizer {
    public int GetHexagonalNumberAt(int i) {
        return i * ((2 * i) - 1);
    }

    //Go quadratic equations!
    //http://www.algebra.com/algebra/homework/quadratic/solver.mpl
    public boolean IsHexagonalNumber(long i) {
        double value = (1 + (Math.sqrt(1 + (8 * i)))) / 4;
        return value % 1 == 0;
    }
}
