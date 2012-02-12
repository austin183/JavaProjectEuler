/**
 * Go IntelliJ IDEA!
 * User: Austin
 * Date: 2/11/12
 * Time: 8:23 PM
 */
public class BinTree {
    private BinTreeNode ParentNode;

    public BinTree()
    {
        ParentNode = null;
    }

    public boolean IsEmpty() {
        return ParentNode == null;
    }
    
    public void Set(BinTreeNode value)
    {
        ParentNode = value;
    }

    public BinTreeNode Get()
    {
        return ParentNode;
    }
}
