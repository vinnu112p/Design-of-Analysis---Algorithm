import java.util.*;
class TopoDFS{
    static class Edge {

        int src;
        int des;

        Edge(int s, int d) {
            this.src = s;
            this.des = d;
        }
    }

    static void createGraph(ArrayList<Edge> graph[]) {
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        }

        graph[2].add(new Edge(2, 3));
        graph[3].add(new Edge(3, 1));
        graph[4].add(new Edge(4, 0));
        graph[4].add(new Edge(4, 1));
        graph[5].add(new Edge(5, 0));
        graph[5].add(new Edge(5, 2));

    }

    public static void topo(ArrayList<Edge>[] graph, boolean visited[], Stack<Integer> s, int curr) {

        visited[curr] = true;

        for (int i = 0; i < graph[curr].size(); i++) {
            Edge e = graph[curr].get(i);
            if (!visited[e.des]) {
                topo(graph, visited, s, e.des);
            }
        }

        s.push(curr);

    }

    public static void topSort(ArrayList<Edge> graph[]) {
        boolean visited[] = new boolean[graph.length];
        Stack<Integer> s = new Stack<>();

        for (int i = 0; i < graph.length; i++) {
            if (!visited[i]) {
                topo(graph, visited, s, i);
            }
        }

        while (!s.isEmpty()) {
            System.out.print(s.pop() + " ");
        }
    }

 
    @SuppressWarnings("unchecked")
    public static void main(String[] args) {
        int V = 6;
        ArrayList<Edge> graph[] = new ArrayList[V];
        createGraph(graph);
        topSort(graph);
    }

}
