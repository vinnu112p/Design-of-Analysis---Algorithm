
import java.util.Stack;

public class stockSpan {

    public static void stockSpan(Stack<Integer> s, int stock[], int span[], int size) {
        for (int i = 1; i < size; i++) {
            while (!s.isEmpty() && stock[i] >= stock[s.peek()]) {
                s.pop();
            }
            if (s.isEmpty()) {
                span[i] = i + 1;
            } else {
                span[i] = i - s.peek();
            }
            s.push(i);
        }
    }

    public static void main(String[] args) {

        Stack<Integer> s = new Stack<>();
        int stock[] = {100, 80, 60, 70, 60, 85, 100};
        int n = stock.length;
        int span[] = new int[n];
        span[0] = 1;
        s.push(0);
        stockSpan(s, stock, span, n);

        for (int i : span) {
            System.out.println(i + " ");
        }

    }

}
