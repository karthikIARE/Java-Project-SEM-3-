import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

class Graph {
    private int vertices; // Number of nodes
    private List<LinkedList<Edge>> adjacencyList; // Adjacency list representation

    // Constructor
    public Graph(int vertices) {
        this.vertices = vertices;
        adjacencyList = new ArrayList<>();
        for (int i = 0; i < vertices; i++) {
            adjacencyList.add(new LinkedList<>());
        }
    }

    // Add an edge to the graph
    public void addEdge(int src, int dest, int weight) {
        adjacencyList.get(src).add(new Edge(dest, weight));
        adjacencyList.get(dest).add(new Edge(src, weight)); // Assuming an undirected graph
    }

    // Get neighbors of a node
    public List<Edge> getNeighbors(int node) {
        return adjacencyList.get(node);
    }

    // Getter for adjacency list
    public List<LinkedList<Edge>> getAdjacencyList() {
        return adjacencyList;
    }

    // Edge representation
    static class Edge {
        int dest;
        int weight;

        Edge(int dest, int weight) {
            this.dest = dest;
            this.weight = weight;
        }
    }
}