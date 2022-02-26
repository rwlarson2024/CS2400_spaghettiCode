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
    public void testgetCurentSize()
    {
        bagOne.add(bagOneContents);
        assertEquals(3,bagOne.getCurrentSize());
        String[] bagOneContentsB = {"a","b","c","d"}; 
        bagOne.add(bagOneContentsB);
        assertEquals(7,bagOne.getCurrentSize());
    }
    @Test
    public void testisEmpty()
    {
        assertEquals(true, bagOne.isEmpty());
    }
    @Test
    public void testisFull()
    {
        assertEquals(false,((ResizableArrayBag<String>)bagOne).isFull());
    }
    @Test
    public void testadd()
    {
        bagOne.add("a");
        bagOne.add("b");
        bagOne.add("c");
    }
    @Test
    public void testaddArray()
    {
        bagOne.add(bagOneContents);
    }
    @Test
    public void testdoubleCapacity()
    {
        ((ResizableArrayBag<String>)bagOne).doubleCapacity();
    }
    @Test
    public void testcheckCapacity()
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
        ((ResizableArrayBag<String>)bagOne).removeEntry(0);
        ((ResizableArrayBag<String>)bagOne).removeEntry(1);
        ((ResizableArrayBag<String>)bagOne).removeEntry(2);
        ((ResizableArrayBag<String>)bagOne).removeEntry(3);
        ((ResizableArrayBag<String>)bagOne).removeEntry(4);
    }
    @Test
    public void testgetIndexOf()
    {
        bagOne.add(bagOneContents);
        ((ResizableArrayBag<String>)bagOne).getIndexOf("a");
        ((ResizableArrayBag<String>)bagOne).getIndexOf("b");
        ((ResizableArrayBag<String>)bagOne).getIndexOf("c");
        ((ResizableArrayBag<String>)bagOne).getIndexOf("d");
        ((ResizableArrayBag<String>)bagOne).getIndexOf("e");
    }
    @Test
    public void testclear()
    {
        bagOne.clear();
    }
    @Test
    public void testgetFrequencyOf()
    {
        bagOne.add(bagOneContents);
        ((ResizableArrayBag<String>)bagOne).getFrequencyOf("a");
        ((ResizableArrayBag<String>)bagOne).getFrequencyOf("b");
        ((ResizableArrayBag<String>)bagOne).getFrequencyOf("c");
        ((ResizableArrayBag<String>)bagOne).getFrequencyOf("d");
        ((ResizableArrayBag<String>)bagOne).getFrequencyOf("e");
        ((ResizableArrayBag<String>)bagOne).getFrequencyOf("f");
    }
    @Test
    public void testcontains()
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
    public void testtoArray()
    {
        bagOne.toArray();
    }
    @Test
    public void testcheckIntegrity()
    {
        ((ResizableArrayBag<String>)bagOne).checkIntegrity();
    }


}

