
import java.util.ArrayList;

public class ContainerWithMostWater{
    // O(n)
    public static int optimized(ArrayList<Integer> container){

        int lp = 0;
        int rp = container.size()-1;
        int maxWater = Integer.MIN_VALUE;

        while(lp<rp){
            int h = Math.min(container.get(lp), container.get(rp));
            int w = rp-lp;
            int water = h*w;
            maxWater = Math.max(water, maxWater);

            if(container.get(lp) < container.get(rp)){
                lp++;
            }else{
                rp--;
            }
        }

        return maxWater;


    }

    public static void main(String[] args) {
        
        ArrayList<Integer> container = new ArrayList<>();
        container.add(1);
        container.add(8);
        container.add(6);
        container.add(2);
        container.add(5);
        container.add(4);
        container.add(8);
        container.add(3);
        container.add(7);

        int maxWater = Integer.MIN_VALUE;
        int e1 = 0,e2 = 0;

        //BRUTE FORCE

        for(int i = 0; i < container.size(); i++){
            for(int j  = i+1; j < container.size(); j++){
                int height = Math.min(container.get(i), container.get(j));
                int width = j-i;
                int water = height*width;
                if(water > maxWater){
                
                maxWater = Math.max(water, maxWater);
                e1 = i;
                e2 = j;
                }

            }
        }

        // System.out.println(maxWater + " Between " + container.get(e1) + " & " + container.get(e2));

        System.out.println(optimized(container));

    }

}