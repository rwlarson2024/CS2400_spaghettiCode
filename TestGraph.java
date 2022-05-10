import static org.junit.Assert.*;
import org.junit.Test;


/** A test of several methods as defined in the DirectedGraph class.**/
public class TestGraph
{
    DirectedGraph<String> testGraph = new DirectedGraph<>();

    public static void createGraph(DirectedGraph<String> graph)
    {
        graph.addVertex("A");
        graph.addVertex("B");
        graph.addVertex("C");
        graph.addVertex("D");
        graph.addVertex("E");
        graph.addVertex("F");
        graph.addVertex("G");
        graph.addVertex("H");
        graph.addVertex("I");

        graph.addEdge("A", "B");
        graph.addEdge("A", "D");
        graph.addEdge("A", "E");
        graph.addEdge("B", "E");
        graph.addEdge("D", "G");
        graph.addEdge("E", "F");
        graph.addEdge("E", "H");
        graph.addEdge("G", "H");
        graph.addEdge("F", "C");
        graph.addEdge("F", "H");
        graph.addEdge("H", "I");
        graph.addEdge("C", "B");
        graph.addEdge("I", "F");
    }

    @Test
    public void testgetNumberOfVertices()
    {
        createGraph(testGraph);
        assertEquals(9, testGraph.getNumberOfVertices());
    }

    @Test
    public void testgetNumberOfNodes()
    {
        createGraph(testGraph);
        assertEquals(13, testGraph.getNumberOfEdges());
    }

    @Test
    public void testIsEmpty()
    {
        assertEquals(true, testGraph.isEmpty());
        createGraph(testGraph);
        assertEquals(false, testGraph.isEmpty());
    }


    @Test
    public void testHasEdge()
    {
        createGraph(testGraph);
        assertEquals(true, testGraph.hasEdge("A","B"));
        assertEquals(true, testGraph.hasEdge("B","E"));
        assertEquals(true, testGraph.hasEdge("G","H"));
        assertEquals(true, testGraph.hasEdge("F","C"));
        assertEquals(true, testGraph.hasEdge("I","F"));
    }
}