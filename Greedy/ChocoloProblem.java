
import java.util.Arrays;
import java.util.Collections;

public class ChocoloProblem{

    public static void main(String[] args) {
        
        int n = 4, m = 6;

        Integer costVer[] = {2,1,3,1,4};
        Integer costHor[] = {4,1,2};

        Arrays.sort(costVer, Collections.reverseOrder());
        Arrays.sort(costHor, Collections.reverseOrder());

        int h = 0;  // pointer for horizontal
        int v = 0;  // pointer for vertical
        int hp = 1; // no of horizontal pieces
        int vp = 1; // no of vertical pieces
        int cost = 0;

        while(h < costHor.length && v < costVer.length){
            // vertical cost < horizontal cost
            if(costVer[v] <= costHor[h]){  // horizontal cut
                cost+= (costHor[h]*vp);
                hp++;
                h++;

            }else{

                cost+= (costVer[v]*hp);
                vp++;
                v++;
            }

        }

        while( h < costHor.length){
             cost+= (costHor[h]*vp);
                hp++;
                h++;
        }

        while( v < costVer.length){
             cost+= (costVer[v]*hp);
                vp++;
                v++;
        }

        System.out.println("Minimum cost: " + cost);



    }

}