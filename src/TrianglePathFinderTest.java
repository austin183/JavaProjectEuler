import junit.framework.Assert;
import org.junit.Test;

import java.util.List;

/**
 * Go IntelliJ IDEA!
 * User: Austin
 * Date: 2/12/12
 * Time: 11:03 AM
 */
public class TrianglePathFinderTest {
    @Test
    public void ShouldLoadTriangleFromFile() {
        String filePath = "C:\\Temp\\ProjectEuler\\18.SumOfPathsOnTriangleTopToBottom2Lines.txt";

        TrianglePathFinder finder = new TrianglePathFinder();
        finder.Load(filePath);

        List<List<Integer>> triangle = finder.GetTriangle();

        Assert.assertNotNull(triangle);
    }

    @Test
    public void ShouldGetGreatestSumForAllPathsTopToBottom3Lines() {
        String filePath = "C:\\Temp\\ProjectEuler\\18.SumOfPathsOnTriangleTopToBottom3Lines.txt";

        TrianglePathFinder finder = new TrianglePathFinder();
        finder.Load(filePath);

        int result = finder.GetGreatestSumTopToBottom();

        Assert.assertEquals(221, result);
    }

    @Test
    public void ShouldGetGreatestSumForAllPathsTopToBottom4Lines() {
        String filePath = "C:\\Temp\\ProjectEuler\\18.SumOfPathsOnTriangleTopToBottom4Lines.txt";

        TrianglePathFinder finder = new TrianglePathFinder();
        finder.Load(filePath);

        int result = finder.GetGreatestSumTopToBottom();

        Assert.assertEquals(308, result);
    }

    //Problem 18
    @Test
    public void ShouldGetGreatestSumForAllPathsTopToBottom15Lines() {
        String filePath = "C:\\Temp\\ProjectEuler\\18.SumOfPathsOnTriangleTopToBottom.txt";

        TrianglePathFinder finder = new TrianglePathFinder();
        finder.Load(filePath);

        int result = finder.GetGreatestSumTopToBottom();

        Assert.assertEquals(1074, result);
    }

    @Test
    public void ShouldGetGreatestSumForAllPathsTopToBottom100Lines() {
        String filePath = "C:\\Temp\\ProjectEuler\\67.triangle.txt";

        TrianglePathFinder finder = new TrianglePathFinder();
        finder.Load(filePath);

        int result = finder.GetGreatestSumTopToBottom();

        Assert.assertEquals(7273, result);
    }
}
