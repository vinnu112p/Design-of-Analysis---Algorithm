
public class SelectionSort {

    public static void main(String[] args) {
        int[] arr = {5, 3, 4, 1, 8, 2};

        for (int i = 0; i < arr.length; i++) {
            int small = i;

            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[small]) {
                    small = j;
                }
            }

            int temp = arr[i];
            arr[i] = arr[small];
            arr[small] = temp;
        }

        for (int num : arr) {
            System.out.print(num + " ");
        }
    }
}
