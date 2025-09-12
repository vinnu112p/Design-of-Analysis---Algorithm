
import java.util.LinkedList;
import java.util.Queue;

public class FirstNonRepeating {

    public static void main(String[] args) {

        Queue<Character> q = new LinkedList<>();

        int frequency[] = new int[26];
        StringBuilder str = new StringBuilder("");

        String s = "aabccxb";

        for (int i = 0; i < s.length(); i++) {

            str.append(s.charAt(i));
            q.add(s.charAt(i));
            frequency[s.charAt(i) - 'a']++;

            if (frequency[q.peek() - 'a'] <= 1) {

                System.out.print(q.peek() + " ");

            } else {

                while (frequency[q.peek() - 'a'] > 1) {
                    q.remove();
                    if (q.isEmpty()) {
                        System.out.print("-1 ");
                        break;
                    }

                }

                if (!q.isEmpty()) {
                    System.out.println(q.peek() + " ");
                }

            }

        }

    }

}
