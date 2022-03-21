import static org.junit.Assert.*;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

/** A test of several methods as defined in the classes LinkedStack and ResizableArrayStack. */
public class CalculatorTest 
{
    StackInterface<String> Stack = new ResizableArrayStack<>();

    @Test
    public void testPush()
    {
        Stack.push("e");
        assertEquals(Stack.peek(),"e");

    }
    @Test
    public void testPop() 
    {
        Stack.push("a");
        assertEquals("a", Stack.pop() );
    }
    @Test
    public void testPeek() 
    {
        Stack.push("b");
        assertEquals("b", Stack.peek() );
    }
    @Test
    public void testCheckIntegrity()
    {
        ((ResizableArrayStack<String>)Stack).checkIntegrity();
    }
    @Test
    public void testIsEmpty() 
    {
        assertTrue(Stack.isEmpty() );
    }
    @Test
    public void checkIntegrity()
    {
        ((ResizableArrayStack<String>)Stack).checkIntegrity();
    }
}