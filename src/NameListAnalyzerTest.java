import junit.framework.Assert;
import org.junit.Test;

import java.util.List;

/**
 * Go IntelliJ IDEA!
 * User: Austin
 * Date: 2/18/12
 * Time: 4:12 PM
 */
public class NameListAnalyzerTest {
    private String Names(){
        SupportFiles files = new SupportFiles();
        return files.Location + "22.names.txt";
    }

    @Test
    public void ShouldLoadNameList() {
        NameListAnalyzer analyzer = new NameListAnalyzer();

        analyzer.Load(Names());
        List<String> result = analyzer.GetNamesList();

        Assert.assertNotNull(result);
    }

    @Test
    public void ShouldSortNames() {
        NameListAnalyzer analyzer = new NameListAnalyzer();

        analyzer.Load(Names());
        analyzer.Sort();

        String prev = "";
        for (String name : analyzer.GetNamesList()) {
            Assert.assertTrue(prev.compareTo(name) < 0);
            prev = name;
        }
    }

    @Test
    public void ShouldGetAlphabeticalValueOfAustin() {
        String name = "Austin";
        NameListAnalyzer analyzer = new NameListAnalyzer();

        int result = analyzer.GetAlphabeticalValue(name);

        Assert.assertEquals(84, result);
    }

    //Problem 22
    @Test
    public void ShouldGetSumOfAlphabeticalValuesTimesAlphabeticalOrderingFromList() {
        NameListAnalyzer analyzer = new NameListAnalyzer();

        analyzer.Load(Names());
        int result = analyzer.GetSumOfAlphabeticalValuesTimesAlphabeticalOrdering();

        Assert.assertEquals(871198282, result);
    }
}
