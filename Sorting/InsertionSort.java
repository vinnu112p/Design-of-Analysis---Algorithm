public class InsertionSort {
    public static void main(String[] args) {

        int [] arr = {5, 3, 4, 1, 8, 2};
        // 3 5 4 1 8 2 
        // 3 4 5 1 8 2
        // 1 3 4 5 8 2
        // 1 2 3 4 5 8


        for(int i = 1; i < arr.length; i++){
            int current = arr[i];
            int j = i - 1;
            while(j >= 0 && arr[j] > current){
                arr[j+1] = arr[j];
                j--;
            }

            arr[j+1] = current;

        }

        for(int num : arr){
            System.out.print(num + " ");
        }

}

}