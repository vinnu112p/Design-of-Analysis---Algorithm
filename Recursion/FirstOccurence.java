class FirstOccurence{

    public static int firstoccur(int arr[], int target,int i){
        if(i == arr.length){
            return -1;
        }
        if(arr[i] == target){
            return i;
        }

        return firstoccur(arr,target,i+1);

    }
    public static int lastoccur(int arr[], int target,int i){
        if(i < 0){
            return -1;
        }
        if(arr[i] == target){
            return i;
        }

        return lastoccur(arr,target,i-1);

    }

    public static int pow(int a, int n){
        if(n == 0){
            return 1;
        }

        return a * pow(a,n-1);

    }
    public static int optimizedpow(int a, int n){
        if(n == 0){
            return 1;
        }

        if(n % 2 == 0){
            return  optimizedpow(a, n/2) * optimizedpow(a, n/2);
        }

        return a *  optimizedpow(a, n/2) *  optimizedpow(a, n/2);


        

    }

    public static void main(String[] args) {
        int arr[] = {1,8,6,5,4,3,5,2};
        System.out.println(firstoccur(arr, 5,0));
        System.out.println(lastoccur(arr, 5,arr.length-1));
        System.out.println(pow(2,0));
        System.out.println(optimizedpow(2,6));

    }
}