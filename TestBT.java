import static org.junit.Assert.*;
import org.junit.Test;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

/** A test of several methods as defined in the BinaryTree class. */
public class TestBT
{
    BinaryTree<String> testTree = new BinaryTree<>();
    ByteArrayOutputStream outContent = new ByteArrayOutputStream();

    @Test
    public void testPostOrderTraverse()
    {
        createTree1(testTree);
        System.setOut(new PrintStream(outContent));
        testTree.postorderTraverse();
        assertEquals("D\r\nE\r\nB\r\nG\r\nF\r\nC\r\nA", outContent.toString().trim());
    }

    public static void createTree1(BinaryTree<String> tree)
	{ 
		// Leaves
		BinaryTree<String> dTree = new BinaryTree<>("D");
		BinaryTree<String> eTree = new BinaryTree<>("E");
		BinaryTree<String> gTree = new BinaryTree<>("G");

		// Subtrees:
		BinaryTree<String> fTree = new BinaryTree<>("F", null, gTree);
		BinaryTree<String> bTree = new BinaryTree<>("B", dTree, eTree);
		BinaryTree<String> cTree = new BinaryTree<>("C", fTree, null);

		tree.setTree("A", bTree, cTree);
	}
}
