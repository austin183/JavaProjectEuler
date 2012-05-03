import junit.framework.Assert;
import org.junit.Test;

/**
 * Go IntelliJ IDEA!
 * User: Austin
 * Date: 2/8/12
 * Time: 12:31 PM
 */
public class TriangulizerTest {
    @Test
    public void ShouldGetTriangleNumberFor1() {
        int triangleIndex = 1;
        Triangulizer triangulizer = new Triangulizer();

        int result = triangulizer.GetTriangleNumberAt(triangleIndex);

        Assert.assertEquals(1, result);
    }

    @Test
    public void ShouldGetTriangleNumberFor7() {
        int triangleIndex = 7;
        Triangulizer triangulizer = new Triangulizer();

        int result = triangulizer.GetTriangleNumberAt(triangleIndex);

        Assert.assertEquals(28, result);
    }

    @Test
    public void ShouldRecognize28AsTriangleNumber()
    {
        int candidate = 28;
        boolean expected = true;

        Triangulizer triangulizer = new Triangulizer();
        boolean  result = triangulizer.IsTriangleNumber(candidate);

        Assert.assertEquals(expected, result);
    }

    @Test
    public void ShouldNotRecognize27AsTriangleNumber()
    {
        int candidate = 27;
        boolean expected = false;

        Triangulizer triangulizer = new Triangulizer();
        boolean  result = triangulizer.IsTriangleNumber(candidate);

        Assert.assertEquals(expected, result);
    }

    @Test
    public void ShouldNotRecognize29AsTriangleNumber()
    {
        int candidate = 29;
        boolean expected = false;

        Triangulizer triangulizer = new Triangulizer();
        boolean  result = triangulizer.IsTriangleNumber(candidate);

        Assert.assertEquals(expected, result);
    }
}
