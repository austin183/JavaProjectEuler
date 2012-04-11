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
    public void ShouldGetPermutationsFor012() {
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

    @Test
    public void ShouldGet1stPermutationFor012() {
        String permuteThis = "012";
        Permutizer permutizer = new Permutizer();
        String result = permutizer.GetNthPermutation(permuteThis, 0);

        Assert.assertEquals("012", result);
    }

    @Test
    public void ShouldGet2ndPermutationFor012() {
        String permuteThis = "012";
        Permutizer permutizer = new Permutizer();
        String result = permutizer.GetNthPermutation(permuteThis, 1);

        Assert.assertEquals("021", result);
    }

    @Test
    public void ShouldGet3rdPermutationFor012() {
        String permuteThis = "012";
        Permutizer permutizer = new Permutizer();
        String result = permutizer.GetNthPermutation(permuteThis, 2);

        Assert.assertEquals("102", result);
    }

    @Test
    public void ShouldGet1000000thPermutationFor0123456789() {
        String permuteThis = "0123456789";
        Permutizer permutizer = new Permutizer();
        String result = permutizer.GetNthPermutation(permuteThis, 999999);

        Assert.assertEquals("2783915460", result);
    }

    @Test
    public void ShouldGetPermutationHigherThan918273654()
    {
        String permuteThis = "918273654";
        String expected = "918274356";

        Permutizer permutizer = new Permutizer();
        String result = permutizer.GetNextPermutation(permuteThis);

        Assert.assertEquals(expected, result);
    }

    @Test
    public void ShouldGetPermutationLowerThan918274356()
    {
        String permuteThis = "918274356";
        String expected = "918273654";

        Permutizer permutizer = new Permutizer();
        String result = permutizer.GetPreviousPermutation(permuteThis);

        Assert.assertEquals(expected, result);
    }

    @Test
    public void ShouldGetPermutationHigherThan918274356()
    {
        String permuteThis = "918274356";
        String expected = "918274365";

        Permutizer permutizer = new Permutizer();
        String result = permutizer.GetNextPermutation(permuteThis);

        Assert.assertEquals(expected, result);
    }

    @Test
    public void ShouldGetPreviousPermutationOf918274365()
    {
        String permuteThis = "918274365";
        String expected = "918274356";

        Permutizer permutizer = new Permutizer();
        String result = permutizer.GetPreviousPermutation(permuteThis);

        Assert.assertEquals(expected, result);
    }

    @Test
    public void ShoulGetPreviousPermutationOf987654321()
    {
        String permuteThis = "987654321";
        String expected = "987654312";

        Permutizer permutizer = new Permutizer();
        String result = permutizer.GetPreviousPermutation(permuteThis);

        Assert.assertEquals(expected, result);
    }

}
