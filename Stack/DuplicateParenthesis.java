
import java.util.Stack;

public class DuplicateParenthesis {

    public static boolean isValid(String str) {  

        Stack<Character> st = new Stack<>();
        int count = 0;

        for (int i = 0; i < str.length(); i++) {

            char c = str.charAt(i);

            if (c != ')') {
                st.push(c);
            } else {
                while (st.peek() != '(') {
                    st.pop();
                    count++;
                }
                st.pop();

                if (count < 1) {
                    return true;
                }

                count = 0;
            }

        }

        return false;
    }

    public static void main(String[] args) {

        String str1 = "(((a+(b)))+(c+d))";
        String str2 = "(a+b)";

        if (isValid(str1)) {
            System.out.println("Duplicate");
        } else {
            System.out.println("Non-Duplicate");
        }
        if (isValid(str2)) {
            System.out.println("Duplicate");
        } else {
            System.out.println("Non-Duplicate");
        }

    }

}
