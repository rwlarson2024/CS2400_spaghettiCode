import java.util.Iterator;
import java.util.NoSuchElementException;
/**
   A class that implements the ADT list by using a chain of linked nodes.
   The list has an iterator. The class is similar to LList.
   
   @author Frank M. Carrano
   @author Timothy M. Henry
   @version 5.0
*/
public class LinkedListWithIterator<T> implements ListWithIteratorInterface<T>
{
   private Node firstNode;
   private int numberOfEntries;

   public LinkedListWithIterator()
   {
      firstNode = null;
      numberOfEntries = 0;
   } // end default constructor

/*	< Implementations of the methods of the ADT list go here;
     you can see them in Chapter 12, beginning at Segment 12.7 >
   . . . */
   
   public Iterator<T> iterator()
   {
	   return new IteratorForLinkedList<>();
   } // end iterator

	public Iterator<T> getIterator()
	{
	   return iterator();
	} // end getIterator
   
	private class IteratorForLinkedList<T> implements Iterator<T>
	{
      private Node nextNode;

		private IteratorForLinkedList()
		{
			nextNode = firstNode;
		} // end default constructor

      public boolean hasNext()
      {
         return false;
      }

      public T next()
      {
         return null;
      }
		
      // Implementations of the methods in the interface Iterator go here.

	} // end IteratorForLinkedList
	
	private class Node
	{
      private T    data; // Entry in list
      private Node next; // Link to next node
      
      private Node(T dataPortion)
      {
         data = dataPortion;
         next = null;
      } // end constructor
      
      private Node(T dataPortion, Node nextNode)
      {
         data = dataPortion;
         next = nextNode;
      } // end constructor
      
      private T getData()
      {
         return data;
      } // end getData
      
      private void setData(T newData)
      {
         data = newData;
      } // end setData
      
      private Node getNextNode()
      {
         return next;
      } // end getNextNode
      
      private void setNextNode(Node nextNode)
      {
         next = nextNode;
      } // end setNextNode
	} // end Node

   public void add(T newEntry)
   {
      
   }

   public void add(int newPosition, T newEntry)
   {

   }

   public T remove(int givenPosition)
   {
      return null;
   }

   public void clear() 
   {
      
   }

   public T replace(int givenPosition, T newEntry)
   {
      return null;
   }

   public T getEntry(int givenPosition)
   {
      return null;
   }

   public T[] toArray()
   {
      return null;
   }

   public boolean contains(T anEntry)
   {
      return false;
   }

   public int getLength()
   {
      return 0;
   }

   public boolean isEmpty()
   {
      return false;
   }
} // end LinkedListWithIterator



