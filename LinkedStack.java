import java.util.EmptyStackException;

public class LinkedStack<T> implements StackInterface<T>
{
    private Node<T> topNode;
    
    public LinkedStack()
    {
        topNode = null;
    }

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

    public void push(T newEntry)
    {
        Node<T> newNode = new Node<>(newEntry, topNode);
        topNode = newNode;
        //topNode = new Node(newEntry, topNode); // alt code
    }

    public T pop()
    {
        T top = peek();
        topNode = topNode.getNextNode();
        return top;    
    }

    public T peek()
    {
        if(isEmpty())
            throw new EmptyStackException();
        else
            return topNode.getData();
    }

    public boolean isEmpty()
    {
        return topNode == null;
    }

    public void clear()
    {
        topNode = null;
    }

    @SuppressWarnings("unchecked")
    public String convertToPostfix(String infix)
    {
        LinkedStack<T> operatorStack = new LinkedStack<>();
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