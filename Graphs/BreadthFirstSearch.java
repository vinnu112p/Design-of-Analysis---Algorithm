import java.util.ArrayList;   // Import ArrayList for dynamic arrays
import java.util.LinkedList;  // Import LinkedList for queue implementation
import java.util.Queue;       // Import Queue interface

public class BreadthFirstSearch {

    // Edge class represents a connection between two vertices in the graph
    static class Edge {
        int src; // Source vertex of the edge
        int des; // Destination vertex of the edge

        // Constructor to initialize source and destination
        public Edge(int s, int d) {
            this.src = s;
            this.des = d;
        }
    }

    // Method to create the graph using adjacency lists
    static void createGraph(ArrayList<Edge> graph[]) {
        // Initialize each element of the graph array with a new ArrayList
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        }

        // Add edges to the graph (undirected graph represented by two directed edges)
        graph[0].add(new Edge(0, 1)); // Edge from 0 to 1
        graph[0].add(new Edge(0, 2)); // Edge from 0 to 2
        graph[1].add(new Edge(1, 0)); // Edge from 1 to 0
        graph[1].add(new Edge(1, 3)); // Edge from 1 to 3
        graph[2].add(new Edge(2, 0)); // Edge from 2 to 0
        graph[2].add(new Edge(2, 4)); // Edge from 2 to 4
        graph[3].add(new Edge(3, 1)); // Edge from 3 to 1
        graph[3].add(new Edge(3, 4)); // Edge from 3 to 4
        graph[3].add(new Edge(3, 5)); // Edge from 3 to 5
        graph[4].add(new Edge(4, 2)); // Edge from 4 to 2
        graph[4].add(new Edge(4, 3)); // Edge from 4 to 3
        graph[4].add(new Edge(4, 5)); // Edge from 4 to 5
        graph[5].add(new Edge(5, 3)); // Edge from 5 to 3
        graph[5].add(new Edge(5, 4)); // Edge from 5 to 4
        graph[5].add(new Edge(5, 6)); // Edge from 5 to 6
        graph[6].add(new Edge(6, 5)); // Edge from 6 to 5
    }

    // Breadth-First Search traversal starting from vertex 0
    public static void BFS(ArrayList<Edge> graph[]) {
        Queue<Integer> q = new LinkedList<>();           // Queue to store vertices to visit
        boolean visited[] = new boolean[graph.length];   // Array to track visited vertices
        q.add(0); // Start BFS from vertex 0

        // Continue until there are no more vertices to visit
        while (!q.isEmpty()) {
            int curr = q.remove(); // Get the next vertex from the queue

            // If the current vertex has not been visited
            if (!visited[curr]) {
                System.out.print(curr + " "); // Print the vertex
                visited[curr] = true;         // Mark it as visited

                // Add all adjacent vertices (neighbors) to the queue
                for (int i = 0; i < graph[curr].size(); i++) {
                    Edge e = graph[curr].get(i); // Get the edge
                    q.add(e.des);                // Add the destination vertex to the queue
                }
            }
        }
    }

    @SuppressWarnings("unchecked") // Suppress unchecked cast warning for ArrayList<Edge>[]
    public static void main(String[] args) {
        int V = 7; // Number of vertices in the graph
        ArrayList<Edge> graph[] = new ArrayList[V]; // Array of adjacency lists
        createGraph(graph); // Build the graph

        // Print the adjacency list for each vertex
        for (int i = 0; i < V; i++) {
            System.out.print("Vertex " + i + ": ");
            for (Edge e : graph[i]) {
                System.out.print("(" + e.src + "-->" + e.des + ") ");
            }
            System.out.println();
        }

        // Perform BFS traversal and print the order of visited vertices
        BFS(graph);
    }
}

// Vertex 0: (0-->1) (0-->2) 
// Vertex 1: (1-->0) (1-->3)
// Vertex 2: (2-->0) (2-->4)
// Vertex 3: (3-->1) (3-->4) (3-->5)
// Vertex 4: (4-->2) (4-->3) (4-->5)
// Vertex 5: (5-->3) (5-->4) (5-->6)
// Vertex 6: (6-->5)