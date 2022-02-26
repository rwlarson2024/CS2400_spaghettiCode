//Commiting on 2/22/2022

import static org.junit.Assert.*;
import org.junit.Test;

public class LinkedBagTest 
{
    BagInterface<String> bagOne = new LinkedBag<>();
    String[] bagOneContents = {"a", "b", "b", "c"};

    @Test
    public void testIsEmpty()
    {
        assertEquals(true, bagOne.isEmpty());
    }

    @Test
    public void testAdd()
    {
        assertEquals(true, bagOne.add(bagOneContents));
    }

    @Test
    public void testRemove()
    {
        bagOne.add(bagOneContents);
        assertEquals("c", bagOne.remove());
    }

    @Test
    public void testRemoveEntry()
    {
        bagOne.add(bagOneContents);
        assertEquals(true, bagOne.remove("b"));
    }

    @Test
    public void testGetCurrentSize()
    {
        bagOne.add(bagOneContents);
        assertEquals(4, bagOne.getCurrentSize());
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
        assertEquals(2, bagOne.getFrequencyOf("b"));
    }

    @Test
    public void testContains()
    {
        bagOne.add(bagOneContents);
        assertEquals(false, bagOne.contains("d"));
    }

    @Test
    public void testToArray()
    {
        bagOne.toArray();
    }

    @Test
    public void testDisplayBag()
    {
        bagOne.displayBag();
    }
}
