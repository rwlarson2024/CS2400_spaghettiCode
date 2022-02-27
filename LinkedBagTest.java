//Commiting on 2/22/2022
import static org.junit.Assert.*;
import org.junit.Test;
public class LinkedBagTest 
{
    BagInterface<String> bagOne = new LinkedBag<>();
    String[] bagOneContents = {"a","b","c"};
    BagInterface<String> bagTwo = new LinkedBag<>();
    @Test
    public void testGetCurrentSize()
    {
        bagOne.add(bagOneContents);
        assertEquals(3,bagOne.getCurrentSize());
        String[] bagTwoContents = {"b","b","c","d","d"}; 
        bagOne.add(bagTwoContents);
        assertEquals(8,bagOne.getCurrentSize());
    }
    @Test
    public void testAdd()
    {
        assertEquals(true, bagOne.add("b"));
        assertEquals(true, bagOne.add("b"));
        assertEquals(true, bagOne.add("c"));
        assertEquals(true, bagOne.add("d"));
    }
    @Test
    public void testRemove()
    {
        bagOne.add(bagOneContents);
        assertEquals(true, bagOne.remove("b"));
        assertEquals(true, bagOne.remove("c"));
        assertEquals(false, bagOne.remove("d"));
    }
    @Test
    public void testContains()
    {
        bagOne.add(bagOneContents);
        assertEquals(true, bagOne.contains("a"));
        assertEquals(true, bagOne.contains("b"));
        assertEquals(false, bagOne.contains("y"));
        assertEquals(false, bagOne.contains("z"));
    }
}
