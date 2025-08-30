
import java.util.ArrayList;

public class PairSum{

public static void optimized(ArrayList<Integer> list, int target){

    int lp = 0;
    int rp = list.size()-1;

    while(lp<rp){
        if(target == (list.get(rp)+ list.get(lp))){
            System.out.println(list.get(lp)+ " " + list.get(rp));
            lp++;
            rp--;
        }
        else if(target < (list.get(lp)+ list.get(rp))){
              rp--;
        }else{
            lp++;
        }
    }







}
public static void main(String[] args) {
    
    ArrayList<Integer> list = new ArrayList<>();
    list.add(1);
    list.add(2);
    list.add(3);
    list.add(4);
    list.add(5);
    list.add(6);

    //BRUTE FORCE

    System.out.println("Brute Force");

    int target = 5;

    for(int i = 0; i < list.size(); i++){
        for(int j = i+1; j < list.size(); j++){

            int currSum = list.get(i) + list.get(j);
            if(currSum == target){
                    System.out.println(list.get(i) + " " + list.get(j));
                    break;
            }

        }
    }

    System.out.println("--------------------");
    System.out.println("Optimized");
    optimized(list,target);




    

}

}