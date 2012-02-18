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
    @Test
    public void ShouldLoadNameList()
    {
        NameListAnalyzer analyzer = new NameListAnalyzer();

        analyzer.Load("C:\\Temp\\ProjectEuler\\22.names.txt");
        List<String> result = analyzer.GetNamesList();

        Assert.assertNotNull(result);
    }
    
    @Test
    public void ShouldSortNames()
    {
        NameListAnalyzer analyzer = new NameListAnalyzer();

        analyzer.Load("C:\\Temp\\ProjectEuler\\22.names.txt");
        analyzer.Sort();
        
        String prev = "";
        for(String name : analyzer.GetNamesList())
        {
            Assert.assertTrue(prev.compareTo(name) < 0);
            prev = name;
        }
    }
    
    @Test
    public void ShouldGetAlphabeticalValueOfAustin()
    {
        String name = "Austin";
        NameListAnalyzer analyzer = new NameListAnalyzer();

        int result = analyzer.GetAlphabeticalValue(name);

        Assert.assertEquals(84, result);
    }

    @Test
    public void ShouldGetSumOfAlphabeticalValuesTimesAlphabeticalOrderingFromList()
    {
        NameListAnalyzer analyzer = new NameListAnalyzer();

        analyzer.Load("C:\\Temp\\ProjectEuler\\22.names.txt");
        int result = analyzer.GetSumOfAlphabeticalValuesTimesAlphabeticalOrdering();

        Assert.assertEquals(871198282, result);
    }
}
