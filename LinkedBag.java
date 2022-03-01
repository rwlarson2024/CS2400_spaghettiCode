/** Class for creating a LinkedBag object. */
public class LinkedBag<T> implements BagInterface<T> 
{
    private Node<T> firstNode;
    private int numberOfEntries;
    private boolean integrityOK = false;

    /** Default constructor */
    public LinkedBag()
    {
        firstNode = null;
        numberOfEntries = 0;
        integrityOK = true;
    }

    /** Copy constructor */
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

    /** Node class for creating nodes */
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

    /** Adds a new entry to the linked bag.
        @param newEntry  The object to be added as a new entry
        @return  True if the addition is successful, or false if not. */
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

    /** Adds contents of an array to the linked bag.
	    @param contents  The objects to be added as new entries.
	    @return  True if the addition is successful, or false if not. */
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

    /** Removes one unspecified entry from the linked bag, if possible.
        @return  Either the removed entry, if the removal.
                 was successful, or null. */
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

    /** Removes one occurrence of a given entry from the linked bag, if possible.
        @param anEntry  The entry to be removed.
        @return  True if the removal was successful, or false if not. */
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

    /** Locates a given entry within the linked bag, if possible.
        @param anEntry  The entry to get the location of.
        @return  A reference to the node containing the entry, or null otherwise. */
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

    /** Sees whether the linked bag is empty.
        @return  True if the bag is empty, or false if not. */
    public boolean isEmpty()
    {
        return numberOfEntries == 0;
    }
    
    /** Gets the current number of entries in the linked bag.
		@return  The integer number of entries currently in the bag. */
    public int getCurrentSize()
    {
        return numberOfEntries;
    }

    /** Removes all entries from the linked bag. */
    public void clear()
    {
        while(!isEmpty())
            remove();
    }

    /** Counts the number of times a given entry appears in the linked bag.
		@param anEntry  The entry to be counted.
		@return  The number of times the given entry appears in the bag. */
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

    /** Tests whether the linked bag contains a given entry.
		@param anEntry  The entry to find.
		@return  True if the bag contains the given entry, or false if not. */
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

    /** Retrieves all entries that are in the linked bag.
		@return  A newly allocated array of all the entries in the bag.
                 Note: If the bag is empty, the returned array is empty. */
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

    /** Checks the integrity of the linked bag that it is properly created. */
    public void checkIntegrity()
    {
        if (!integrityOK)
            throw new SecurityException("LinkedBag object is corrupt.");
    }

    /** Displays the objects in the linked bag. */
    public void displayBag()
    {
        Node<T> currentNode = firstNode;
        while (currentNode != null)
        {
            System.out.print(currentNode.getData() + " ");
            currentNode = currentNode.getNextNode();
        }
        System.out.println();
    }

    /** Creates a union of two bag objects.
		@param other  The bag to be combined with.
		@return  A newly allocated object of all the entries in the union bag. */
    public BagInterface<T> union(BagInterface<T> other)
    {
        LinkedBag<T> tempBag = new LinkedBag<>();
        LinkedBag<T> castedOther = (LinkedBag<T>) other;
        Node<T> currentNode = castedOther.firstNode;
        while (currentNode != null)
        {
            tempBag.add(currentNode.getData());
            currentNode = currentNode.getNextNode();
        }
        currentNode = this.firstNode;
        while (currentNode != null)
        {
            tempBag.add(currentNode.getData());
            currentNode = currentNode.getNextNode();
        }
        return tempBag;

    }

    /** Creates an intersection of two bag objects.
		@param other  The bag to be overlapped with.
		@return  A newly allocated object of all the entries in the intersection bag. */
    public BagInterface<T> intersection(BagInterface<T> other)
    {
        BagInterface<T> tempBag = new LinkedBag<>();
        LinkedBag<T> castedOther = (LinkedBag<T>) other;
        BagInterface<T> copiedBag = new LinkedBag<>(castedOther);
        Node<T> currentNode = this.firstNode;
        while (currentNode != null)
        {
            if (copiedBag.contains(currentNode.getData()))
            {
                tempBag.add(currentNode.getData());
                copiedBag.remove(currentNode.getData());
            }
            currentNode = currentNode.getNextNode();
        } 
        return tempBag;
    }

    /** Creates a difference of two bag objects.
		@param other  The object to be used for the difference.
		@return  A newly allocated object of all the entries in the difference bag. */
    public BagInterface<T> difference(BagInterface<T> other)
    {
        BagInterface<T> tempBag = new LinkedBag<>();
        LinkedBag<T> castedOther = (LinkedBag<T>) other;
        BagInterface<T> copiedBag = new LinkedBag<>(castedOther);
        Node<T> currentNode = this.firstNode;
        while (currentNode != null)
        {
            if (copiedBag.contains(currentNode.getData()))
            {
                copiedBag.remove(currentNode.getData());
            }
            else
            {
                tempBag.add(currentNode.getData());
            }
            currentNode = currentNode.getNextNode();
        } 
        return tempBag;
    }
}
