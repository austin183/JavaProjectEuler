/**
 * Go IntelliJ IDEA!
 * User: Austin
 * Date: 2/11/12
 * Time: 8:25 PM
 */
public class BinTreeNode {
    private int Value;
    
    private BinTreeNode leftNode;
    private BinTreeNode rightNode;

    public BinTreeNode(int value)
    {
        Value = value;
        leftNode = null;
        rightNode = null;
    }

    public int getValue() {
        return Value;
    }

    public void setValue(int value) {
        Value = value;
    }

    public BinTreeNode getLeftNode() {
        return leftNode;
    }

    public void setLeftNode(BinTreeNode leftNode) {
        this.leftNode = leftNode;
    }

    public BinTreeNode getRightNode() {
        return rightNode;
    }

    public void setRightNode(BinTreeNode rightNode) {
        this.rightNode = rightNode;
    }
}
