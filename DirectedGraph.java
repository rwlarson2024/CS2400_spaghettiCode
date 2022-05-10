//package GraphPackage;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
//import ADTPackage.*; // Classes that implement various ADTs
/**
   A class that implements the ADT directed graph.
   @author Frank M. Carrano
   @author Timothy M. Henry
   @version 5.0
*/
public class DirectedGraph<T> implements GraphInterface<T>
{
	private Map<T, VertexInterface<T>> vertices;
	private int edgeCount;
    private boolean[][] edges;
	
	public DirectedGraph()
	{
		vertices = new LinkedHashMap<>();
		edgeCount = 0;
        edges = new boolean[9][9];
	} // end default constructor

    public boolean addVertex(T vertexLabel)
    {
        VertexInterface<T> addOutcome = vertices.put(vertexLabel, new Vertex<>(vertexLabel));
        return addOutcome == null;
    }

    public boolean addEdge(T begin, T end, double edgeWeight)
    {
        boolean result = false;
        VertexInterface<T> beginVertex = vertices.get(begin);
        VertexInterface<T> endVertex = vertices.get(end);
        if ((beginVertex != null) && (endVertex != null))
        {
            result = beginVertex.connect(endVertex, edgeWeight);
            edges[getSource(begin)][getEnd(end)] = true;
        }
        if (result)
            edgeCount++;
        return result;
    }

    public boolean addEdge(T begin, T end)
    {
        return addEdge(begin, end, 0);
    }

    public boolean hasEdge(T begin, T end)
    {
        boolean found = false;
        VertexInterface<T> beginVertex = vertices.get(begin);
        VertexInterface<T> endVertex = vertices.get(end);
        if ((beginVertex != null) && (endVertex != null))
        {
            Iterator<VertexInterface<T>> neighbors = beginVertex.getNeighborIterator();
            while (!found && neighbors.hasNext())
            {
                VertexInterface<T> nextNeighbor = neighbors.next();
                if (endVertex.equals(nextNeighbor))
                    found = true;
            }
        }
        return found;
    }

    public boolean isEmpty()
    {
        return vertices.isEmpty();
    }

    public int getNumberOfVertices()
    {
        return vertices.size();
    }

    public int getNumberOfEdges()
    {
        return edgeCount;
    }

    public void clear()
    {
        vertices.clear();
        edgeCount = 0;
    }

    protected void resetVertices()
    {
        Iterator<VertexInterface<T>> vertexIterator = vertices.values().iterator();
        while (vertexIterator.hasNext())
        {
            VertexInterface<T> nextVertex = vertexIterator.next();
            nextVertex.unvisit();
            nextVertex.setCost(0);
            nextVertex.setPredecessor(null);
        }
    }

    public QueueInterface<T> getBreadthFirstTraversal(T origin)
    {
        resetVertices();
        QueueInterface<T> traversalOrder = new LinkedQueue<T>();
        QueueInterface<VertexInterface<T>> vertexQueue = new LinkedQueue<VertexInterface<T>>();
        VertexInterface<T> originVertex = vertices.get(origin);
        originVertex.visit();
        traversalOrder.enqueue(origin);
        vertexQueue.enqueue(originVertex);
        while (!vertexQueue.isEmpty())
        {
            VertexInterface<T> frontVertex = vertexQueue.dequeue();
            Iterator<VertexInterface<T>> neighbors = frontVertex.getNeighborIterator();
            while (neighbors.hasNext())
            {
                VertexInterface<T> nextNeighbor = neighbors.next();
                if (!nextNeighbor.isVisited())
                {
                    nextNeighbor.visit();
                    traversalOrder.enqueue(nextNeighbor.getLabel());
                    vertexQueue.enqueue(nextNeighbor);
                }
            }
        }
        return traversalOrder;
    }

    public QueueInterface<T> getDepthFirstTraversal(T origin)
    {
        resetVertices();
        QueueInterface<T> traversalOrder = new LinkedQueue<>();
        StackInterface<VertexInterface<T>> vertexStack = new LinkedStack<>();
        VertexInterface<T> originVertex = vertices.get(origin);
        originVertex.visit();
        traversalOrder.enqueue(origin);
        vertexStack.push(originVertex);
        while (!vertexStack.isEmpty())
        {
            VertexInterface<T> topVertex = vertexStack.peek();
            VertexInterface<T> nextNeighbor = topVertex.getUnvisitedNeighbor();
            if (nextNeighbor != null)
            {
                nextNeighbor.visit();
                traversalOrder.enqueue(nextNeighbor.getLabel());
                vertexStack.push(nextNeighbor);
            }
            else
                vertexStack.pop();
        }
        return traversalOrder;
    }

    public int getSource(T vertexLabel)
    {
        String label = (String) vertexLabel;
        int source = 0;
        switch(label)
        {
            case "A":
                source = 0;
                break;
            case "B":
                source = 1;
                break;
            case "C":
                source = 2;
                break;
            case "D":
                source = 3;
                break;
            case "E":
                source = 4;
                break;
            case "F":
                source = 5;
                break;
            case "G":
                source = 6;
                break;
            case "H":
                source = 7;
                break;
            case "I":
                source = 8;
                break;
            default:
                break;
        }
        return source;
    }

    public int getEnd(T vertexLabel)
    {
        String label = (String) vertexLabel;
        int end = 0;
        switch(label)
        {
            case "A":
                end = 0;
                break;
            case "B":
                end = 1;
                break;
            case "C":
                end = 2;
                break;
            case "D":
                end = 3;
                break;
            case "E":
                end = 4;
                break;
            case "F":
                end = 5;
                break;
            case "G":
                end = 6;
                break;
            case "H":
                end = 7;
                break;
            case "I":
                end = 8;
                break;
            default:
                break;
        }
        return end;
    }

    public boolean[][] getAdjacencyMatrix()
    {
        return this.edges;
    }
} // end DirectedGraph
