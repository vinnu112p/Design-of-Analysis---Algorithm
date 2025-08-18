public class Binary{

    public static void main(String arg[]) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int key = 2;
        int mid;
        int low = 0;
        int end = arr.length - 1;
        int bool = 0;

        while (low <= end) {
            mid = (low + end) / 2;
            if (arr[mid] == key) {
                System.out.println("Element found at index: " + mid);
                bool = 1;
                return;
            } else if (arr[mid] < key) {
                low = mid + 1;
            } else {
                end = mid - 1;
            }

        }

        if (bool == 0) {
            System.out.println("Element not found");
        }

    }
}
