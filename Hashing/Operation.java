
import java.util.HashMap;
import java.util.Set;


class Operation{

    public static void main(String[] args) {
        
        HashMap<String,Integer> hm = new HashMap<>();

        hm.put("Pizza", 120);
        hm.put("Burger", 80);
        hm.put("Fries", 100);
        hm.put("Taco", 75);

        System.out.println(hm);
        System.out.println(hm.get("Pizza"));

        hm.put("Taco",90);

        System.out.println(hm);

        hm.remove("Burger");
        hm.put("Cheese Burger", 95);
        System.out.println(hm.get("Maggi"));

        System.out.println(hm);

        System.out.println(hm.isEmpty());
        // hm.clear();
        // System.out.println(hm.isEmpty());

        // Iteration on hashmap we create a set of keys using the below thigs

        Set<String> keys = hm.keySet();

        System.out.println(keys);

        for(String s : keys){
            System.out.println(s + " " + hm.get(s));
        }



    }

}