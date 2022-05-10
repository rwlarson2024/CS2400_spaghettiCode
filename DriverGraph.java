/** Driver code containing main method for graph representations and traversals.  */
public class DriverGraph
{
    public static void main(String[]args)
    {
        DirectedGraph<String> graph = new DirectedGraph<>();
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

        System.out.print("Adjacency Matrix \n");
        boolean[][] matrix = graph.getAdjacencyMatrix();
        char c = 'A';
        System.out.println("  A B C D E F G H I");
        for (int i = 0; i <= 8; i++)
        {
            System.out.print(c + " ");
            for (int j = 0; j <= 8; j++)
            {
                if (matrix[i][j] == true)
                    System.out.print("T ");
                else
                    System.out.print("F ");
            }
            System.out.println();
            c++;
        }

        System.out.println();

        System.out.print("Adjacency Lists \n");
        graph.getNeighborsList("A");
        graph.getNeighborsList("B");
        graph.getNeighborsList("C");
        graph.getNeighborsList("D");
        graph.getNeighborsList("E");
        graph.getNeighborsList("F");
        graph.getNeighborsList("G");
        graph.getNeighborsList("H");
        graph.getNeighborsList("I");

        System.out.println();

        System.out.print("This is the Breadth First Traversal \n");
        QueueInterface<String> breadthFirstTraversalOrder = graph.getBreadthFirstTraversal("A");
        while (!breadthFirstTraversalOrder.isEmpty())
        {
            System.out.print(breadthFirstTraversalOrder.dequeue() + " ");
        }

        System.out.println("\n");

        System.out.print("This is the Depth First Traversal \n");
        QueueInterface<String> depthFirstTraversalOrder = graph.getDepthFirstTraversal("A");
        while (!depthFirstTraversalOrder.isEmpty())
        {
            System.out.print(depthFirstTraversalOrder.dequeue() + " ");
        }
    }
}
