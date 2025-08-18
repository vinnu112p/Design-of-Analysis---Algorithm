class QuickSort{


    public static int partition(int arr[],int low, int high){
        int pivot = arr[high];
        int i = low-1;

        for(int j = low; j < high; j++){
            if(arr[j] <= pivot){
                i++;
                int temp = arr[j];
                arr[j] = arr[i];
                arr[i] = temp;
            }
        }

        int temp = arr[i+1];
        arr[i+1] = arr[high];
        arr[high] = temp;

        return i+1;

    }

    public static void quicksort(int arr[], int low, int high){

        if ( low < high){
            int pivot = partition(arr, low, high);
            quicksort(arr, low, pivot - 1);
            quicksort(arr, pivot + 1, high);
        }
    }

    public static void main(String arg[]){

        int[] arr = {5, 3, 4, 1, 8, 2};
       
        for(int num : arr){
            System.out.print(num + " ");
        }

        quicksort(arr, 0, arr.length-1);

        System.out.println("");
        

        for(int num : arr){
            System.out.print(num + " ");
        }

        
    }
}