/**
 * Go IntelliJ IDEA!
 * User: Austin
 * Date: 2/8/12
 * Time: 12:31 PM
 */
class Triangulizer {
    public int GetTriangleNumberAt(int triangleIndex) {
        int toReturn = 0;
        for (int i = 1; i <= triangleIndex; i++) {
            toReturn += i;
        }
        return toReturn;
    }
}
