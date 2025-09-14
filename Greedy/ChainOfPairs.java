
import java.util.Arrays;
import java.util.Comparator;

public class ChainOfPairs {

    public static int maxLengthChain(int pairs[][], int n) {

        int max = 0;

        for (int i = 1; i < n; i++) {
            int prev = pairs[i - 1][1];
            int m = 1;
            for (int j = i; j < n; j++) {

                if (pairs[j][0] > prev) {
                    m++;
                    prev = pairs[j][1];
                }

            }

            max = Math.max(max, m);

        }

        return max;

    }

    public static void main(String[] args) {

        int pairs[][] = {{5, 24}, {15, 25}, {27, 40}, {50, 60}, {65, 80}};

        System.out.println("Max length of chain : " + maxLengthChain(pairs, pairs.length));

        // Also Greedy approach
        // Sort the array according to second element of pair
        // Then apply the same logic as Activity Selection
        Arrays.sort(pairs, Comparator.comparingDouble(o -> o[1]));

        int ans = 1;
        int pairEnd = pairs[0][1];

        for (int i = 1; i < pairs.length; i++) {
            if (pairs[i][0] > pairEnd) {
                ans++;
                pairEnd = pairs[i][1];
            }
        }

        System.out.println("Max Chain: " + ans);

    }

}
