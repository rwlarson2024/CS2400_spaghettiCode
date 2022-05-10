/** 
   An interface of methods that process an existing graph. 
   @author Frank M. Carrano
   @author Timothy M. Henry
   @version 5.0
*/
public interface GraphAlgorithmsInterface<T>
{
   /** Performs a breadth-first traversal of this graph.
       @param origin  An object that labels the origin vertex of the traversal.
       @return  A queue of labels of the vertices in the traversal, with
                the label of the origin vertex at the queue's front. */
   public QueueInterface<T> getBreadthFirstTraversal(T origin);

   /** Performs a depth-first traversal of this graph.
       @param origin  An object that labels the origin vertex of the traversal.
       @return  A queue of labels of the vertices in the traversal, with
                the label of the origin vertex at the queue's front. */
   public QueueInterface<T> getDepthFirstTraversal(T origin);
} // end GraphAlgorithmsInterface
