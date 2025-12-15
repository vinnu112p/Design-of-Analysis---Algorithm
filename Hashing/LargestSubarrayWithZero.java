import java.util.HashMap;

class LargestSubarrayWithZero {

    public static void main(String[] args) {
        HashMap<Integer, Integer> hm = new HashMap<>();

        int arr[] = {15, -2, 2, -8, 1, 7, 10, 23};

        int maxLength = 0;
        int sum = 0;

        for (int j = 0; j < arr.length; j++) {

            sum = sum + arr[j];

            if (hm.containsKey(sum)) {

                maxLength = Math.max(maxLength, j - hm.get(sum));

            } else {
                hm.put(sum, j);
            }

        }

        System.out.println(maxLength);

    }

}
