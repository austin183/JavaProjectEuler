/**
 * Go IntelliJ IDEA!
 * User: Austin
 * Date: 5/2/12
 * Time: 10:35 PM
 */
class PentagonalNumberizer {
    public int GetPentagonalNumberAt(int i) {
        return (i * ((3 * i) -1))/2;
    }

    public boolean IsPentagonalNumber(long i) {
        double value = (1 + (Math.sqrt(1 + (24 * i)))) / 6;
        return value % 1 == 0;
    }
}
