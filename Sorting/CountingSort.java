class CountingSort{

    public static void countsort(int arr[]){

        int largest = Integer.MIN_VALUE;

        for(int i = 0; i < arr.length; i++){
            largest =  Math.max(largest,arr[i]);
        }

        int count[] = new int[largest+1];

        for(int i = 0; i < arr.length; i++){
            count[arr[i]]++;
        }
        int j = 0;
        for(int i = 0; i < count.length; i++){
            while(count[i] > 0){
                arr[j] = i;
                j++;
                count[i]--;
            }
        }


    }
    public static void main(String[] args) {
        int arr[] = {1,2,7,1,5,4,3,9};

        countsort(arr);
        for(int num: arr){
            System.out.print(num+ " ");
        }

    }
    
}