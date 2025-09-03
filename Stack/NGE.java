import java.util.Stack;
public class NGE {


public static void ngestack(int arr[], int nge[]){
    Stack<Integer> s = new Stack<>();

    for(int  i = arr.length-1; i >= 0; i--){

        while(!s.isEmpty() && arr[i] >= arr[s.peek()]){
            s.pop();
        }

        if(s.isEmpty()){
            nge[i] = -1;
        }else{
            nge[i] = arr[s.peek()];
        }

        s.push(i);
    }

}

    public static void main(String[] args) {

        int arr[] = {6, 8, 0, 1, 3, 4, 7};

        int nge[] = new int[arr.length];

        ngestack(arr, nge);

       // BRUTE FORCE         

      
        // for (int i = 0; i < arr.length; i++) {
         //         nge[i] = -1;
        //     for (int j = i + 1; j < arr.length; j++) {
        //         if (arr[i] < arr[j]) {
        //             nge[i] = arr[j];
        //             break;
        //         }

       

        //     }

        // }

        for (int ele : arr) {
            System.out.print(ele + " ");
        }

        System.out.println("");

        for (int ele : nge) {
            System.out.print(ele + " ");
        }

    }

}
