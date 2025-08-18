public class Prime{

    public static void main(String arg[]){

        int num = 17;
        int isPrime = 0;

        for(int i = 2; i <= Math.sqrt(num); i++){
            if(num % i == 0){
                isPrime = 1;
                break;
            }
        }

    if(isPrime == 1){
        System.out.println(num + " is not a prime number");
    }else{
        System.out.println(num + " is a prime number");
    }


    }
}