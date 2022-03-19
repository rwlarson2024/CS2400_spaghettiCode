import java.util.EmptyStackException;

/** Class for creating a LinkedStack object. */
public class LinkedStack<T> implements StackInterface<T>
{
    private Node<T> topNode;
    
    /** Default constructor */
    public LinkedStack()
    {
        topNode = null;
    }

    /** Private class for creating nodes */
    private class Node<T>
    {
        private T data;
        private Node<T> next;
        Node(T dataPortion)
        {
            this(dataPortion, null);
        }
        Node(T dataPortion, Node<T> nextNode)
        {
            data = dataPortion;
            next = nextNode;
        }
        T getData()
        {
            return data;
        }
        void setData(T newData)
        {
            data = newData;
        }
        Node<T> getNextNode()
        {
            return next;
        }
        void setNextNode(Node<T> nextNode)
        {
            next = nextNode;
        }
    }

    /** Adds a new entry to the top of the linked stack.
        @param newEntry  An object to be added to the stack. */
    public void push(T newEntry)
    {
        Node<T> newNode = new Node<>(newEntry, topNode);
        topNode = newNode;
        //topNode = new Node(newEntry, topNode); // alt code
    }

    /** Removes and returns the linked stack's top entry.
        @return  The object at the top of the stack. 
        Note: May throw EmptyStackException if stack is empty. */
    public T pop()
    {
        T top = peek();
        topNode = topNode.getNextNode();
        return top;    
    }

    /** Retrieves the linked stack's top entry.
        @return  The object at the top of the stack.
        @throws  EmptyStackException if the stack is empty. */
    public T peek()
    {
        if(isEmpty())
            throw new EmptyStackException();
        else
            return topNode.getData();
    }

    /** Detects whether the linked stack is empty.
        @return  True if the stack is empty. */
    public boolean isEmpty()
    {
        return topNode == null;
    }

    /** Removes all entries from the linked stack. */
    public void clear()
    {
        topNode = null;
    }

    /** Converts an infix expression into a postfix expression.
        @param infix  A string that is in the infix expression notation.
        @return  The string of the postfix expression. */
    @SuppressWarnings("unchecked")
    public String convertToPostfix(String infix)
    {
        LinkedStack<T> operatorStack = new LinkedStack<>(); // Operator stack
        infix = infix.replaceAll("\\s", ""); // Removes any possible spaces
        String postfix = "";
        for (int index = 0; index < infix.length(); index++) // Loops through each character of the infix expression
        {
            switch(infix.substring(index, index + 1))
            {
                case "a": case "b": case "c": case "d": case "e": case "f": case "g":
                case "h": case "i": case "j": case "k": case "l": case "m": case "n":
                case "o": case "p": case "q": case "r": case "s": case "t":
                case "u": case "v": case "w": case "x": case "y": case "z":
                case "0": case "1": case "2": case "3": case "4":
                case "5": case "6": case "7": case "8": case "9":
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
        return postfix; // Returns the postfix expression that was converted from an infix expression
    }

    /** Returns the precedence of a math operator according to the order of operations.
        @param operator  The math operator.
        @return  The numerical precedence of the math operator. */
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