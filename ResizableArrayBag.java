import java.util.Arrays;

/** Class for creating a ResizableArrayBag object. */
public class ResizableArrayBag<T> implements BagInterface<T>
{
    private T[] bag;
    private static final int DEFAULT_CAPACITY = 25;
    private static final int MAX_CAPACITY = 10000;
    private boolean integrityOK = false;
    private int numberOfEntries;

    /** Default constructor */
    public ResizableArrayBag()
    {
        numberOfEntries = 0;
        @SuppressWarnings("unchecked")
        T[] tempBag = (T[])new Object[DEFAULT_CAPACITY];
        bag = tempBag;
        integrityOK = true;
    }

    /** Constructor with a given capacity */
    public ResizableArrayBag(int capacity)
    {
        numberOfEntries = 0;
        @SuppressWarnings("unchecked")
        T[] tempBag = (T[])new Object[capacity];
        bag = tempBag;
        integrityOK = true;
    }

    /** Copy constructor */
    public ResizableArrayBag(ResizableArrayBag<T> other)
    {
        @SuppressWarnings("unchecked")
        T[] tempBag = (T[])new Object[other.bag.length];
        for (int index = 0; index < other.bag.length; index++)
        {
            tempBag[index] = other.bag[index];
        }
        this.bag = tempBag;
        //this.bag = Arrays.copyOf(other.toArray(), other.bag.length);;
        this.integrityOK = other.integrityOK;
        this.numberOfEntries = other.numberOfEntries;
    }

    /** Gets the current number of entries in the array bag.
		@return  The integer number of entries currently in the bag. */
    public int getCurrentSize()
    {
        return numberOfEntries;
    }
	
    /** Sees whether the array bag is empty.
        @return  True if the bag is empty, or false if not. */
	public boolean isEmpty()
    {
        return numberOfEntries == 0;
    }

    /** Sees whether the array bag is full.
        @return  True if the bag is full, or false if not. */
    public boolean isFull()
    {   
        return numberOfEntries == bag.length;
    }
	
    /** Adds a new entry to the array bag.
        @param newEntry  The object to be added as a new entry
        @return  True if the addition is successful, or false if not. */
	public boolean add(T newEntry)
    {
        checkIntegrity();
        boolean result = true;
        if(isFull())
        {
            doubleCapacity();
        }
        bag[numberOfEntries] = newEntry;
        numberOfEntries++;  
        return result;
    }

    /** Adds contents of an array to the array bag.
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

    /** Doubles the capacity of the array bag 
        if attempting to add a new entry to a full bag. */
    public void doubleCapacity()
    {
        int newLength = 2 * bag.length;
        checkCapacity(newLength);
        bag = Arrays.copyOf(bag, newLength);
    }

    /** Checks that the capacity does not exceed maximum capacity that is available. */
    public void checkCapacity(int capacity)
    {
        if (capacity > MAX_CAPACITY)
         throw new IllegalStateException("Attempt to create a bag whose capacity" 
                                         + " exeeds allowed maximum of " 
                                         + MAX_CAPACITY);
    }

    /** Removes one unspecified entry from the array bag, if possible.
        @return  Either the removed entry, if the removal.
                 was successful, or null. */
	public T remove()
    {
        checkIntegrity();
        T result = removeEntry(numberOfEntries - 1);
        return result;
    }

    /** Removes one occurrence of a given entry from the array bag, if possible.
        @param anEntry  The entry to be removed.
        @return  True if the removal was successful, or false if not. */
   	public boolean remove(T anEntry)
    {
        checkIntegrity();
        int index = getIndexOf(anEntry);
        T result = removeEntry(index);         
        return anEntry == result;
    }

