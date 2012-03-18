/**
 * Go IntelliJ IDEA!
 * User: Austin
 * Date: 3/18/12
 * Time: 3:29 PM
 */
class IntegerMath {
    public int Pow(int a, int b) {
        if(b == 0) return 1;
        int toReturn = a;
        for(int i = 1; i < b; i++)
        {
            toReturn *= a;
        }
        return toReturn;
    }
}
