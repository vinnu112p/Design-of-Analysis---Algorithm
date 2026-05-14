import java.util.*;
class CycleDirec{

    
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


        graph[1].add(new Edge(1, 0));
        graph[0].add(new Edge(0, 2));
        graph[2].add(new Edge(2, 3));
        graph[3].add(new Edge(3, 0));
     

       
    }

    public static boolean isCycle(ArrayList<Edge>[] graph, boolean visi[], boolean stack[], int curr){


        visi[curr] = true;
        stack[curr] = true;

        for(int i = 0; i < graph[curr].size(); i++){
            Edge e = graph[curr].get(i);
            if(stack[e.des]) return true;
            if(!visi[e.des]){
                if(isCycle(graph, visi, stack, e.des)){
                    return true;
                }
            }

        }
        stack[curr] = false;

        return false;


    }

    public static boolean isCycleUtil(ArrayList<Edge>[] graph){
         boolean visi[] = new boolean[graph.length];
    boolean stack[] = new boolean[graph.length];
    
        for(int i = 0; i < graph.length; i++){
            if(!visi[i]){
                if(isCycle(graph, visi, stack, i)){
                    return true;
                }
            }
        }
        return false;
    }


 @SuppressWarnings("unchecked") 
public static void main(String[] args) {
    ArrayList<Edge> graph[] = new ArrayList[4];
    createGraph(graph);
    System.out.println(isCycleUtil(graph));
   

}

}
