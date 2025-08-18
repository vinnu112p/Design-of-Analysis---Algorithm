
import java.util.Scanner;

public class BitManipulation{
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the number:");
        int num = sc.nextInt();
        System.out.print("Enter the position:");
        int pos = sc.nextInt();

        System.out.println("Choose Option:");
        System.out.println("To Check the Bit Enter 1");
        System.out.println("To Set a Bit Enter 2");
        System.out.println("To Clear a Bit Enter 3");
        

        int op = sc.nextInt();

        int BitMask = 1<<pos;

        switch (op) {
            case 1:
                int BitNumber = BitMask & num;
                if (BitNumber == 0){
                    System.out.println("0");
                }else{
                    System.err.println("1");
                }
                
                break;
            case 2:
                int SetNumber = BitMask | num;
                System.out.println(SetNumber);
                break;
            case 3:
                int NotBitMask = ~(BitMask);
                int ClearNumber = NotBitMask & num;
                System.out.println(ClearNumber);
                break;
            
            default:
                System.out.println("Enter The Correct Option:");
        }


    }
}