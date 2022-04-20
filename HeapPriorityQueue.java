/**
   A class that implements the ADT priority queue by using a maxheap.
   
   @author Frank M. Carrano
   @author Timothy M. Henry
   @version 5.0
*/
public final class HeapPriorityQueue<T extends Comparable<? super T>> implements PriorityQueueInterface<T>
{
	private MaxHeapInterface<T> pq;	
	
	public HeapPriorityQueue()
	{
		pq = new MaxHeap<>();
	} // end default constructor

    public HeapPriorityQueue(int initialCapacity)
	{
		pq = new MaxHeap<>(initialCapacity);
	} 
	
	public void add(T newEntry)
	{ 
		pq.add(newEntry);
	} // end add

    public T remove()
    {
        return pq.removeMax();
    }

    public T peek()
    {
        // Don't think this is right
        return pq.getMax();
    }

    public boolean isEmpty()
    {
        return pq.isEmpty();
    }

    public int getSize()
    {
        return pq.getSize();
    }

    public void clear()
    {
        pq.clear();
    }

/* < Implementations of remove, peek, isEmpty, getSize, and clear are here. >
   . . . */
} // end HeapPriorityQueue
