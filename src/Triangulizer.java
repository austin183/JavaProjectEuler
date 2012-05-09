/**
 * Go IntelliJ IDEA!
 * User: Austin
 * Date: 2/8/12
 * Time: 12:31 PM
 */
class Triangulizer {
    public int GetTriangleNumberAt(int triangleIndex)
    {
        return (int) ((double)triangleIndex * (double)(triangleIndex + 1) * .5);
    }

    public boolean IsTriangleNumber(long i)
    {
        double value = (1 + (Math.sqrt(1 + (8 * i)))) / 2;
        return value % 1 == 0;
    }
}
