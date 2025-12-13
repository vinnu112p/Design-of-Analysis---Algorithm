
import java.util.HashMap;
import java.util.Set;

class MajorityElements {

    public static void main(String[] args) {

        int nums[] = {1, 2, 4, 1, 5, 1, 3, 1, 3, 3, 3, 2, 3, 1};

        HashMap<Integer, Integer> hm = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            if (hm.containsKey(nums[i])) {
                hm.put(nums[i], hm.get(nums[i]) + 1);
            } else {

                hm.put(nums[i], 1);
            }

        }

        System.out.println(hm);

        // finding elements that appears    more than n/3;
        int n = nums.length / 3;
        Set<Integer> keys = hm.keySet();

        for (int i : keys) {
            if (hm.get(i) > n) {
                System.out.print(i + " ");
            }
        }

    }

}
