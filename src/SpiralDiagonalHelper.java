/**
 * Go IntelliJ IDEA!
 * User: Austin
 * Date: 3/18/12
 * Time: 2:21 PM
 */
class SpiralDiagonalHelper {


    public int GetSumDiagonalsPointsAtLevel(int level) {
        return ((4 * (level * level)) - (6 * level) + 6);
    }


    public int GetSumOffullDiagonalsToLevel(int level) {
        int sum = 0;
        for(int i = 1; i <= level; i += 2)
        {
            sum += GetSumDiagonalsPointsAtLevel(i);
        }
        return sum - 3;
    }
}
