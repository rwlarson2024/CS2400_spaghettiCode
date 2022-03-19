import java.util.Arrays;
import java.util.EmptyStackException;

/** Class for creating a ResizableArrayStack object. */
public class ResizableArrayStack<T> implements StackInterface<T>
{
    private T[] stack;
    private int topIndex;
    private boolean integrityOK = false;
    private static final int DEFAULT_CAPACITY = 50;
    private static final int MAX_CAPACITY = 10000;

    /** Default constructor */
    public ResizableArrayStack()
    {
        integrityOK = false;
        @SuppressWarnings("unchecked")
        T[] tempStack = (T[])new Object[DEFAULT_CAPACITY];
        stack = tempStack;
        topIndex = -1;
        integrityOK = true;
    }

    /** Constructor with a given capacity */
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

    /** Adds a new entry to the top of the array stack.
        @param newEntry  An object to be added to the stack. */
    public void push(T newEntry)
    {
        checkIntegrity();
        ensureCapacity();
        stack[topIndex + 1] = newEntry;
        topIndex++;
    }
    
    /** Removes and returns the array stack's top entry.
        @return  The object at the top of the stack. 
        @throws  EmptyStackException if the stack is empty before the operation. */
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

    /** Retrieves the array stack's top entry.
        @return  The object at the top of the stack.
        @throws  EmptyStackException if the stack is empty. */
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

    /** Detects whether the array stack is empty.
        @return  True if the stack is empty. */
    public boolean isEmpty()
    {
        return topIndex < 0;
    }

    /** Removes all entries from the array stack. */
    public void clear()
    {
        while (topIndex > -1)
        {
            stack[topIndex] = null;
            topIndex--;
        }
    }

    /** Ensures that the capacity of the array stack can store enough added entries. */
    private void ensureCapacity()
    {
        if (topIndex >= stack.length - 1)
        {
            int newLength = 2 * stack.length;
            checkCapacity(newLength);
            stack = Arrays.copyOf(stack, newLength);
        }
    }

    /** Checks that the capacity does not exceed maximum capacity that is available. */
    public void checkCapacity(int capacity)
    {
        if (capacity > MAX_CAPACITY)
            throw new IllegalStateException("Attempt to create a stack whose capacity"
                    + " exceeds allowed maximum of "
                    + MAX_CAPACITY);
    }

    /** Checks the integrity of the array stack that it is properly created. */
    public void checkIntegrity()
    {
        if (!integrityOK)
            throw new SecurityException("Stack object is corrupt.");
    }

    /** Evaluates a postfix expression.
        @param postfix  A string that is in the postfix expression notation.
        @return  The numerical evaluation of the postfix expression. */
    @SuppressWarnings("unchecked")
    public int evaluatePostfix(String postfix)
    {
        ResizableArrayStack<T> valueStack = new ResizableArrayStack<>(); // Operand stack
        postfix = postfix.replaceAll("\\s", ""); // Removes any possible spaces
        int operandOne, operandTwo;
        int result = 0;
        for (int index = 0; index < postfix.length(); index++) // Loops through each character of the postfix expression
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
                operandTwo = Integer.parseInt((String)valueStack.pop()); // Casts a string type to a T type value,
                operandOne = Integer.parseInt((String)valueStack.pop()); // then converts to integer
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
        return Integer.parseInt((String)valueStack.peek()); // Returns the final numerical result of the postfix expression
    }
}
