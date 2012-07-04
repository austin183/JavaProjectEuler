import junit.framework.Assert;
import org.junit.Test;

import java.util.ArrayList;

/**
 * Go IntelliJ IDEA!
 * User: Austin
 * Date: 2/7/12
 * Time: 10:14 PM
 */
public class GridizerTest {

    private String Grid3x3Path()
    {
        SupportFiles files = new SupportFiles();
        return files.Location + "11.3x3.txt";
    }

    @Test
    public void ShouldLoadGridFromFile() {
        Gridizer gridizer = new Gridizer();

        gridizer.InitializeGrid(Grid3x3Path());

        ArrayList<ArrayList<Integer>> grid = gridizer.GetGrid();
        Assert.assertNotNull(grid);
    }

    @Test
    public void ShouldReturnGridValueSpecified() {
        int x = 0;
        int y = 0;

        Gridizer gridizer = new Gridizer();
        gridizer.InitializeGrid(Grid3x3Path());

        int result = gridizer.GetValueAt(x, y);

        Assert.assertEquals(8, result);
    }

    @Test
    public void ShouldGetProductRight() {
        int x = 0;
        int y = 0;
        int sequenceSize = 3;

        Gridizer gridizer = new Gridizer();
        gridizer.InitializeGrid(Grid3x3Path());

        int result = gridizer.GetProductRight(x, y, sequenceSize);

        Assert.assertEquals(352, result);
    }

    @Test
    public void ShoudGetZeroWhenNotEnoughValuesToTheRight() {
        int x = 0;
        int y = 0;
        int sequenceSize = 4;

        Gridizer gridizer = new Gridizer();
        gridizer.InitializeGrid(Grid3x3Path());

        int result = gridizer.GetProductRight(x, y, sequenceSize);

        Assert.assertEquals(0, result);
    }

    @Test
    public void ShouldGetProductDown() {
        int x = 0;
        int y = 0;
        int sequenceSize = 3;

        Gridizer gridizer = new Gridizer();
        gridizer.InitializeGrid(Grid3x3Path());

        int result = gridizer.GetProductDown(x, y, sequenceSize);

        Assert.assertEquals(31752, result);
    }

    @Test
    public void ShouldGetZeroWhenNotEnoughValuesBelow() {
        int x = 0;
        int y = 0;
        int sequenceSize = 4;

        Gridizer gridizer = new Gridizer();
        gridizer.InitializeGrid(Grid3x3Path());

        int result = gridizer.GetProductDown(x, y, sequenceSize);

        Assert.assertEquals(0, result);
    }

    @Test
    public void ShouldGetProductDownAndRight() {
        int x = 0;
        int y = 0;
        int sequenceSize = 3;

        Gridizer gridizer = new Gridizer();
        gridizer.InitializeGrid(Grid3x3Path());

        int result = gridizer.GetProductDownAndRight(x, y, sequenceSize);

        Assert.assertEquals(12152, result);
    }

    @Test
    public void ShouldGetZeroWhenNotEnoughValuesBelowAndToTheRight() {
        int x = 0;
        int y = 0;
        int sequenceSize = 4;

        Gridizer gridizer = new Gridizer();
        gridizer.InitializeGrid(Grid3x3Path());

        int result = gridizer.GetProductDownAndRight(x, y, sequenceSize);

        Assert.assertEquals(0, result);
    }

    @Test
    public void ShouldGetProductDownAndLeft() {
        int x = 0;
        int y = 2;
        int sequenceSize = 3;

        Gridizer gridizer = new Gridizer();
        gridizer.InitializeGrid(Grid3x3Path());

        int result = gridizer.GetProductDownAndLeft(x, y, sequenceSize);

        Assert.assertEquals(87318, result);
    }

    @Test
    public void ShouldGetZeroWhenNotEnoughValuesBelowAndToTheLeft() {
        int x = 0;
        int y = 2;
        int sequenceSize = 4;

        Gridizer gridizer = new Gridizer();
        gridizer.InitializeGrid(Grid3x3Path());

        int result = gridizer.GetProductDownAndLeft(x, y, sequenceSize);

        Assert.assertEquals(0, result);
    }
}
