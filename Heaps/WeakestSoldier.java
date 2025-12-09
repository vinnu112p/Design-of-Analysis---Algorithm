
import java.util.PriorityQueue;


public class WeakestSoldier{

    static class Soldier implements Comparable<Soldier>{

        int soldier;
        int idx;

        public Soldier(int sol, int idx){
            this.soldier = sol;
            this.idx = idx;
        }

        @Override
        public int compareTo(Soldier s2){
            if(this.soldier == s2.soldier){
                return this.idx - s2.idx;
            }else{
                return this.soldier-s2.soldier;
            }
        }

    }

    public static void main(String[] args) {
        
        int army[][] = {

            {1,0,0,0},
            {1,1,1,1},
            {1,0,0,0},
            {1,0,0,0},
            {0,0,0,0}
        };

        int k = 3;

        PriorityQueue<Soldier> pq = new PriorityQueue<>();

        for(int i = 0; i < army.length; i++){

            int sol = 0;

            for(int j = 0; j < army[i].length; j++){
                if(army[i][j] == 1){
                    sol++;
                }
            }
            pq.add(new Soldier(sol,i));
        }

        for(int i = 0; i < k; i++){
            System.out.println("R" + pq.remove().idx);
        }

    }

}