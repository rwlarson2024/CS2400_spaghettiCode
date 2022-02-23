//Initial commit 
//Can this code work for me?
public class LinkedBag<T> implements BagInterface<T> 
{
    private Node<T> firstNode;
    private int numberOfEntries;

    public LinkedBag()
    {
        firstNode = null;
        numberOfEntries = 0;
    }
    private class Node
    {
        private T data;
        private Node next;
        private Node(T dataPortion)
        {
            this(dataPortion, null);
        }
        private Node(T dataPortion, Node nextNode)
        {
            data = dataPortion;
            next = nextNode;
        }
        private T getData()
        {
            return data;
        }
        private void setData(T newData)
        {
            data = newData;
        }
        private Node getNextNode()
        {
            return next;
        }
        private void setNextNode(Node nextNode)
        {
            next = nextNode;
        }
    }
    public boolean add(T newEntry)
    {
        Node newNode = New Node(newEntry);
        newNode.next = firstNode;

        firstNode = newNode;
        numberOfEntries++; 
        return true
    }
    public T remove()
    {
        T result = null;
        if(firstNode != null)
        {
            result = firstNode.getData();
            firstNode = firstNode.getNextNode();
            numberOfEntries--;
        }
        return result; 
    }
    private Node getReferenceTo(T anEntry)
    {
        boolean found = false;
        Node currentNode = firstNode;
        while(!found && (currentNode !=null))
        {
            if(anEntry.equals(currentNode.getData()))
                found = true;
            else
                currentNode = currentNode.getNextNode();
        }
        return currentNode:
    }
    public boolean remove(T anEntry)
    {
        boolean result = false
        Node nodeN = getReferenceTo(anEntry);
        if(nodeN != null )
        {
            nodeN.setData(firstNode.getData());
            firstNode = firstNode.getNextNode();
                numberOfEntries--;
            result = true;  
        }
        return result; 
    }
    public boolean isEmpty()
    {
        return numberOfEntries == 0;
    }
    public int getCurrentSize()
    {
        return numberOfEntries;
    }
    public void clear()
    {
        while(!isEmpty())
            remove();
    }
    public int getFrequencyOf(T anEntry)
    {
        int frequency = 0;
        int counter = 0; 
        Node currentNode = firstNode;
        while((counter < numberOfEntries)&& (currentNode != null))
        {
            if(anEntry.equals(currentNode.getData()))
            {
                frequency++;
            }
            counter++;
            currentNode = currentNode.getNextNode();
        }
        return frequency;
    }
    public boolean contains(T anEntry)
    {
        boolean found = false;
        Node currentNode = firstNode;
        while (!found &&(currentNode != null))
        {
            if(anEntry.equals(currentNode.getData()))
                found = true;
            else
                currentNode = currentNode.getNextNode();
        }
        return found;
    }
    public T[] toArray()
    {
        @SuppressWarnings("unchecked")
        T[] result = (T[])new object[numberOfEntries];
        int index = 0; 
        node currentNode = firstNode;
        while ((index < numberOfEntries) && (currentNode != null))
        {
            result[index] = currentNode.getData();
            index++;
            curentNode = curentNode.getNextNode();
        }
        return result;
    }

}