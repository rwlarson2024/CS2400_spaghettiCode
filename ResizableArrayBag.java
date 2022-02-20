import java.util.Arrays;

public class ResizableArrayBag<T> implements BagInterface<T>
{
    private T[] bag;
    private static final int DEFAULT_CAPACITY = 25;
    private static final int MAX_CAPACITY = 10000;
    private boolean integrityOK = false;
    private int numberOfEntries;

    public ResizableArrayBag()
    {
        numberOfEntries = 0;
        @SuppressWarnings("unchecked")
        T[] tempBag = (T[])new Object[DEFAULT_CAPACITY];
        bag = tempBag;
        integrityOK = true;
    }

    public ResizableArrayBag(int capacity)
    {
        numberOfEntries = 0;
        @SuppressWarnings("unchecked")
        T[] tempBag = (T[])new Object[capacity];
        bag = tempBag;
        integrityOK = true;
    }

    public ResizableArrayBag(T[] bag, boolean integrityOK, int numberOfEntries)
    {
        this.bag = bag;
        this.integrityOK = integrityOK;
        this.numberOfEntries = numberOfEntries;
    }

    /*
    public ResizableArrayBag<T> copyResizableArrayBag(ResizableArrayBag<T> other)
    {
        return new ResizableArrayBag<>(other.bag, other.integrityOK, other.numberOfEntries);
    }
    */

    public T[] getBag()
    {
        return bag;
    }

    public boolean getIntegrityOK()
    {
        return integrityOK;
    }

    public int getCurrentSize()
    {
        return numberOfEntries;
    }
	
	public boolean isEmpty()
    {
        return numberOfEntries == 0;
    }

    public boolean isFull()
    {
        return numberOfEntries == bag.length;
    }
	
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

    public boolean add(T[] contents)
    {
        checkIntegrity();
        boolean result = true;
        for (int index = 0; index < contents.length; index++)
        {
            if(isFull())
            {
                doubleCapacity();
            }
            add(contents[index]);
        }
        return result;
    }

    public void doubleCapacity()
    {
        int newLength = 2 * bag.length;
        checkCapacity(newLength);
        bag = Arrays.copyOf(bag, newLength);
    }

    public void checkCapacity(int capacity)
    {
        if (capacity > MAX_CAPACITY)
         throw new IllegalStateException("Attempt to create a bag whose capacity exeeds allowed maximum of " + MAX_CAPACITY);
    }

	public T remove()
    {
        checkIntegrity();
        T result = removeEntry(numberOfEntries - 1);
        return result;
    }

   	public boolean remove(T anEntry)
    {
        checkIntegrity();
        int index = getIndexOf(anEntry);
        T result = removeEntry(index);         
        return anEntry == result;
    }

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

    public int getIndexOf(T anEntry)
    {
        int where = -1;
        boolean found = false;
        int index = 0;
        while (!found && (index < numberOfEntries))
        {
            if (anEntry == (bag[index]))
            {
                found = true;
                where = index;
            }
            index++;
        } 
        return where;
    }
	
	public void clear()
    {
        while (!isEmpty())
        {
            remove();
        }
    }
	
	public int getFrequencyOf(T anEntry)
    {
        checkIntegrity();
        int counter = 0;
        for (int index = 0; index < numberOfEntries; index++)
        {
            if (anEntry == bag[index])
            {
                counter++;
            }
        }
        return counter;
    }
	
	public boolean contains(T anEntry)
    {
        checkIntegrity();
        return getIndexOf(anEntry) >= 0;
    }
   
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

    public void checkIntegrity()
    {
      if (!integrityOK)
         throw new SecurityException("ArrayBag object is corrupt.");
    }
    
    public ResizableArrayBag<T> union(ResizableArrayBag<T> other)
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
    
    public ResizableArrayBag<T> intersection(ResizableArrayBag<T> other)
    {
        ResizableArrayBag<T> tempBag = new ResizableArrayBag<>();
        ResizableArrayBag<T> copiedBag = new ResizableArrayBag<>(other.bag, other.integrityOK, other.numberOfEntries);
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
   
    public ResizableArrayBag<T> difference(ResizableArrayBag<T> other)
    {
        ResizableArrayBag<T> tempBag = new ResizableArrayBag<>();
        ResizableArrayBag<T> copiedBag = new ResizableArrayBag<>(other.bag, other.integrityOK, other.numberOfEntries);
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