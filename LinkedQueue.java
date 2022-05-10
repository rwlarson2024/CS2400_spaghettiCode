import java.util.NoSuchElementException;

/** Class for creating a LinkedQueue object. */
public class LinkedQueue<T> implements QueueInterface<T>
{
    private Node<T> firstNode;
    private Node<T> lastNode;

    /** Default constructor */
    public LinkedQueue()
    {
        firstNode = null;
        lastNode = null;
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

    /** Adds a new entry to the back of the queue.
        @param newEntry  An object to be added to the queue. */
    public void enqueue(T newEntry) 
    {
        Node<T> newNode = new Node<>(newEntry);
        if (isEmpty())
            firstNode = newNode;
        else
            lastNode.setNextNode(newNode);
        lastNode = newNode;
    }

    /** Removes and returns the entry at the front of the queue.
        @return  The object at the front of the queue. 
        @throws  NoSuchElementException if the queue is empty before the operation. */
    public T dequeue() 
    {
        T front = getFront();
        firstNode.setData(null);
        firstNode = firstNode.getNextNode();
        if (firstNode == null)
            lastNode = null;
        return front;
    }

    /** Retrieves the entry at the front of the queue.
        @return  The object at the front of the queue.
        @throws  NoSuchElementException if the queue is empty. */
    public T getFront() 
    {
        if (isEmpty())
            throw new NoSuchElementException();
        else
            return firstNode.getData();
    }

    /** Detects whether the queue is empty.
        @return  True if the queue is empty. */
    public boolean isEmpty() 
    {
        return (firstNode == null) && (lastNode == null);
    }

    /** Removes all entries from the queue. */
    public void clear() 
    {
        firstNode = null;
        lastNode = null;
    }
    
}
