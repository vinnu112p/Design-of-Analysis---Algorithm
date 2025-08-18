class FastExpo{
    public static void main(String[] args) {
        int a = 3;      // Base value
        int n = 5;      // Exponent value
        int ans = 1;    // Result accumulator
        
        // Fast exponentiation using bit manipulation
        while(n > 0){
            if((n & 1)!= 0){    // If current bit of n is 1 (odd), multiply ans by a
                ans  = ans * a;
            }
            a = a * a;          // Square the base for next bit
            n = n>>1;           // Right shift n to process next bit
        }

        System.out.println(ans); // Output the result (3^5 = 243)
    }
}