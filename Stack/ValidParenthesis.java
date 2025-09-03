import java.util.Stack;
public class ValidParenthesis{

    public static boolean validparenthesis(String s){

        Stack<Character> st = new Stack<>();

        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            if( c == '(' || c == '[' || c == '{'){
                st.push(c);
            }else if(!st.isEmpty() && (st.peek() == '(' && c == ')') || (st.peek() == '{' && c == '}') || (st.peek() == '[' && c == ']')){
                st.pop();
            }else{
                return false;
            }

        }



        return st.isEmpty();    
    }

    public static void main(String[] args) {
        
        String str = "({[([])]})";
        
        if(validparenthesis(str)){
            System.out.println("Valid");
        }else{
            System.out.println("Invalid");
        }



    }

}