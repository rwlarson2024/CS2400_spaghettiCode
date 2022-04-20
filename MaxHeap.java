import java.util.Arrays;

/** Class for creating a MaxHeap object. */
public class MaxHeap<T extends Comparable<? super T>> implements MaxHeapInterface<T>
{
    private T[] heap;
    private int lastIndex;
    private int swapCount = 0;
    private boolean integrityOK = false;
    private static final int DEFAULT_CAPACITY = 25;
    private static final int MAX_CAPACITY = 10000;

    /** Default constructor */
    public MaxHeap()
    {
        this(DEFAULT_CAPACITY);
    }

    /** Constructor with a given capacity */
    public MaxHeap(int initialCapacity)
    {
        if (initialCapacity < DEFAULT_CAPACITY)
        {
            initialCapacity = DEFAULT_CAPACITY;
        }
        else
        {
            checkCapacity(initialCapacity);
        }
        @SuppressWarnings("unchecked")
        T[] tempHeap = (T[]) new Integer[initialCapacity + 1];
        heap = tempHeap;
        lastIndex = 0;
        integrityOK = true;
    }

    /** Adds a new entry to the heap.
        @param newEntry  An object to be added. */
    public void add(T newEntry)
    {
        checkIntegrity();
        int newIndex = lastIndex + 1;
        int parentIndex = newIndex / 2;
        while ( (parentIndex > 0) && newEntry.compareTo(heap[parentIndex]) > 0)
        {
            heap[newIndex] = heap[parentIndex];
            newIndex = parentIndex;
            parentIndex = newIndex / 2;
            swapCount++;
        }
        heap[newIndex] = newEntry;
        lastIndex++;
        ensureCapacity();
    }

    /** Removes and returns the largest item in the heap.
        @return  The largest object in the heap or, 
                 otherwise null if heap is empty before the operation. */
    public T removeMax()
    {
        checkIntegrity();
        T root = null;
        if (!isEmpty())
        {
            root = heap[1];
            heap[1] = heap[lastIndex];
            lastIndex--;
            reheap(1);
        }
        return root;
    }

    /** Constructor with a given array, used for optimal method */
    public MaxHeap(T[] entries)
    {
        this(entries.length);
        for (int index = 0; index < entries.length; index ++)
        {
            heap[index + 1] = entries[index];
            lastIndex++;
        }
        for(int rootIndex = lastIndex / 2; rootIndex > 0; rootIndex --)
            reheap(rootIndex);
    }

    /** Optimal method for reorganizing the heap. */
    private void reheap(int rootIndex)
    {
        boolean done = false;
        T orphan = heap[rootIndex];
        int leftChildIndex = 2 * rootIndex;
        while (!done && (leftChildIndex <= lastIndex))
        {
            int largerChildIndex = leftChildIndex;
            int rightChildIndex = leftChildIndex + 1;
            if ((rightChildIndex <= lastIndex) && heap[rightChildIndex].compareTo(heap[largerChildIndex]) > 0)
            {
                largerChildIndex = rightChildIndex;
            }
            if (orphan.compareTo(heap[largerChildIndex]) < 0)
            {
                heap[rootIndex] = heap[largerChildIndex];
                rootIndex = largerChildIndex;
                leftChildIndex = 2 * rootIndex;
            }
            else
            {
                done = true;
            }
            swapCount++;
        }
        heap[rootIndex] = orphan;
    }

    /** Retrieves the largest item in the heap.
        @return  The largest object in the heap or, 
                 otherwise null if heap is empty before the operation. */
    public T getMax()
    {
        checkIntegrity();
        T root = null;
        if (!isEmpty())
        {
            root = heap[1];
        }
        return root;
    }

    /** Detects whether the heap is empty.
        @return  True if the heap is empty, or false otherwise. */
    public boolean isEmpty()
    {
        return lastIndex < 1;
    }

    /** Gets the size of the heap.
        @return  The number of entries currently in the heap. */
    public int getSize()
    {
        return lastIndex;
    }

    /** Gets the heap array.
        @return  The heap array. */
    public T[] getArray()
    {
        return this.heap;
    }

    /** Gets the number of swaps after the heap is created.
        @return  The number of swaps. */
    public int getSwapCount()
    {
        return this.swapCount;
    }

    /** Removes all entries from the heap. */
    public void clear()
    {
        checkIntegrity();
        while (lastIndex > -1)
        {
            heap[lastIndex] = null;
            lastIndex--;
        }
        lastIndex = 0;
    }

    /** Ensures that the capacity of the heap array can store enough added entries. */
    private void ensureCapacity()
    {
        if (lastIndex >= heap.length - 1)
        {
            int newLength = 2 * heap.length;
            checkCapacity(newLength);
            heap = Arrays.copyOf(heap, newLength);
        }
    }

    /** Checks that the capacity does not exceed maximum capacity that is available. */
    public void checkCapacity(int capacity)
    {
        if (capacity > MAX_CAPACITY)
            throw new IllegalStateException("Attempt to create a heap array whose capacity"
                    + " exceeds allowed maximum of "
                    + MAX_CAPACITY);
    }

    /** Checks the integrity of the array stack that it is properly created. */
    public void checkIntegrity()
    {
        if (!integrityOK)
            throw new SecurityException("Max heap object is corrupt.");
    }

    /** Extra methods */
    
    public static <T extends Comparable<? super T>> void heapSort(T[] array, int n)
    {
        // Create first heap
        for (int rootIndex = n / 2 - 1; rootIndex >= 0; rootIndex--)
            reheap(array, rootIndex, n - 1);

            //swap(array, 0, n - 1);

        for (int lastIndex = n - 2; lastIndex > 0; lastIndex--)
        {
            reheap(array, 0, lastIndex);
            //swap(array, 0, lastIndex);
        } // end for
    } // end heapSort

    private static <T extends Comparable<? super T>> void reheap(T[] heap, int rootIndex, int lastIndex)
    {
        boolean done = false;
        T orphan = heap[rootIndex];
        int leftChildIndex = 2 * rootIndex + 1;

        while (!done && (leftChildIndex <= lastIndex))
        {
            int largerChildIndex = leftChildIndex;
            int rightChildIndex = leftChildIndex + 1;

            if ( (rightChildIndex <= lastIndex) && heap[rightChildIndex].compareTo(heap[largerChildIndex]) > 0)
            {
                largerChildIndex = rightChildIndex;
            } // end if

            if (orphan.compareTo(heap[largerChildIndex]) < 0)
            {
                heap[rootIndex] = heap[largerChildIndex];
                rootIndex = largerChildIndex;
                leftChildIndex = 2 * rootIndex + 1;
            }
            else
                done = true;
        } // end while
        heap[rootIndex] = orphan;
    } // end reheap

}