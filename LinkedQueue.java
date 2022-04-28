import java.util.NoSuchElementException;

public class LinkedQueue<T> implements QueueInterface<T>
{
    private Node<T> firstNode;
    private Node<T> lastNode;

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

    public void enqueue(T newEntry) 
    {
        Node<T> newNode = new Node<>(newEntry, null);
        if (isEmpty())
            firstNode = newNode;
        else
            lastNode.setNextNode(newNode);
        lastNode = newNode;
    }

    public T dequeue() 
    {
        T front = getFront();
        firstNode.setData(null);
        firstNode = firstNode.getNextNode();
        if (firstNode == null)
            lastNode = null;
        return front;
    }

    public T getFront() 
    {
        if (isEmpty())
            throw new NoSuchElementException();
        else
            return firstNode.getData();
    }

    public boolean isEmpty() 
    {
        return (firstNode == null) && (lastNode == null);
    }

    public void clear() 
    {
        firstNode = null;
        lastNode = null;
    }
    
}
