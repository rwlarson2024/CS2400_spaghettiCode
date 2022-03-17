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
        stack[topIndex + 1] = newEntry;
        topIndex++;
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
        checkIntegrity();
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

    @SuppressWarnings("unchecked")
    public int evaluatePostfix(String postfix)
    {
        ResizableArrayStack<T> valueStack = new ResizableArrayStack<>();
        postfix = postfix.replaceAll("\\s", "");
        int operandOne, operandTwo;
        int result = 0;
        for (int index = 0; index < postfix.length(); index++)
        {
            switch(postfix.substring(index, index + 1))
            {
                case "a":
                valueStack.push((T)"2");
                break;
                    
                case "b":
                valueStack.push((T)"3");
                break;

                case "c":
                valueStack.push((T)"4");
                break;

                case "d":
                valueStack.push((T)"5");
                break;

                case "e":
                valueStack.push((T)"6");
                break;

                case "0": case "1": case "2": case "3": case "4":
                case "5": case "6": case "7": case "8": case "9":
                valueStack.push((T)postfix.substring(index, index + 1));
                break;

                case "+": case "-": case "*": case "/": case "^":
                operandTwo = Integer.parseInt((String)valueStack.pop()); 
                operandOne = Integer.parseInt((String)valueStack.pop());
                switch (postfix.substring(index, index + 1))
                {
                    case "+":
                    result = operandOne + operandTwo;
                    break;
                    case "-":
                    result = operandOne - operandTwo;
                    break;
                    case "*":
                    result = operandOne * operandTwo;
                    break;
                    case "/":
                    result = operandOne / operandTwo;
                    break;
                    case "^":
                    result = (int) Math.pow(operandOne, operandTwo);
                    break;
                    default:
                    break;
                }
                valueStack.push((T)Integer.toString(result));
                break;

                default:
                break;
            }
        }
        return Integer.parseInt((String)valueStack.peek());
    }
}
