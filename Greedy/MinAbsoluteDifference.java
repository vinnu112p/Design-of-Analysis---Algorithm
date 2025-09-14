import java.util.*;
public class MinAbsoluteDifference{

    public static void main(String[] args) {
        
        int A[] = {1,2,3};
        int B[] = {2,1,3};

        Arrays.sort(A);
        Arrays.sort(B);

        int mindef = 0;

        for(int i = 0; i < A.length; i++){
            mindef+= Math.abs(A[i]- B[i]);
        }

        System.out.println("Min absolute diffrence : " + mindef);

    }


}