
import java.util.HashMap;

class ValidAnagram{

    public static boolean isAnagram(String s, String t){

        HashMap<Character,Integer> hm = new HashMap<>();

        for(int i = 0; i < s.length(); i++){
            char ch = s.charAt(i);
            hm.put(ch, hm.getOrDefault(ch, 0) + 1);
        }

        for(int i = 0; i < t.length(); i++){
            char ch = t.charAt(i);
            if(hm.get(ch)!= null){
                if(hm.get(ch) == 1){
                    hm.remove(ch);
                }else{
                    hm.put(ch, hm.get(ch)-1);
                }
            }else{
                return false;
            }
        }


        return hm.isEmpty();



    }

    public static void main(String[] args) {

        
        String s = "care";
        String t = "race";

        System.out.println(isAnagram(s, t));
        System.out.println(isAnagram("tulip", "lipid"));
        System.out.println(isAnagram("knee", "keen"));

    // Aam Zindagi

        // if(s.length()!= t.length()) {
        //     System.out.println("False");
        // }

        // HashMap<Character,Integer> hms = new HashMap<>();
        // HashMap<Character,Integer> hmt = new HashMap<>();
        
        // int freq = 1;

        // for(int i = 0; i < s.length(); i++){

        //     if(hms.containsKey(s.charAt(i))){
        //         hms.put(s.charAt(i), hms.get(s.charAt(i))+1);
        //     }else{
        //         hms.put(s.charAt(i), freq);
        //     }

        //     if(hmt.containsKey(t.charAt(i))){
        //         hmt.put(t.charAt(i), hmt.get(t.charAt(i))+1);
        //     }else{
        //         hmt.put(t.charAt(i), freq);
        //     }

        // }

        // boolean b = true;

        // for(int i = 0; i < s.length(); i++){

        //     if(hms.get(s.charAt(i))!= hmt.get(s.charAt(i)) ){
        //         System.out.println("False");
        //         b = false;
        //         break;
                
        //     }

        // }

        // if(b){
        //     System.out.println("True");
        // }

    }


}