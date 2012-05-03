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

    public boolean IsTriangleNumber(int value)
    {
        int triangleNumber = 0;
        for(int i = 1; triangleNumber < value; i++)
        {
            triangleNumber = GetTriangleNumberAt(i);
            if(triangleNumber == value)
                return true;
        }
        return false;
    }
}
