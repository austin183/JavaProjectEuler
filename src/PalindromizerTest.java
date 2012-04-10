import junit.framework.Assert;
import org.junit.Test;

/**
 * Go IntelliJ IDEA!
 * User: Austin
 * Date: 2/4/12
 * Time: 12:06 PM
 */
public class PalindromizerTest {
    @Test
    public void testIsPalindromeWith9009() throws Exception {
        int candidate = 9009;
        Palindromizer palindromizer = new Palindromizer();
        Assert.assertTrue(palindromizer.IsPalindrome(candidate));
    }

    @Test
    public void testIsPalindromeWith9109() throws Exception {
        int candidate = 9109;
        Palindromizer palindromizer = new Palindromizer();
        Assert.assertFalse(palindromizer.IsPalindrome(candidate));
    }

    @Test
    public void testIsPalindromeWith91019() throws Exception {
        int candidate = 91019;
        Palindromizer palindromizer = new Palindromizer();
        Assert.assertTrue(palindromizer.IsPalindrome(candidate));
    }

    @Test
    public void testIsPalindromeWith9110119() throws Exception {
        int candidate = 9110119;
        Palindromizer palindromizer = new Palindromizer();
        Assert.assertTrue(palindromizer.IsPalindrome(candidate));
    }

    @Test
    public void testIsPalindromeWith9101119() throws Exception {
        int candidate = 9101119;
        Palindromizer palindromizer = new Palindromizer();
        Assert.assertFalse(palindromizer.IsPalindrome(candidate));
    }

    @Test
    public void ShouldRecognize585AsPalindromeInBinary()
    {
        int candidate = 585;
        boolean expected = true;

        Palindromizer palindromizer = new Palindromizer();
        boolean actual = palindromizer.IsBinaryPalindrome(candidate);
        Assert.assertEquals(expected, actual);
    }
}
