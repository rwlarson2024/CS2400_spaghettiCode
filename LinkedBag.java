//Initial commit 
//Can this code work for me?
public class LinkedBag<T> implements BagInterface<T> 
{
    private Node<T> firstNode;
    private int numberOfEntries;
    private boolean integrityOK = false;

    public LinkedBag()
    {
        firstNode = null;
        numberOfEntries = 0;
        integrityOK = true;
    }

    public LinkedBag(LinkedBag<T> other)
    {
        this.integrityOK = other.integrityOK;
        Node<T> currentNode = other.firstNode;
        while (currentNode != null)
        {
            this.add(currentNode.getData());
            currentNode = currentNode.getNextNode();
        }
        this.numberOfEntries = other.numberOfEntries;
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

    public boolean add(T newEntry)
    {
        checkIntegrity();
        boolean result = true;
        Node<T> newNode = new Node<>(newEntry);
        newNode.next = firstNode;

        firstNode = newNode;
        numberOfEntries++; 
        return result;
    }

    public boolean add(T[] contents)
    {
        checkIntegrity();
        boolean result = true;
        for (int index = 0; index < contents.length; index++)
        {
            add(contents[index]);
        }
        return result;
    }

    public T remove()
    {
        checkIntegrity();
        T result = null;
        if (firstNode != null)
        {
            result = firstNode.getData();
            firstNode = firstNode.getNextNode();
            numberOfEntries--;
        }
        return result; 
    }

    public boolean remove(T anEntry)
    {
        checkIntegrity();
        boolean result = false;
        Node<T> nodeN = getReferenceTo(anEntry);
        if (nodeN != null )
        {
            nodeN.setData(firstNode.getData());
            firstNode = firstNode.getNextNode();
            numberOfEntries--;
            result = true;  
        }
        return result; 
    }

    private Node<T> getReferenceTo(T anEntry)
    {
        boolean found = false;
        Node<T> currentNode = firstNode;
        while (!found && (currentNode !=null))
        {
            if (anEntry.equals(currentNode.getData()))
                found = true;
            else
                currentNode = currentNode.getNextNode();
        }
        return currentNode;
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
        checkIntegrity();
        int frequency = 0;
        int counter = 0; 
        Node<T> currentNode = firstNode;
        while ((counter < numberOfEntries) && (currentNode != null))
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
        checkIntegrity();
        boolean found = false;
        Node<T> currentNode = firstNode;
        while (!found && (currentNode != null))
        {
            if (anEntry.equals(currentNode.getData()))
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

    public void checkIntegrity()
    {
        if (!integrityOK)
            throw new SecurityException("LinkedBag object is corrupt.");
    }

    public void displayBag()
    {
        Object[] temp = this.toArray();
        for (int index = 0; index < temp.length; index++)
        {
            System.out.print(temp[index] + " ");
        }
        System.out.println();
    }

    public BagInterface<T> union(BagInterface<T> other)
    {
        LinkedBag<T> tempBag = new LinkedBag<>();
        T[] temp = other.toArray();
        for (T entry : temp) 
        {
            tempBag.add(entry);
        }
        temp = this.toArray();
        for (T entry : temp) 
        {
            tempBag.add(entry);
        }
        return tempBag;
    }

    public BagInterface<T> intersection(BagInterface<T> other)
    {
        BagInterface<T> tempBag = new LinkedBag<>();
        LinkedBag<T> castedOther = (LinkedBag<T>) other;
        BagInterface<T> copiedBag = new LinkedBag<>(castedOther);
        T[] temp = this.toArray();
        for (T entry : temp) 
        {
            if (copiedBag.contains(entry))
            {
                tempBag.add(entry);
                copiedBag.remove(entry);
            }
        }
        return tempBag;
    }

    public BagInterface<T> difference(BagInterface<T> other)
    {
        BagInterface<T> tempBag = new LinkedBag<>();
        LinkedBag<T> castedOther = (LinkedBag<T>) other;
        BagInterface<T> copiedBag = new LinkedBag<>(castedOther);
        T[] temp = this.toArray();
        for (T entry : temp) 
        {
            if (copiedBag.contains(entry))
            {
                copiedBag.remove(entry);
                continue;
            }
            tempBag.add(entry);
        }
        return tempBag;
    }
}