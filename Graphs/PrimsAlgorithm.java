
import java.util.ArrayList;
import java.util.PriorityQueue;

public class PrimsAlgorithm {

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

        graph[0].add(new Edge(0, 1, 10));
        graph[0].add(new Edge(0, 2, 15));
        graph[0].add(new Edge(0, 3, 30));

        graph[1].add(new Edge(1, 0, 10));
        graph[1].add(new Edge(1, 3, 40));

        graph[2].add(new Edge(2, 0, 15));
        graph[2].add(new Edge(2, 3, 50));

        graph[3].add(new Edge(3, 1, 40));
        graph[3].add(new Edge(3, 2, 50));

    }

    static class Pair {
        int v;
        int wt;

        Pair(int v, int wt) {
            this.v = v;
            this.wt = wt;
        }
    }

    public static void prims(ArrayList<Edge>[] graph, int src){
        boolean[] visited = new boolean[graph.length];
        PriorityQueue<Pair> pq = new PriorityQueue<>((a,b) -> a.wt-b.wt);

        pq.add(new Pair(src, 0));
        int minCost = 0;

        while(!pq.isEmpty()){
            Pair curr = pq.remove();

            if(!visited[curr.v]) {
                visited[curr.v] = true;
                minCost += curr.wt;

                for(Edge e : graph[curr.v]) {
                    if(!visited[e.des]) {
                        pq.add(new Pair(e.des, e.wt));
                    }
                }
            }
            
        }

        System.out.println("Minimum Cost: " + minCost);

    }

  

    @SuppressWarnings("unchecked")
    public static void main(String[] args) {
        int V = 4;
        ArrayList<Edge> graph[] = new ArrayList[V];
        createGraph(graph);
        int src = 0;
        prims(graph, src);

    }

}
