import java.util.Arrays;
import java.util.EmptyStackException;

public class ResizableArrayStack<T> implements StackInterface<T>
{
    private T[] stack;
    private int topIndex;
    private boolean integrityOK = false;
    private static final int DEFAULT_CAPACITY = 50;
    private static final int MAX_CAPACITY = 10000;

    public ResizableArrayStack()
    {
        integrityOK = false;
        @SuppressWarnings("unchecked")
        T[] tempStack = (T[])new Object[DEFAULT_CAPACITY];
        stack = tempStack;
        topIndex = -1;
        integrityOK = true;
    }

    public ResizableArrayStack(int capacity)
    {
        integrityOK = false;
        checkCapacity(capacity);
        @SuppressWarnings("unchecked")
        T[] tempStack = (T[])new Object[capacity];
        stack = tempStack;
        topIndex = -1;
        integrityOK = true;
    }

    public void push(T newEntry)
    {
        checkIntegrity();
        ensureCapacity();
        String castedNewEntry = (String) newEntry;
        for (int index = 0; index < castedNewEntry.length(); index++)
        {
            if (castedNewEntry.substring(index, index + 1) != " ")
            {
                stack[topIndex + 1] = (T) castedNewEntry.substring(index, index + 1);
                topIndex++;
            }
        }
    }
    
    public T pop()
    {
        checkIntegrity();
        if (isEmpty())
        {
            throw new EmptyStackException();
        }
        else
        {
            T top = stack[topIndex];
            stack[topIndex] = null;
            topIndex--;
            return top;
        }
    }

    public T peek()
    {
        if (isEmpty())
        {
            throw new EmptyStackException();
        }
        else
        {
            return stack[topIndex];
        }
    }

    public boolean isEmpty()
    {
        return topIndex < 0;
    }

    public void clear()
    {
        while (topIndex > -1)
        {
            stack[topIndex] = null;
            topIndex--;
        }
    }

    private void ensureCapacity()
    {
        if (topIndex >= stack.length - 1)
        {
            int newLength = 2 * stack.length;
            checkCapacity(newLength);
            stack = Arrays.copyOf(stack, newLength);
        }
    }

    public void checkCapacity(int capacity)
    {
        if (capacity > MAX_CAPACITY)
            throw new IllegalStateException("Attempt to create a stack whose capacity"
                    + " exceeds allowed maximum of "
                    + MAX_CAPACITY);
    }

    public void checkIntegrity()
    {
        if (!integrityOK)
            throw new SecurityException("Stack object is corrupt.");
    }

    public void evaluatePostfix()
    {
        System.out.print("Evaluate postfix method");
    }
}
