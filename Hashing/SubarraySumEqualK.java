
import java.util.HashMap;

class SubarraySumEqualK {

    public static void main(String[] args) {
        int[] nums = {1,2,3};
        int k = 3;

        HashMap<Integer,Integer> hm = new HashMap<>();
        hm.put(0,1);

        int count = 0;
        int freq = 0;
        int sum = 0;

        for(int i = 0; i < nums.length; i++){

            sum+= nums[i];

            if(hm.containsKey(sum-k)){
                count+= hm.get(sum-k);
            }

            hm.put(sum, hm.getOrDefault(sum, 0) + 1);



        }

        System.out.println("No. of Subarray with sum K is: " + count);
       
    }

}
