
class Trie {

    static class Node {

        Node[] children = new Node[26];
        boolean eow = false;

        Node() {
            for (int i = 0; i < 26; i++) {
                children[i] = null;
            }
        }

    }

    public static Node root = new Node();

    public static void insert(String word) {

        Node curr = root;

        for (int level = 0; level < word.length(); level++) {

            int idx = word.charAt(level) - 'a';

            if (curr.children[idx] == null) {
                curr.children[idx] = new Node();

            }

            curr = curr.children[idx];

        }

        curr.eow = true;

    }

    public static boolean search(String word){

        Node temp = root;

        for(int level = 0; level < word.length(); level++){

            int idx = word.charAt(level) - 'a';

            if(temp.children[idx]!= null){
                temp = temp.children[idx];
            }else{
                return false;
            }

        }

        return temp.eow; // word is present if eow = true

    }

    public static void main(String[] args) {

        String words[] = {"the", "there", "a", "their", "any", "thee"};

        for (String word : words) {
            insert(word);
        }

       System.out.println(search("there"));
       System.out.println(search("thex"));
       System.out.println(search("thee"));
       System.out.println(search("therr"));
       System.out.println(search("th"));
       System.out.println(search("a"));



    }

}
