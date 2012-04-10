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
}
