// package TreePackage

/** Class for creating a BinaryTree object. */
public class BinaryTree<T> implements BinaryTreeInterface<T>
{
   private BinaryNode<T> root;

   /** Default constructor */
   public BinaryTree()
   {
      root = null;
   }

   /** Constructor with given root data */
   public BinaryTree(T rootData)
   {
      root = new BinaryNode<>(rootData);
   } // end constructor

   /** Constructor with given root data and subtrees */
   public BinaryTree(T rootData, BinaryTree<T> leftTree, BinaryTree<T> rightTree)
   {
      initializeTree(rootData, leftTree, rightTree);
   }

   /** Setter method for a binary tree.
      @param rootData Root data.
      @param leftTree Left subtree of root.
      @param rightTree Right subtree of root. */
   public void setTree(T rootData, BinaryTreeInterface<T> leftTree, BinaryTreeInterface<T> rightTree)
   {
      initializeTree(rootData, (BinaryTree<T>)leftTree, (BinaryTree<T>)rightTree);
   }

   /** Setter method for root data. 
      @param rootData Root data. */
   public void setRootData(T rootData)
   {
      root.setData(rootData);
   }
   
   /** Getter method for root data. 
      @return Root data. */
   public T getRootData()
   {
      if (isEmpty())
         throw new EmptyTreeException();
      else
         return root.getData();
   }
   
   /** Checks if the root is empty.
      @return True if the root is empty. */
   public boolean isEmpty()
   {
      return root == null;
   } // end isEmpty
   
   /** Clears the binary tree. */
   public void clear()
   {
      root = null;
   }
   
   /** Setter method for the root node. 
      @param rootNode Root node. */
   protected void setRootNode(BinaryNode<T> rootNode)
   {
      root = rootNode;
   }
   
   /** Getter method for the root node. 
      @return Root node. */
   protected BinaryNode<T> getRootNode()
   {
      return root;
   }
   
   /** Initializes a binary tree with given root data and subtrees.
      @param rootData Data of root.
      @param leftTree Left subtree of root.
      @param rightTree Right subtree of root. */
   private void initializeTree(T rootData, BinaryTree<T> leftTree, BinaryTree<T> rightTree)
   {
      root = new BinaryNode<>(rootData);
      
      if ((leftTree != null) && !leftTree.isEmpty())
         root.setLeftChild(leftTree.root);
      
      if ((rightTree != null) && !rightTree.isEmpty())
      {
         if (rightTree != leftTree)
            root.setRightChild(rightTree.root);
         else
            root.setRightChild(rightTree.root.copy());
      } // end if
      
      if ((leftTree != null) && (leftTree != this))
         leftTree.clear();
      
      if ((rightTree != null) && (rightTree != this))
         rightTree.clear();
   }
   
   /** Calls postorderTraverse(BinaryNode<T> node) method. */
   public void postorderTraverse()
   {
       postorderTraverse(root);
   }
   
   /** Prints all nodes in the subtree rooted at this node uing post-order traversal. */
   private void postorderTraverse(BinaryNode<T> node)
   {
       if (node != null)
       {
           postorderTraverse(node.getLeftChild());
           postorderTraverse(node.getRightChild());
           System.out.println(node.getData());
       }
   }
 
   /** Prints all nodes in the "whole" tree using post-order traversal. */
   public void postorderTraverse_callBinaryNodeMethod()
   {
        root.postorderTraverse_binaryNodeMethod();
   }
   
   /** Calls getHeight(BinaryNode<T> node) method.
      @return  The height of the "whole" tree. */
   public int getHeight_callBinaryNodeMethod()
   {
	   return root.getHeight_binaryNodeMethod();
   }

   /** calls getNumberOfNodes(BinaryNode<T> node) 
      @return  The number of nodes in the "whole" tree */
   public int getNumberOfNodes()
   {
      return getNumberOfNodes(root);
   }

   /** Retrieves the number of nodes in the subtree rooted at this node.
      @return The number of nodes in the node's subtree. */
   private int getNumberOfNodes(BinaryNode<T> node)
   {
      int leftNumber = 0;
      int rightNumber = 0;
      if (node.getLeftChild() != null)
      {
         leftNumber = getNumberOfNodes(node.getLeftChild());
      }
      if (node.getRightChild() != null)
      {
         rightNumber = getNumberOfNodes(node.getRightChild());
      }
      return 1 + leftNumber + rightNumber;
   }

   /** Method implementation required by TreeInterface. */
   public int getHeight() 
   {
      return 0;
   }

   /** The following calls getNumberOfNodes_binaryNodeMethod() which is a recursive binaryNode class method
    * Counts the nodes in the "whole" tree
   @return  The number of nodes in the "whole" tree. */
   public int getNumberOfNodes_callBinaryNodeMethod()
   {
	   int numberOfNodes = 0;
	   if (root != null)
		   numberOfNodes = root.getNumberOfNodes_binaryNodeMethod();
	   return numberOfNodes;
   } // end getNumberOfNodes_callBinaryNodeMethod
} 