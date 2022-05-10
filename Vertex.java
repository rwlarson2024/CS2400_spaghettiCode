import java.util.Iterator;
import java.util.NoSuchElementException;
/**
 A class of vertices for a graph.
 @author Frank M. Carrano
 @author Timothy M. Henry
 @version 5.0
 */
class Vertex<T> implements VertexInterface<T>
{
    private T label;
    private ListWithIteratorInterface<Edge> edgeList; // Edges to neighbors
    private boolean visited;                          // True if visited
    private VertexInterface<T> previousVertex;        // On path to this vertex
    private double cost;                              // Of path to this vertex
    
    /** Default constructor */
    public Vertex(T vertexLabel)
    {
        label = vertexLabel;
        edgeList = new LinkedListWithIterator<>();
        visited = false;
        previousVertex = null;
        cost = 0;
    } // end constructor

    /** Gets the vertex's label.
        @return  The object that labels the vertex. */
    public T getLabel()
    {
        return label;
    }

    /** Marks the vertex as visited. */
    public void visit()
    {
        visited = true;
    }

    /** Removes the vertex's visited mark. */
    public void unvisit()
    {
        visited = false;
    }

    /** Checks if the vertex is marked as visited.
        @return  True if the vertex is visited. */
    public boolean isVisited()
    {
        return visited;
    }

    /** Connects the vertex and a given vertex with a weighted edge.
        In a directed graph, the edge points toward the given vertex.
        @param endVertex   A vertex in the graph that ends the edge.
        @param edgeWeight  An edge weight, if any.
        @return  True if the edge is added, or false if not. */
    public boolean connect(VertexInterface<T> endVertex, double edgeWeight)
    {
        boolean result = false;
        if (!this.equals(endVertex))
        {
            Iterator<VertexInterface<T>> neighbors = getNeighborIterator();
            boolean duplicateEdge = false;
            while (!duplicateEdge && neighbors.hasNext())
            {
                VertexInterface<T> nextNeighbor = neighbors.next();
                if (endVertex.equals(nextNeighbor))
                {
                    duplicateEdge = true;
                    break;
                }
            }
            if (!duplicateEdge)
            {
                edgeList.add(new Edge(endVertex, edgeWeight));
                result = true;
            }
        }
        return result;
    }

    /** Connects the vertex and a given vertex with an unweighted edge.
        In a directed graph, the edge points toward the given vertex.
        @param endVertex   A vertex in the graph that ends the edge.
        @return  True if the edge is added, or false if not. */
    public boolean connect(VertexInterface<T> endVertex)
    {
        return connect(endVertex, 0);
    }

    /** Creates an iterator of the vertex's neighbors by following all edges that begin at the vertex.
        @return  An iterator of the neighboring vertices of the vertex. */
    public Iterator<VertexInterface<T>> getNeighborIterator()
    {
        return new NeighborIterator();
    }

    /** Creates an iterator of the weights of the edges to the vertex's neighbors.
    @return  An iterator of edge weights for edges to neighbors of the vertex. */
    public Iterator<Double> getWeightIterator()
    {
        return new WeightIterator();
    }

    /** Checks if the vertex has at least one neighbor.
        @return  True if the vertex has a neighbor. */
    public boolean hasNeighbor()
    {
        return !(edgeList.isEmpty());
    }

    /** Retrieves an unvisited neighbor, if any, of the vertex.
        @return  Either a vertex that is an unvisited neighbor or null if no such neighbor exists. */
    public VertexInterface<T> getUnvisitedNeighbor()
    {
        VertexInterface<T> result = null;
		Iterator<VertexInterface<T>> neighbors = getNeighborIterator();
		while(neighbors.hasNext() && result == null)
        {
			VertexInterface<T> nextNeighbor = neighbors.next();
			if(!nextNeighbor.isVisited())
				result = nextNeighbor;
		}
		return result;
    }

    /** Records the previous vertex on a path to the vertex.
        @param predecessor  The vertex previous to the one along a path. */
    public void setPredecessor(VertexInterface<T> predecessor)
    {
        previousVertex = predecessor;
    }

    /** Retrieves the recorded predecessor of the vertex.
        @return  Either the vertex's predecessor or null if no predecessor was recorded. */
    public VertexInterface<T> getPredecessor()
    {
        return previousVertex;
    }

    /** Checks if a predecessor was recorded for the vertex.
        @return  True if a predecessor was recorded. */
    public boolean hasPredecessor()
    {
        return previousVertex != null;
    }

    /** Records the cost of a path to the vertex.
        @param newCost  The cost of the path. */
    public void setCost(double newCost)
    {
        cost = newCost;
    }

    /** Retrieves the recorded cost of the path to the vertex.
        @return  The cost of the path. */
    public double getCost()
    {
        return cost;
    }

    /** Class that implements edges */
    protected class Edge
    {
        private VertexInterface<T> vertex; // Vertex at end of edge
        private double weight;
        
        protected Edge(VertexInterface<T> endVertex, double edgeWeight)
        {
            vertex = endVertex;
            weight = edgeWeight;
        } // end constructor
        
        protected Edge(VertexInterface<T> endVertex)
        {
            vertex = endVertex;
            weight = 0;
        } // end constructor

        protected VertexInterface<T> getEndVertex()
        {
            return vertex;
        } // end getEndVertex
        
        protected double getWeight()
        {
            return weight; 
        } // end getWeight
        } // end Edge

    /** Class that implements the iterator of the vertex's neighbors */
    private class NeighborIterator implements Iterator<VertexInterface<T>>
    {
        private Iterator<Edge> edges;

        private NeighborIterator()
        {
            edges = edgeList.getIterator();
        }

        public boolean hasNext()
        {
            return edges.hasNext();
        }

        public VertexInterface<T> next()
        {
            VertexInterface<T> nextNeighbor = null;
            if (edges.hasNext())
            {
                Edge edgeToNextNeighbor = edges.next();
                nextNeighbor = edgeToNextNeighbor.getEndVertex();
            }
            else
                throw new NoSuchElementException();
            return nextNeighbor;
        }
    }

    /** Class that impelements the iterator of the weights of the edges to the vertex's neighbors */
    private class WeightIterator implements Iterator<Double>
    {
        private Iterator<Edge> edges;

        private WeightIterator()
        {
            edges = edgeList.getIterator();
        }

        public boolean hasNext()
        {
            return edges.hasNext();
        }

        public Double next()
        {
            double weight;
            if (edges.hasNext())
            {
                Edge edgeToNextNeighbor = edges.next();
                weight = edgeToNextNeighbor.getWeight();
            }
            else
                throw new NoSuchElementException();
            return weight;
        }
    }
} // end Vertex
