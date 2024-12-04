public class PowerRouteFinder {
    public static void main(String[] args) {
        // Create a graph with 6 nodes (example)
        Graph graph = new Graph(6);
        graph.addEdge(0, 1, 4);
        graph.addEdge(0, 2, 2);
        graph.addEdge(1, 2, 5);
        graph.addEdge(1, 3, 10);
        graph.addEdge(2, 4, 3);
        graph.addEdge(4, 3, 4);
        graph.addEdge(3, 5, 11);

        // Find shortest paths from source node 0
        Dijkstra dijkstra = new Dijkstra();
        int[] shortestPaths = dijkstra.findShortestPath(graph, 0);

        // Print results
        System.out.println("Shortest distances from source:");
        for (int i = 0; i < shortestPaths.length; i++) {
            System.out.println("To node " + i + ": " + shortestPaths[i]);
        }
    }
}