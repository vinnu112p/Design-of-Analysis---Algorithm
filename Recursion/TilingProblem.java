class TilingProblem{

    public static int tiling(int n){

        if( n == 0 || n == 1){
            return 1;
        }
        // vertical tiling 
        int vert = tiling(n-1);

        // horizontal tiling

        int hori = tiling(n-2);

        return vert + hori;
    }
    public static void main(String[] args) {
        
        System.out.println(tiling(3));  // for 2 x n floor 

    }
}


// tiling(3):

// Calls tiling(2) (vertical)
// Calls tiling(1) (horizontal)
// tiling(2):

// Calls tiling(1) (vertical)
// Calls tiling(0) (horizontal)
// tiling(1):

// Base case, returns 1
// tiling(0):

// Base case, returns 1
// Now, let's compute:

// tiling(2) = tiling(1) + tiling(0) = 1 + 1 = 2
// tiling(3) = tiling(2) + tiling(1) = 2 + 1 = 3
