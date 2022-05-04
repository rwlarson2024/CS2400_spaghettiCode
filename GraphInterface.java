//package GraphPackage;
/**
   An interface of methods that create, manipulate, and process a graph.
   
   @author Frank M. Carrano
   @author Timothy M. Henry
   @version 5.0
*/
public interface GraphInterface<T> extends BasicGraphInterface<T>, GraphAlgorithmsInterface<T>
{
   public boolean addVertex(T vertexLabel);
   public boolean addEdge(T begin, T end, double edgeWeight);
   public boolean addEdge(T begin, T end);
   public boolean isEmpty();
   public int getNumberOfVertices();
   public int getNumberOfEdges();
   public void clear();
} // end GraphInterface
