
import java.util.*;

class itineraryTicket{

    public static void main(String[] args) {
        
            HashMap<String,String> fromTo = new HashMap<>();
            HashMap<String,String> toFrom = new HashMap<>();

            fromTo.put("Chennai", "Bengaluru");
            fromTo.put("Mumbai", "Delhi");
            fromTo.put("Goa", "Chennai");
            fromTo.put("Delhi", "Goa");

            toFrom.put("Bengaluru", "Chennai");
            toFrom.put("Delhi", "Mumbai");
            toFrom.put("Chennai", "Goa");
            toFrom.put("Goa", "Delhi");

            Set<String> keys = fromTo.keySet();
            String start = null;

            for(String s : keys){
                if(!toFrom.containsKey(s)){
                    start = s;
                    break;
                }
            }

            for(int i = 0; i < fromTo.size(); i++){
                System.out.println(start + "-->" + fromTo.get(start));
                start = fromTo.get(start);
            }



           

    }

}