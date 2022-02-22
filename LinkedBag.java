//Initial commit 

package BagPackage;
public class LinkedBag<T> implements BagInterface<T> 
{
    private Node<T> firstNode;
    private int numberOfEntries;

    public LinkedBag()
    {
        firstNode = null;
        numberOfEntries = 0;
    }
    private class Node<T>
    {
        
    }
    public boolean add(T newEntry)
    {
        Node<T> newNode = new Node<>(newEntry);
        newNode.next = firstNode;

        firstNode = newNode;
        numberOfEntries++; 
        return true;
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
    private Node<T> getReferenceTo(T anEntry)
    {
        boolean found = false;
        Node<T> currentNode = firstNode;
        while(!found && (currentNode !=null))
        {
            if(anEntry.equals(currentNode.getData()))
                found = true;
            else
                currentNode = currentNode.getNextNode();
        }
        return currentNode;
    }
    public boolean remove(T anEntry)
    {
        boolean result = false;
        Node<T> nodeN = getReferenceTo(anEntry);
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
        Node<T> currentNode = firstNode;
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
        Node<T> currentNode = firstNode;
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
        T[] result = (T[])new Object[numberOfEntries];
        int index = 0; 
        Node<T> currentNode = firstNode;
        while ((index < numberOfEntries) && (currentNode != null))
        {
            result[index] = currentNode.getData();
            index++;
            currentNode = currentNode.getNextNode();
        }
        return result;
    }

}