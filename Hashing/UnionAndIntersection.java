
import java.util.HashSet;

class UnionAndIntersection{

    public static void main(String[] args) {
        int[] arr1 = {7,3,9};
        int[] arr2 = {6,3,9,2,9,4};

        HashSet<Integer> hs = new HashSet<>();

        // union
        for(int i = 0; i < arr1.length; i++){
            hs.add(arr1[i]);
        }

        for(int i = 0; i < arr2.length; i++){
            hs.add(arr2[i]);
        }

        System.out.println("Union: " + hs.size());
        hs.clear();

        // Intersection

         for(int i = 0; i < arr1.length; i++){
            hs.add(arr1[i]);
        }

        int unionCount = 0;

        for(int i = 0; i < arr2.length; i++){
            if(hs.contains(arr2[i])){
                unionCount++;
                hs.remove(arr2[i]);
            }
        }

        System.out.println("Intersection: " + unionCount);

    }

}