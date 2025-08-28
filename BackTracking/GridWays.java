public class GridWays{

    public static int factorial(int n){

        if (n == 0 || n == 1) return n;

        return n*factorial(n-1);


        // Number of ways =
        // (n + m - 2)! / [ (n - 1)! * (m - 1)! ]


       


    }

public static int gridways(int i, int j, int n, int m){

//     if(i == n-1 && j == m-1){   // base case
//         return 1;
//     }else if(i == n || j == m){  // case if the current position is the ending position
//         return 0;
//     }

// int w1 = gridways(i+1, j, n, m);  // no of ways from downside
// int w2 = gridways(i, j+1, n, m);  // no of ways from rightside    // O(2^(n+m))

// return w1+w2;

return factorial(n+m-2)/(factorial(n-1)*factorial(m-1));

}


public static void main(String[] args) {
    int n = 3,m=3;

    System.out.println(gridways(0,0,n,m));
}
}