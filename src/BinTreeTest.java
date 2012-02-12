import junit.framework.Assert;
import org.junit.Test;

/**
 * Go IntelliJ IDEA!
 * User: Austin
 * Date: 2/11/12
 * Time: 8:32 PM
 */
public class BinTreeTest {
    @Test
    public void ShoulIndicateWhenBinTreeIsEmpty()
    {
        BinTree tree = new BinTree();
        boolean result = tree.IsEmpty();
        Assert.assertEquals(true, result);
    }
    
    @Test
    public void ShouldSetParentBinTreeNode()
    {
        BinTreeNode newNode = new BinTreeNode(1);
        
        BinTree tree = new BinTree();
        tree.Set(newNode);

        BinTreeNode result = tree.Get();

        Assert.assertEquals(newNode, result);
    }

    @Test
    public void ShouldSetParentNodesLeftNode()
    {
        BinTree tree = new BinTree();
        BinTreeNode parentNode = new BinTreeNode(1);
        BinTreeNode leftNode = new BinTreeNode(2);
        parentNode.setLeftNode(leftNode);
        tree.Set(parentNode);

        BinTreeNode result = tree.Get().getLeftNode();
        Assert.assertEquals(leftNode, result);
    }

    @Test
    public void ShouldSetParentNodesRightNode()
    {
        BinTree tree = new BinTree();
        BinTreeNode parentNode = new BinTreeNode(1);
        BinTreeNode rightNode = new BinTreeNode(2);
        parentNode.setLeftNode(rightNode);
        tree.Set(parentNode);

        BinTreeNode result = tree.Get().getLeftNode();
        Assert.assertEquals(rightNode, result);
    }
}
