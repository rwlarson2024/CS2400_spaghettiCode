import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
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
    private boolean[][] edges; // Adjacency matrix
    private String[] labels; // Adjacency list
	
    /** Default constructor */
	public DirectedGraph()
	{
		vertices = new LinkedHashMap<>();
		edgeCount = 0;
        edges = new boolean[9][9];
        labels = new String[9];
	} // end default constructor

    /** Adds a given vertex to the graph.
        @param  vertexLabel  An object that labels the new vertex and is distinct from the labels of current vertices.
        @return  True if the vertex is added, or false if not. */
    public boolean addVertex(T vertexLabel)
    {
        VertexInterface<T> addOutcome = vertices.put(vertexLabel, new Vertex<>(vertexLabel));
        return addOutcome == null;
    }

    /** Adds a weighted edge between two given distinct vertices that are currently in this graph. 
        The edge points toward the second vertex given.
        @param begin  An object that labels the origin vertex of the edge.
        @param end  An object that labels the end vertex of the edge.
        @param edgeWeight  The value of the edge's weight.
        @return  True if the edge is added, or false if not. */
    public boolean addEdge(T begin, T end, double edgeWeight)
    {
        boolean result = false;
        VertexInterface<T> beginVertex = vertices.get(begin);
        VertexInterface<T> endVertex = vertices.get(end);
        if ((beginVertex != null) && (endVertex != null))
        {
            result = beginVertex.connect(endVertex, edgeWeight);
            edges[getVertexNumber(begin)][getVertexNumber(end)] = true;
        }
        if (result)
            edgeCount++;
        return result;
    }

    /** Adds an unweighted edge between two given distinct vertices that are currently in this graph. 
        In a directed graph, the edge points toward the second vertex given.
        @param begin  An object that labels the origin vertex of the edge.
        @param end  An object that labels the end vertex of the edge.
        @return  True if the edge is added, or false if not. */
    public boolean addEdge(T begin, T end)
    {
        return addEdge(begin, end, 0);
    }

    /** Checks whether an edge exists between two given vertices.
        @param begin  An object that labels the origin vertex of the edge.
        @param end    An object that labels the end vertex of the edge.
        @return  True if an edge exists. */
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

    /** Checks if the graph is empty.
        @return  True if the graph is empty. */
    public boolean isEmpty()
    {
        return vertices.isEmpty();
    }

    /** Gets the number of vertices in the graph.
        @return  The number of vertices in the graph. */
    public int getNumberOfVertices()
    {
        return vertices.size();
    }

    /** Gets the number of edges in the graph.
        @return  The number of edges in the graph. */
    public int getNumberOfEdges()
    {
        return edgeCount;
    }

    /** Removes all vertices and edges from the graph resulting in an empty graph. */
    public void clear()
    {
        vertices.clear();
        edgeCount = 0;
    }

    /** Resets the visited status of all vertices of the graph. */
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

    /** Performs a BFS of the directed graph with a given vertex as its origin.
        @param  vertexLabel  An object that labels the origin vertex.
        @return  A new queue of the resulting breadth-first traversal order. */
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

    /** Performs a DFS of the directed graph with a given vertex as its origin.
        @param  vertexLabel  An object that labels the origin vertex.
        @return  A new queue of the resulting depth-first traversal order. */
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

    /** Retrieves a vertex number that corresponds to the given vertex.
        @param  vertexLabel  An object that labels the given vertex.
        @return  The vertex number. */
    private int getVertexNumber(T vertexLabel)
    {
        String label = (String) vertexLabel;
        int number = 0;
        switch(label)
        {
            case "A" -> number = 0;
            case "B" -> number = 1;
            case "C" -> number = 2;
            case "D" -> number = 3;
            case "E" -> number = 4;
            case "F" -> number = 5;
            case "G" -> number = 6;
            case "H" -> number = 7;
            case "I" -> number = 8;
            default -> number = 0;
        }
        return number;
    }

    /** Retrieves the adjacency matrix of a directed graph. */
    public boolean[][] getAdjacencyMatrix()
    {
        return this.edges;
    }

    /** Creates and displays an adjacency list of a given vertex.
        @param vertexLabel  An object that labels the given vertex. */
    public void getNeighborsList(T vertexLabel)
    {
        int labelNumber = getVertexNumber(vertexLabel);
        int count = 0;
        String[] answer;
        for (int i = 0; i < labels.length; i++)
        {
            if (edges[labelNumber][i])
            {
                count++;
            }
        }
        answer = new String[count];
        count = 0;
        for (int i = 0; i < labels.length; i++)
        {
            if (edges[labelNumber][i])
            {
                answer[count++] = getVertexLabel(i);
            }
        }
        System.out.print("Edge list for vertex " + (String) vertexLabel + ": ");
        for (int i = 0; i < answer.length; i++)
        {
            System.out.print(answer[i] + " ");
        }
        System.out.println();
    }

    /** Retrieves a vertex label that corresponds to the given vertex number.
        @param  vertexNumber  A given vertex number.
        @return  The vertex label. */
    private String getVertexLabel(int vertexNumber)
    {
        String label = "";
        switch(vertexNumber)
        {
            case 0 -> label = "A";
            case 1 -> label = "B";
            case 2 -> label = "C";
            case 3 -> label = "D";
            case 4 -> label = "E";
            case 5 -> label = "F";
            case 6 -> label = "G";
            case 7 -> label = "H";
            case 8 -> label = "I";
            default -> label = "";
        }
        return label;
    }
} // end DirectedGraph
