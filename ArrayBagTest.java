import static org.junit.Assert.*;
import org.junit.Test;

public class ArrayBagTest
{
    BagInterface<String> bagOne = new ResizableArrayBag<>(4);
    String[] bagOneContents = {"a", "b", "c"};
    @Test 
    public void testDisplayBag()
    {
        bagOne.displayBag();  
    }
    @Test
    public void testGetCurrentSize()
    {
        bagOne.add(bagOneContents);
        assertEquals(3,bagOne.getCurrentSize());
        String[] bagOneContentsB = {"a","b","c","d"}; 
        bagOne.add(bagOneContentsB);
        assertEquals(7,bagOne.getCurrentSize());
    }
    @Test
    public void testIsEmpty()
    {
        assertEquals(true, bagOne.isEmpty());
    }
    @Test
    public void testIsFull()
    {
        assertEquals(false,((ResizableArrayBag<String>)bagOne).isFull());
    }
    @Test
    public void testAdd()
    {
        assertEquals(true, bagOne.add("a"));
        assertEquals(true, bagOne.add("b"));
        assertEquals(true, bagOne.add("c"));
    }
    @Test
    public void testAddArray()
    {
        assertEquals(true, bagOne.add(bagOneContents));
    }
    @Test
    public void testDoubleCapacity()
    {
        ((ResizableArrayBag<String>)bagOne).doubleCapacity();
    }
    @Test
    public void testCheckCapacity()
    {
        ((ResizableArrayBag<String>)bagOne).checkCapacity(0);
        ((ResizableArrayBag<String>)bagOne).checkCapacity(1);
        ((ResizableArrayBag<String>)bagOne).checkCapacity(5);
        ((ResizableArrayBag<String>)bagOne).checkCapacity(10);
        ((ResizableArrayBag<String>)bagOne).checkCapacity(50);
        ((ResizableArrayBag<String>)bagOne).checkCapacity(100);
        ((ResizableArrayBag<String>)bagOne).checkCapacity(500);
    }
    @Test
    public void testRemove()
    {
        bagOne.add(bagOneContents);
        assertEquals(true, bagOne.remove("a"));
        assertEquals(true, bagOne.remove("b"));
        assertEquals(true, bagOne.remove("c"));
        assertEquals(false, bagOne.remove("d"));
        assertEquals(false, bagOne.remove("e"));
    }
    @Test
    public void testRemoveEntry()
    {
        bagOne.add(bagOneContents);
        assertEquals("a", ((ResizableArrayBag<String>)bagOne).removeEntry(0));
        assertEquals("b", ((ResizableArrayBag<String>)bagOne).removeEntry(1));
        assertEquals("c", ((ResizableArrayBag<String>)bagOne).removeEntry(0));
        assertEquals(null, ((ResizableArrayBag<String>)bagOne).removeEntry(3));
        assertEquals(null, ((ResizableArrayBag<String>)bagOne).removeEntry(4));
    }
    @Test
    public void testGetIndexOf()
    {
        bagOne.add(bagOneContents);
        ((ResizableArrayBag<String>)bagOne).getIndexOf("a");
        ((ResizableArrayBag<String>)bagOne).getIndexOf("b");
        ((ResizableArrayBag<String>)bagOne).getIndexOf("c");
        ((ResizableArrayBag<String>)bagOne).getIndexOf("d");
        ((ResizableArrayBag<String>)bagOne).getIndexOf("e");
    }
    @Test
    public void testClear()
    {
        bagOne.clear();
    }
    @Test
    public void testGetFrequencyOf()
    {
        bagOne.add(bagOneContents);
        assertEquals(1, bagOne.getFrequencyOf("a"));
        assertEquals(1, bagOne.getFrequencyOf("b"));
        assertEquals(1, bagOne.getFrequencyOf("c"));
        assertEquals(0, bagOne.getFrequencyOf("d"));
        assertEquals(0, bagOne.getFrequencyOf("e"));
        assertEquals(0, bagOne.getFrequencyOf("f"));
    }
    @Test
    public void testContains()
    {
        bagOne.add(bagOneContents);
        assertEquals(true, bagOne.contains("a"));
        assertEquals(true, bagOne.contains("b"));
        assertEquals(true, bagOne.contains("c"));
        assertEquals(false, bagOne.contains("d"));
        assertEquals(false, bagOne.contains("e"));
        assertEquals(false, bagOne.contains("f"));
    }
    @Test
    public void testToArray()
    {
        bagOne.toArray();
    }
    @Test
    public void testCheckIntegrity()
    {
        ((ResizableArrayBag<String>)bagOne).checkIntegrity();
    }
}
