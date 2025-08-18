
import java.util.Scanner;

class SetithBit{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int x = sc.nextInt();  // 7  0 1 1 1
        int y = sc.nextInt();  // 2  set   3 reset
        int bitMask = 1<<y;

    System.out.println(x & ~bitMask);  // clear
    System.out.println(x | bitMask);  // to set bit
      


        
    }
}