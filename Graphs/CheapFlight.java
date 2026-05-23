import java.util.*;

public class CheapFlight {

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

    public static void createGraph(int[][] edges, ArrayList<Edge>[] graph){
        for(int i = 0; i < graph.length; i++){
            graph[i] = new ArrayList<>();
        }

        for(int[] edge : edges){
            graph[edge[0]].add(new Edge(edge[0],edge[1],edge[2]));
        }

    }

    static class Pair{
        int ds;
        int price;
        int k;

        Pair(int ds, int price, int k){
            this.ds = ds;
            this.price = price;
            this.k = k;
        }
    }

    public static void cheap(ArrayList<Edge>[] graph, int sr, int dst, int k){
        int dis[] = new int[graph.length];
        for(int i = 0; i < graph.length; i++){
            if(sr!= i){
                dis[i] = Integer.MAX_VALUE;
            }
        }

        Queue<Pair> queue = new LinkedList<>();

        queue.add(new Pair(sr, 0, 0));

        while(!queue.isEmpty()){
            Pair curr = queue.poll();

            if(curr.k > k){
                continue;
            }

            for(Edge e : graph[curr.ds]){
                int u = e.src;
                int v = e.des;
                int wt = e.wt;

                if(curr.price + wt < dis[v] && curr.k <= k){
                    dis[v] = curr.price + wt;
                    queue.add(new Pair(v, dis[v], curr.k + 1));
                }
            }
        }
        
    System.out.println(dis[dst] == Integer.MAX_VALUE ? -1 : dis[dst]);  
    }


   

    
    @SuppressWarnings("unchecked")
   public static void main(String[] args) {

    int n = 4;
    int flight[][] = {{0,1,100},{1,2,100},{2,0,100},{1,3,600},{2,3,300}};
    int sr = 0;
    int dst = 3;
    int  k = 1;

    ArrayList<Edge>[] graph = new ArrayList[n];
    createGraph(flight, graph);
    cheap(graph, sr, dst, k);

       
   } 

    



   

}