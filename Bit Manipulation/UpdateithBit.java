
import java.util.Scanner;

class UpdateithBit{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int x = sc.nextInt();  // 7  0 1 1 1
        int y = sc.nextInt();  // update 2 then 0 0 1 1
        int bitMask = 1<<y;

       System.out.println(x ^ bitMask);


        
    }
}