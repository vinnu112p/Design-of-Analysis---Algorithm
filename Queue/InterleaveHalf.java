
import java.util.LinkedList;
import java.util.Queue;
public class InterleaveHalf{

    // 1 2 3 4 5 6 7 8 9 10
    // 1 6 2 7 3 8 4 9 5 10

    public static void main(String[] args) {
        
        Queue<Integer> q = new LinkedList<>();

        for(int i = 1 ; i <= 10; i++){
            q.add(i);
        }

        Queue<Integer> first = new LinkedList<>();
        int size = q.size()/2;
        while(size > 0){
            first.add(q.remove());
            size--;
        }

        while(!first.isEmpty()){
            q.add(first.remove());
            q.add(q.remove());
        }

        while(!q.isEmpty()){
            System.out.print(q.peek() +" ");
            q.remove();
        }




    }

}