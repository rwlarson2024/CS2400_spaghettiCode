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
}