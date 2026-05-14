
import java.util.ArrayList;

class CycleUndirected {

    static class Edge {
        int src;
        int des;

        public Edge(int s, int d) {
            this.src = s;
            this.des = d;
        }
    }

     static void createGraph(ArrayList<Edge> graph[]) {
        // Initialize each element of the graph array with a new ArrayList
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        }

        // Add edges to the graph (undirected graph represented by two directed edges)
        graph[0].add(new Edge(0, 1)); // Edge from 0 to 1
        graph[0].add(new Edge(0, 2)); // Edge from 0 to 2
        graph[1].add(new Edge(1, 0)); // Edge from 1 to 0
        graph[1].add(new Edge(1, 2)); // Edge from 1 to 2
        graph[2].add(new Edge(2, 0)); // Edge from 2 to 0
        graph[2].add(new Edge(2, 1)); // Edge from 2 to 1
        graph[0].add(new Edge(0,4)); // Edge from 0 to 4
        graph[4].add(new Edge(4,0)); // Edge from 4 to 0
        graph[5].add(new Edge(5,4)); // Edge from 5 to 4
        graph[4].add(new Edge(4,5)); // Edge from 4 to 5
     

       
    }

    public static boolean cycleUndi(ArrayList<Edge>[] graph, boolean[] visited, int curr, int parent){

        visited[curr] = true;

        for(int i = 0; i < graph[curr].size(); i++){
            Edge e = graph[curr].get(i);
            if(!visited[e.des]){
                if(cycleUndi(graph, visited, e.des, curr)){
                    return true;
                }
            }else if(e.des != parent){
                return true;
            }
        }

        return false;
    
    }

    public static boolean isCycle(ArrayList<Edge>[] graph){

        boolean visited[] = new boolean[graph.length];

        for(int i = 0; i < graph.length; i++){
            if(!visited[i]){
                if(cycleUndi(graph, visited, i, -1)){
                    return true;
                }
            }
        }

        return false;

    }

 @SuppressWarnings("unchecked") 
public static void main(String[] args) {
    ArrayList<Edge> graph[] = new ArrayList[7];
    createGraph(graph);
    System.out.println(isCycle(graph));

}

}
