import java.util.Stack;

class reverseString{

    public static void main(String[] args) {
        
        Stack<Character> s = new Stack<>();

        String str = "Java";

        for(int i = 0 ; i < str.length(); i++){
            s.push(str.charAt(i));
        }

        while(!s.isEmpty()){
            System.out.println(s.pop());
        }




    }

}