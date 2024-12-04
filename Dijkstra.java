import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

class Dijkstra {
    public int[] findShortestPath(Graph graph, int source) {
        int vertices = graph.getAdjacencyList().size(); // Use getter method
        int[] distances = new int[vertices];
        boolean[] visited = new boolean[vertices];

        // Initialize distances to infinity and visited to false
        Arrays.fill(distances, Integer.MAX_VALUE);
        distances[source] = 0;

        PriorityQueue<Node> priorityQueue = new PriorityQueue<>(Comparator.comparingInt(node -> node.distance));
        priorityQueue.add(new Node(source, 0));

        while (!priorityQueue.isEmpty()) {
            Node current = priorityQueue.poll();

            if (visited[current.id]) continue;
            visited[current.id] = true;

            for (Graph.Edge edge : graph.getNeighbors(current.id)) {
                int newDist = distances[current.id] + edge.weight;
                if (newDist < distances[edge.dest]) {
                    distances[edge.dest] = newDist;
                    priorityQueue.add(new Node(edge.dest, newDist));
                }
            }
        }

        return distances;
    }

    // Node representation for priority queue
    static class Node {
        int id;
        int distance;

        Node(int id, int distance) {
            this.id = id;
            this.distance = distance;
        }
    }
}