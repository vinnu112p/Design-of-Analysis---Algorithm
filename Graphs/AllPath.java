import java.util.*;
class AllPath{

public static class Edge{
    int src;
    int des;

    Edge(int s, int d){
        this.src = s;
        this.des = d;
    }


}

public static void traversal(ArrayList<Edge> graph[], int src, int des, String path){

    if(src == des){
        System.out.println(path+src);
        return ;
    }

    for(int i = 0; i < graph[src].size(); i++){
        Edge e = graph[src].get(i);
        
        traversal(graph, e.des, des, path+src);

    }



}

public static void createGraph(ArrayList<Edge> graph[]){
    for(int i = 0; i < graph.length; i++){
        graph[i] = new ArrayList<>();
    }

    graph[0].add(new Edge(0,3));
    graph[0].add(new Edge(0,4));
    graph[2].add(new Edge(2,3));
    graph[3].add(new Edge(3,1));
    graph[4].add(new Edge(4,1));
    graph[5].add(new Edge(5,0));
    graph[5].add(new Edge(5,2));
}
@SuppressWarnings("unchecked")
public static void main(String[] args) {
    int V = 6;

    ArrayList<Edge> graph[] = new ArrayList[V];
    createGraph(graph);
    String path = "";

    traversal(graph, 5, 1, path);





}

}





























/*
    Visual Structure of the Directed Graph (from the image):

        5 → 2
        ↓
        0 → 3
       ↑    ↓
      4 → 1

    Edges and their directions:
    - 5 → 2
    - 5 → 0
    - 2 → 3
    - 0 → 3
    - 0 → 4
    - 4 → 1
    - 3 → 1

    Example paths from source (5) to target (1):
    - 5 → 2 → 3 → 1
    - 5 → 0 → 3 → 1
*/