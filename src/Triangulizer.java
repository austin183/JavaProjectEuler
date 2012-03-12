/**
 * Created by IntelliJ IDEA.
 * User: Austin
 * Date: 2/8/12
 * Time: 12:31 PM
 * To change this template use File | Settings | File Templates.
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
