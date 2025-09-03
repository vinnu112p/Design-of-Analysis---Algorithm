
import java.util.Stack;

class pushAtBottom {

    public static void pushdown(Stack<Integer> s, int ele) {

        if (s.isEmpty()) {
            s.push(ele);
            return;

        }

        int temp = s.pop();
        pushdown(s, ele);
        s.push(temp);

    }

    public static void reverseStack(Stack<Integer> s) {

        if (s.isEmpty()) {
            return;
        }

        int ele = s.pop();
        reverseStack(s);
        pushdown(s, ele);

    }

    public static void main(String[] args) {

        Stack<Integer> s = new Stack<>();
        s.push(1);
        s.push(2);
        s.push(3);
        s.push(4);
        s.push(5);

        // while(!s.isEmpty()){
        //     System.out.println(s.pop());
        // }
        // pushdown(s, 0);
        reverseStack(s);

        while (!s.isEmpty()) {
            System.out.println(s.pop());
        }

    }

}
