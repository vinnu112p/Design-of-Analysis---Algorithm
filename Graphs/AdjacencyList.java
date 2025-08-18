import java.util.ArrayList;

/*
    Visual Structure of the Graph (Adjacency List):

        (5)
     0-------1
     |      /
   (1)   (3)
     |  /
     2-------3
     |    /
   (2)  (1)
     |  /
     4

    Adjacency List Representation:
    0: (0→1, w=5)
    1: (1→0, w=5), (1→2, w=1), (1→3, w=3)
    2: (2→1, w=1), (2→3, w=1), (2→4, w=2)
    3: (3→1, w=3), (3→2, w=1)
    4: (4→2, w=2)
*/

class AdjacencyList {

    // Edge class represents a connection from source to destination with a weight
    static class Edge {
        int src; // Source vertex
        int des; // Destination vertex
        int wgt; // Weight of the edge

        // Constructor to initialize an edge
        public Edge(int s, int d, int w) {
            this.src = s;
            this.des = d;
            this.wgt = w;
        }
    }

    @SuppressWarnings("unchecked") // Suppresses unchecked cast warning for generic array
    public static void main(String[] args) {

        int V = 5; // Number of vertices in the graph

        // Create an array of ArrayLists to represent the adjacency list for each vertex
        ArrayList<Edge>[] graph =  new ArrayList[V];

        // Initialize each vertex's adjacency list
        for (int i = 0; i < V; i++) {
            graph[i] = new ArrayList<>();
        }

        // Add edges to the graph
        // Each edge is added to the adjacency list of its source vertex
        graph[0].add(new Edge(0, 1, 5));      // Edge from 0 to 1 with weight 5
        graph[1].add(new Edge(1, 0, 5));      // Edge from 1 to 0 with weight 5
        graph[1].add(new Edge(1, 2, 1));      // Edge from 1 to 2 with weight 1
        graph[1].add(new Edge(1, 3, 3));      // Edge from 1 to 3 with weight 3
        graph[2].add(new Edge(2, 1, 1));      // Edge from 2 to 1 with weight 1
        graph[2].add(new Edge(2, 3, 1));      // Edge from 2 to 3 with weight 1
        graph[2].add(new Edge(2, 4, 2));      // Edge from 2 to 4 with weight 2
        graph[3].add(new Edge(3, 1, 3));      // Edge from 3 to 1 with weight 3
        graph[3].add(new Edge(3, 2, 1));      // Edge from 3 to 2 with weight 1
        graph[4].add(new Edge(4, 2, 2));      // Edge from 4 to 2 with weight 2

        // Print the adjacency list for each vertex
        for (int i = 0; i < V; i++) {
            System.out.print("Vertex " + i + ": ");
            for (Edge e : graph[i]) {
                System.out.print("(" + e.src + "-->" + e.des + ", w=" + e.wgt + ") ");
            }
            System.out.println();

        }

    }

}