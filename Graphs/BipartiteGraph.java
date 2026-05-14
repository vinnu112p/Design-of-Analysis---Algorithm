
import java.util.*;

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
        graph[1].add(new Edge(1, 3)); // Edge from 1 to 2
        graph[2].add(new Edge(2, 0)); // Edge from 2 to 0
        graph[3].add(new Edge(3, 1)); // Edge from 2 to 1
        graph[2].add(new Edge(2, 4)); // Edge from 2 to 1
        graph[4].add(new Edge(4, 2)); // Edge from 2 to 1
        graph[3].add(new Edge(3, 4)); // Edge from 2 to 1
        graph[4].add(new Edge(4, 3)); // Edge from 2 to 1
       
     

       
    }

    public static boolean biparDFS(ArrayList<Edge>[] graph){

        int color[] = new int[graph.length];
        for(int i = 0; i < graph.length; i++){
            color[i] = -1;
        }   

        Queue<Integer> queue = new LinkedList<>();

        for(int i = 0; i < graph.length; i++){
            if(color[i] == -1){
                queue.add(i);
                color[i] = 0;

                while(!queue.isEmpty()){
                    int curr = queue.remove();

                   for(int j = 0; j < graph[curr].size(); j++){
                        Edge e = graph[curr].get(j);

                        if(color[e.des] == -1){
                            int nextColor = color[curr] == 0 ? 1 : 0;
                            color[e.des] = nextColor;
                            queue.add(e.des);
                        }else if(color[curr] == color[e.des]){
                            return false;
                        }
                   }



                }
            }
        }


    return true;


    }




     @SuppressWarnings("unchecked") 
public static void main(String[] args) {
    ArrayList<Edge> graph[] = new ArrayList[7];
    createGraph(graph);
    System.out.println(biparDFS(graph));
    

}
}

