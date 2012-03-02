import junit.framework.Assert;
import org.junit.Test;

import java.util.List;

/**
 * Go IntelliJ IDEA!
 * User: Austin
 * Date: 2/18/12
 * Time: 6:30 PM
 */
public class PermutizerTest {
    @Test
    public void ShouldGetPermutationsFor012()
    {
        String permuteThis = "012";
        Permutizer permutizer = new Permutizer();
        List<String> result = permutizer.Permute(permuteThis);

        Assert.assertEquals("012", result.get(0));
        Assert.assertEquals("021", result.get(1));
        Assert.assertEquals("102", result.get(2));
        Assert.assertEquals("120", result.get(3));
        Assert.assertEquals("201", result.get(4));
        Assert.assertEquals("210", result.get(5));
    }
}
