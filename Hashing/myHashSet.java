import java.util.*;
class myHashSet{

    public static void main(String[] args) {
        
        // HashSet in Java
        // It is used to store unique elements only
        // It is not ordered

        HashSet<Integer> hs = new HashSet<>();
        hs.add(1);
        hs.add(2);
        hs.add(2);
        hs.add(3);
        hs.add(4);
        System.out.println(hs); // [1, 2, 3, 4]

        hs.remove(3);
        System.out.println(hs); // [1, 2, 4]
        System.out.println(hs.contains(2)); // true
        System.out.println(hs.size()); // 3


        // linkedHashSet
        // It maintains the insertion order
        LinkedHashSet<Integer> lhs = new LinkedHashSet<>();
        lhs.add(5);
        lhs.add(3);
        lhs.add(1);
        lhs.add(4);
        System.out.println(lhs); // [5, 3, 1, 4]

        // TreeSet
        // It stores elements in sorted order
        // dont take null values
        // slower than HashSet and LinkedHashSet
        // red black tree implementation
        TreeSet<Integer> ts = new TreeSet<>();
        ts.add(4);
        ts.add(1);
        ts.add(3);
        ts.add(2);
        System.out.println(ts); // [1, 2, 3, 4]



        


    }

}