// package TreePackage

/** Class for creating a BinaryNode object. */
public class BinaryNode<T>
{
    private T data;
    private BinaryNode<T> leftChild;
    private BinaryNode<T> rightChild;

    /** Default constructor */
    public BinaryNode()
    {
        this(null); // Call next constructor
    }

    /** Constructor with given data only */
    public BinaryNode(T dataPortion)
    {
        this(dataPortion, null, null); // Call next constructor
    }

    /** Constructor with given data and children */
    public BinaryNode(T dataPortion, BinaryNode<T> newLeftChild, BinaryNode<T> newRightChild)
    {
        data = dataPortion;
        leftChild = newLeftChild;
        rightChild = newRightChild;
    }

    /** Retrieves the data portion of this node.
        @return The object in the data portion of the node. */
    public T getData()
    {
        return data;
    }

    /** Sets the data portion of this node.
        @param newData The data object. */
    public void setData(T newData)
    {
        data = newData;
    }

    /** Retrieves the left child of this node.
        @return The node that is this node's left child. */
    public BinaryNode<T> getLeftChild()
    {
        return leftChild;
    }

    /** Sets the left child of this node.
        @param newData The left child. */
    public void setLeftChild(BinaryNode<T> newLeftChild)
    {
        leftChild = newLeftChild;
    }

    /** Checks if this node has a left child.
        @return True if the node has a left child. */
    public boolean hasLeftChild()
    {
        return leftChild != null;
    }

    /** Retrieves the right child of this node.
        @return The node that is this node's right child. */
    public BinaryNode<T> getRightChild()
    {
        return rightChild;
    }

    /** Sets the right child of this node.
        @param newData The right child. */
    public void setRightChild(BinaryNode<T> newRightChild)
    {
        leftChild = newRightChild;
    }

    /** Checks if this node has a right child.
        @return True if the node has a right child. */
    public boolean hasRightChild()
    {
        return rightChild != null;
    }

    /** Checks if this node is a leaf.
        @return True if the node is a leaf. */
    public boolean isLeaf()
    {
        return (leftChild == null) && (rightChild == null);
    }

    /** Prints all nodes of a subtree rooted at a BinaryNode object using post-order traversal. */
    public void postorderTraverse_binaryNodeMethod()
    {
        
    }

    /** Calls getHeight_binaryNodeMethod(BinaryNode<T> node) method
        @return The value from the next getHeight method. */
    public int getHeight_binaryNodeMethod()
    {
        return getHeight_binaryNodeMethod(this);
    }

    /** Retrieves the height of the subtree rooted at this node.
        @return The height of the node's subtree. */
    public int getHeight_binaryNodeMethod(BinaryNode<T> node)
    {
        int height = 0;
        if (node != null)
        {
            height = 1 + Math.max(getHeight_binaryNodeMethod(node.getLeftChild()), getHeight_binaryNodeMethod(node.getRightChild()));
        }
        return height;
    }

    /** Copies the subtree rooted at a node.
        @return The subtree of the node. */
    public BinaryNode<T> copy()
    {
        BinaryNode<T> newRoot = new BinaryNode<>(data);
        if (leftChild != null)
        {
            newRoot.setLeftChild(leftChild.copy());
        }
        if (rightChild != null)
        {
            newRoot.setRightChild(rightChild.copy());
        }
        return newRoot;
    }
}
