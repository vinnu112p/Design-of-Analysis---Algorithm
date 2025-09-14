
import java.util.Arrays;
import java.util.Comparator;

public class FractionalKnapsack{

    
    public static double fractionalKnapsack(int val[], int weight[], int bag, int n){

        double amount = 0;

        double ratio[][] = new double[n][2];

        for(int i = 0; i < n; i++){
            ratio[i][0] = i;
            ratio[i][1] = val[i]/(double) weight[i];
        }

        Arrays.sort(ratio, Comparator.comparingDouble(o -> ((double[])o)[1])); 

       for(int i = n-1; i >= 0; i--){
    int idx = (int)ratio[i][0];
    if(bag >= weight[idx]){
        amount += val[idx];
        bag -= weight[idx];
    } else {
        amount += bag * ratio[i][1];
        break;
    }
}
      




        return amount;

    }

    public static void main(String[] args) {
        
        int val[] = {60,100,120};
        int weight[] = {10,20,30};
        int W = 50;

        System.out.println("Max Profit : " + fractionalKnapsack(val,weight,W,val.length));

    }

}