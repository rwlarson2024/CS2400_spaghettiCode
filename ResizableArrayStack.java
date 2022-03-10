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

    public void evaluatePostfix()
    {
        System.out.print("Evaluate postfix method");
    }

    @SuppressWarnings("unchecked")
    public String convertToPostfix(String infix)
    {
        ResizableArrayStack<T> operatorStack = new ResizableArrayStack<>();
        infix = infix.replaceAll("\\s", "");
        String postfix = "";
        for (int index = 0; index < infix.length(); index++)
        {
            switch(infix.substring(index, index + 1))
            {
                case "a": case "b": case "c": case "d": case "e": case "f": case "g":
                case "h": case "i": case "j": case "k": case "l": case "m": case "n":
                case "o": case "p": case "q": case "r": case "s": case "t":
                case "u": case "v": case "w": case "x": case "y": case "z":
                postfix += infix.substring(index, index + 1);
                break;

                case "^": case "+": case "-": case "*": case "/":
                while (!operatorStack.isEmpty() && precedenceOf(infix.substring(index, index + 1)) <= precedenceOf((String) operatorStack.peek()))
                {
                    postfix += operatorStack.peek();
                    operatorStack.pop();
                }
                operatorStack.push((T) infix.substring(index, index + 1));
                break;

                case "(":
                operatorStack.push((T) infix.substring(index, index + 1));
                break;

                case ")":
                while (!operatorStack.isEmpty() && !operatorStack.peek().equals("("))
                {
                    postfix += operatorStack.peek();
                    operatorStack.pop();
                }
                operatorStack.pop();
                break;

                default:
                break;
            }
        }
        while (!operatorStack.isEmpty())
        {
            postfix += operatorStack.peek();
            operatorStack.pop();
        }
        return postfix;
    }

    private int precedenceOf(String operator)
    {
        switch(operator)
        {
            case "^":
            return 2;
            case "*": case "/":
            return 1;
            case "+": case "-":
            return 0;
            default:
            return -1;
        }
    }
}
