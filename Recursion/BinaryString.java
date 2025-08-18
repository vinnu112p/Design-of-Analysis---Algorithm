class BinaryString{

    public static void binpri(int n, int lastplace, String s ){
        if( n == 0){
            System.out.println(s);
            return;
        }

        binpri(n-1, 0, s+"0");
        if(lastplace == 0){
            binpri(n-1, 1, s+"1");
        }
    }
    public static void main(String[] args) {
       
        binpri(3, 0, "");
        
    }
}



// Binary String Problem:
// Generate all binary strings of length n such that there are no consecutive 1s.

// Solution Explanation
// The function binpri(n, lastplace, s) recursively builds binary strings:
// n: Number of positions left to fill.
// lastplace: Value at the previous position (0 or 1).
// s: The current binary string being built.
// At each step:
// You can always add '0'.
// You can add '1' only if the last added digit was '0' (to avoid consecutive 1s).
// Dry Run for binpri(3, 0, "")
// Let's see how the recursion works for n = 3:

// binpri(3, 0, "")

// Add '0': binpri(2, 0, "0")
// Add '1': binpri(2, 1, "1")
// binpri(2, 0, "0")

// Add '0': binpri(1, 0, "00")
// Add '1': binpri(1, 1, "01")
// binpri(2, 1, "1")

// Add '0': binpri(1, 0, "10")
// (Cannot add '1' because lastplace is 1)
// binpri(1, 0, "00")

// Add '0': binpri(0, 0, "000") → prints "000"
// Add '1': binpri(0, 1, "001") → prints "001"
// binpri(1, 1, "01")

// Add '0': binpri(0, 0, "010") → prints "010"
// (Cannot add '1')
// binpri(1, 0, "10")

// Add '0': binpri(0, 0, "100") → prints "100"
// Add '1': binpri(0, 1, "101") → prints "101"
// Output
// These are all binary strings of length 3 with no consecutive 1s.