
public class BubbleSort {

    public static void main(String arg[]) {
        int[] arr = {8, 1, 5, 6, 9, 3};

        for (int i = 0; i < arr.length - 1; i++) {

            for (int j = 0; j < arr.length - i - 1; j++) {

                if (arr[j + 1] < arr[j]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }

            }
        }

        for (int num : arr) {
            System.out.print(num + " ");
        }
    }
}
