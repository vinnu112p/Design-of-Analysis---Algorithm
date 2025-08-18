class FriendPairing{

    public static int pair(int n){
        if(n == 1 || n == 2){
            return n;
        }

        return pair(n-1) + (n-1) * pair(n-2); 
    }
    public static void main(String[] args) {
        System.out.println(pair(3));
    }
}


// The Friend Pairing Problem asks:
// Given n friends, each can remain single or be paired up with another friend. Each friend can be paired only once.
// How many ways can all friends be paired or remain single?

// Explanation of the Recursion:

// If a friend stays single:
// The remaining (n-1) friends can be paired in pair(n-1) ways.

// If a friend pairs up:
// They can pair with any of the (n-1) other friends.
// For each pairing, the remaining (n-2) friends can be paired in pair(n-2) ways.
// So, total ways for this case: (n-1) * pair(n-2).

// Recurrence Relation:

// Base Cases:

// pair(1) = 1 (only one friend, stays single)
// pair(2) = 2 (either both single or paired together)
// pair(n) = pair(n-1) + (n-1) * pair(n-2)
// This formula counts all possible ways friends can stay single or pair up.