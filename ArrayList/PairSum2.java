
import java.util.ArrayList;

public class PairSum2{

    public static void optimized(ArrayList<Integer> list, int target){

        // 11 15 6 8 9 10   // Sorted and rotated
        int n =  list.size();
        int lp = 0;
        int rp = n-1;
        

        for(int i = 0; i < n-1; i++){
            if(!(list.get(i) < list.get(i+1))){
                lp = i+1;
                rp = i;
            }
        }

        while(lp != rp){

            if(target == (list.get(rp)+ list.get(lp))){
                System.out.println(list.get(rp)+ " "+ list.get(lp));
                lp = (lp+1) % n;
                rp = (rp + n - 1) % n;
            }else if(target < (list.get(rp)+ list.get(lp))){
                 
                  rp = (rp + n - 1) % n;
            }else{
               lp = (lp+1) % n;
            }


        }



    }

public static void main(String[] args) {
    ArrayList<Integer> list = new ArrayList<>();
    list.add(11);
    list.add(15);
    list.add(6);
    list.add(8);
    list.add(9);
    list.add(10);

    int target = 19;

    optimized(list,target);

    
}

}