    /** Removes the entry at a given index within the array bag.
        @param givenIndex  The given index of the array bag.
        @return  The entry at a given index, or null otherwise. */
    public T removeEntry(int givenIndex)
    {
        T result = null;
        if (!isEmpty() && (givenIndex >= 0))
        {
            result = bag[givenIndex];
            bag[givenIndex] = bag[numberOfEntries - 1];
            bag[numberOfEntries - 1] = null;
            numberOfEntries--;
        }
        return result;
    }

    /** Locates a given entry within the array bag, if possible.
        @param anEntry  The entry to get the location of.
        @return  The index of the entry if located, or -1 otherwise. */
    public int getIndexOf(T anEntry)
    {
        int where = -1;
        boolean found = false;
        int index = 0;
        while (!found && (index < numberOfEntries))
        {
            if (anEntry.equals(bag[index]))
            {
                found = true;
                where = index;
            }
            index++;
        } 
        return where;
    }
	
    /** Removes all entries from the array bag. */
    public void clear()
    {
        while (!isEmpty())
        {
            remove();
        }
    }
	
    /** Counts the number of times a given entry appears in the array bag.
		@param anEntry  The entry to be counted.
		@return  The number of times the given entry appears in the bag. */
	public int getFrequencyOf(T anEntry)
    {
        checkIntegrity();
        int counter = 0;
        for (int index = 0; index < numberOfEntries; index++)
        {
            if (anEntry.equals(bag[index]))
            {
                counter++;
            }
        }
        return counter;
    }
	
    /** Tests whether the array bag contains a given entry.
		@param anEntry  The entry to find.
		@return  True if the bag contains the given entry, or false if not. */
	public boolean contains(T anEntry)
    {
        checkIntegrity();
        return getIndexOf(anEntry) >= 0;
    }

    /** Retrieves all entries that are in the array bag.
		@return  A newly allocated array of all the entries in the bag.
                 Note: If the bag is empty, the returned array is empty. */
	public T[] toArray()
    {
        @SuppressWarnings("unchecked")
        T[] result = (T[])new Object[numberOfEntries];
        for (int index = 0; index < numberOfEntries; index++)
        {
            result[index] = bag[index];
        }
        return result;
    }

    /** Checks the integrity of the array bag that it is properly created. */
    public void checkIntegrity()
    {
      if (!integrityOK)
         throw new SecurityException("ArrayBag object is corrupt.");
    }

    /** Displays the objects in the array bag. */
    public void displayBag()
    {
        Object[] temp = this.toArray();
        for (int index = 0; index < temp.length; index++)
        {
            System.out.print(temp[index] + " ");
        }
        System.out.println();
    }
    
    /** Creates a union of two bag objects.
		@param other  The bag to be combined with.
		@return  A newly allocated object of all the entries in the union bag. */
    public BagInterface<T> union(BagInterface<T> other)
    {
        ResizableArrayBag<T> tempBag = new ResizableArrayBag<>();
        T[] temp = this.toArray();
        for (T entry : temp) 
        {
            tempBag.add(entry);
        }
        temp = other.toArray();
        for (T entry : temp) 
        {
            tempBag.add(entry);
        }
        return tempBag;
    }
    
    /** Creates an intersection of two bag objects.
		@param other  The bag to be overlapped with.
		@return  A newly allocated object of all the entries in the intersection bag. */
    public BagInterface<T> intersection(BagInterface<T> other)
    {
        BagInterface<T> tempBag = new ResizableArrayBag<>();
        ResizableArrayBag<T> castedOther = (ResizableArrayBag<T>) other;
        BagInterface<T> copiedBag = new ResizableArrayBag<>(castedOther);
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
   
    /** Creates a difference of two bag objects.
		@param other  The object to be used for the difference.
		@return  A newly allocated object of all the entries in the difference bag. */
    public BagInterface<T> difference(BagInterface<T> other)
    {
        BagInterface<T> tempBag = new ResizableArrayBag<>();
        ResizableArrayBag<T> castedOther = (ResizableArrayBag<T>) other;
        BagInterface<T> copiedBag = new ResizableArrayBag<>(castedOther);
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
