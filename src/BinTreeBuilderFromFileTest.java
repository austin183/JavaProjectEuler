import org.junit.Test;

/**
 * Go IntelliJ IDEA!
 * User: Austin
 * Date: 2/11/12
 * Time: 8:14 PM
 */
public class BinTreeBuilderFromFileTest {
    @Test
    public void ShouldBuildTreeFromTwoLines()
    {
        String filePath = "C:\\Temp\\ProjectEuler\\18.SumOfPathsOnTriangleTopToBottom2Lines.txt";
        
        BinTreeBuilderFromFile builder = new BinTreeBuilderFromFile();
        BinTree binTree = builder.GetBinTree(filePath);
    }
}
