
class ArrayBackTracking {

    public static void arr(int arr[], int idx) {
        if (idx == arr.length) {
            for (int num : arr) {
                System.out.print(num + " ");
            }
            return;
        }

        arr[idx] = idx + 1;

        arr(arr, idx + 1);
        arr[idx] = arr[idx] - 2;

    }

    public static void main(String[] args) {
        int arr[] = new int[5];
        arr(arr, 0);
        System.out.println("");
        for (int num : arr) {
            System.out.print(num + " ");
        }

    }
}
