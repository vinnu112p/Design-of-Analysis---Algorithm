
public class ActivitySelection {

    public static int maximumActivity(int[] start, int[] end, int n) {

        int max = 1;
        int endtask = 0;

        for (int i = 1; i < n; i++) {

            if (start[i] >= end[endtask]) {
                max++;
                endtask = i;
            }

        }

        return max;

    }

    public static void main(String[] args) {

        int start[] = {1, 3, 0, 5, 8, 5};
        int end[] = {2, 4, 6, 7, 9, 9};
        int n = start.length;

        System.out.println(maximumActivity(start, end, n));

    }

}
