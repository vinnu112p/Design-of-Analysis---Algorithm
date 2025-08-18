
import java.util.Scanner;

class RemoveVowel {

    public static void main(String arg[]) {

        StringBuilder sb = new StringBuilder();

        Scanner sc = new Scanner(System.in);
        String str = sc.next();

        for (int i = 0; i < str.length(); i++) {

            if (str.charAt(i) != 'a' && str.charAt(i) != 'e' && str.charAt(i) != 'i' && str.charAt(i) != 'o' && str.charAt(i) != 'u') {
                sb.append(str.charAt(i));
            }

        }

        System.out.print(sb);

    }
}
