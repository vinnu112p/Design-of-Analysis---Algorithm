
import java.util.*;

public class CoinExchange {

    public static int noOfCoins(int coins[], int target) {

        int coin = 0;

        for (int i = coins.length - 1; i >= 0; i--) {

            while (coins[i] <= target) {
                coin++;
                target = target - coins[i];

            }

            if (target == 0) {
                break;
            }

        }

        return coin;

    }

    public static void main(String[] args) {

        int coins[] = {1, 2, 5, 10, 20, 50, 100, 500, 1000};

        Arrays.sort(coins);

        System.out.println("No of coin required for 121 : " + noOfCoins(coins, 121));
        System.out.println("No of coin required for 590 : " + noOfCoins(coins, 590));
        System.out.println("No of coin required for 1027 : " + noOfCoins(coins, 1027));
        System.out.println("No of coin required for 653 : " + noOfCoins(coins, 653));

    }

}
