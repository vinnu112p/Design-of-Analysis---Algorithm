
import java.util.PriorityQueue;


public class ConnectNRopes{

    

    public static void main(String[] args) {
        
        int ropes[] = {2,3,3,4,6};
        // int ropes[] = {4,3,2,6};
        int ans  = 0;

        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for(int i = 0; i < ropes.length; i++){
            pq.add(ropes[i]);
        }

      

        while(pq.size() > 1 ){

          
            
            int a = pq.remove();
            int b = pq.remove();
            ans = a+b + ans;
            pq.add(a+b);
            
        }

        System.out.println("Minimum cost to connect ropes: " + ans);
       



    }

}