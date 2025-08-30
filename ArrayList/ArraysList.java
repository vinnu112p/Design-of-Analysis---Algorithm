
import java.util.ArrayList;



public class ArraysList{

public static void main(String[] args) {
    
    // ArrayList<Integer> list = new ArrayList<>();
    // System.out.println(list);
    // list.add(69);
    // list.add(1, 5);
    // System.out.println(list);
    // System.out.println(list.get(0));

    // Multidimensional arraylist 

    ArrayList<ArrayList> mainList = new ArrayList<>();
    ArrayList<Integer> list1 = new ArrayList<>();
    list1.add(1); list1.add(2);
    ArrayList<Integer> list2 = new ArrayList<>();
    list2.add(1); list2.add(2);
    ArrayList<Integer> list3 = new ArrayList<>();
    list3.add(1); list3.add(2);

    mainList.add(list1);  mainList.add(list2);  mainList.add(list3);

    System.out.println(mainList); 

    for(int i = 0 ; i < mainList.size(); i++){
        ArrayList<Integer> curr = mainList.get(i);

        for(int j = 0; j < curr.size(); j++){
            System.out.print(curr.get(j)+" ");
        }

        System.out.println("");
    }



    



}

}