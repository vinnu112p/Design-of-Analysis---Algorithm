
class FindPermutation {

    public static void permutation(String str, String ans) {

        // Base Case
        if (str.length() == 0) {
            System.out.println(ans);
            return;
        }

        // Recursion
        for (int i = 0; i < str.length(); i++) {
            char curr = str.charAt(i);
            String newStr = str.substring(0, i) + str.substring(i + 1, str.length());
            permutation(newStr, ans + curr);

        }

    }

    public static void main(String[] args) {
        String str = "abc";
        permutation(str, "");
    }
}


// Summary Table
// Call	Next Calls	Output
// permutation("abc","")	"a"→"bc","b"→"ac","c"→"ab"	
// permutation("bc","a")	"b"→"c","c"→"b"	
// permutation("c","ab")	""	"abc"
// permutation("b","ac")	""	"acb"
// permutation("ac","b")	"a"→"c","c"→"a"	
// permutation("c","ba")	""	"bac"
// permutation("a","bc")	""	"bca"
// permutation("ab","c")	"a"→"b","b"→"a"	
// permutation("b","ca")	""	"cab"
// permutation("a","cb")	""	"cba"
