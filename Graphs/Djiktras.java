
import java.util.ArrayList;
import java.util.PriorityQueue;

public class Djiktras {

    static class Edge {

        int src;
        int des;
        int wt;

        Edge(int s, int d, int w) {
            this.src = s;
            this.des = d;
            this.wt = w;
        }

    }

    static void createGraph(ArrayList<Edge> graph[]) {
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        }

        graph[0].add(new Edge(0, 1, 2));
        graph[0].add(new Edge(0, 2, 4));
        graph[1].add(new Edge(1, 3, 7));
        graph[1].add(new Edge(1, 2, 1));
        graph[2].add(new Edge(2, 4, 3));
        graph[3].add(new Edge(3, 5, 1));
        graph[4].add(new Edge(4, 3, 2));
        graph[4].add(new Edge(4, 5, 5));
    }

    static class Pair implements Comparable<Pair> {

        int n;
        int path;

        public Pair(int n, int p) {
            this.n = n;
            this.path = p;
        }

        @Override
        public int compareTo(Pair p2) {
            return this.path - p2.path;
        }

    }

    static void Dijkstra(ArrayList<Edge> graph[], int src) {

        int dist[] = new int[graph.length];
        boolean visited[] = new boolean[graph.length];
        for (int i = 0; i < graph.length; i++) {
            if (i != src) {
                dist[i] = Integer.MAX_VALUE;
            }
        }

        PriorityQueue<Pair> pq = new PriorityQueue<>();
        pq.add(new Pair(src, 0));
        while (!pq.isEmpty()) {
            Pair curr = pq.remove();
            if (!visited[curr.n]) {
                visited[curr.n] = true;
                for (int i = 0; i < graph[curr.n].size(); i++) {
                    Edge e = graph[curr.n].get(i);
                    int u = e.src;
                    int v = e.des;
                    int wt = e.wt;

                    if (dist[u] + wt < dist[v]) {
                        dist[v] = dist[u] + wt;
                        pq.add(new Pair(e.des, dist[v]));
                    }
                }
            }
        }

        for (int i = 0; i < dist.length; i++) {
            System.out.println(dist[i] + " ");
        }

    }

    @SuppressWarnings("unchecked")
    public static void main(String[] args) {
        int V = 6;
        ArrayList<Edge> graph[] = new ArrayList[V];
        createGraph(graph);
        int src = 0;
        Dijkstra(graph, src);

    }

}

//  Edges and their weights (directions are left to right as per arrows):
//     - 0 → 1 (weight 2)
//     - 0 → 2 (weight 4)
//     - 1 → 3 (weight 7)
//     - 1 → 2 (weight 1)
//     - 2 → 4 (weight 3)
//     - 3 → 5 (weight 1)
//     - 4 → 3 (weight 2)
//     - 4 → 5 (weight 5)

//     The source vertex for Dijkstra's algorithm is 0.
