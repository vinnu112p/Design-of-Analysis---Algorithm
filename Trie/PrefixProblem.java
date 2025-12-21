class PrefixProblem {

    public static class Node{

        Node children[] = new Node[26];
        boolean eow;
        int freq;

        Node(){
            for(int i = 0; i < 26; i++){
                children[i] = null;
            }
            freq = 1;
        }

    }

    public static Node root = new Node();

    public static void insert(String word){

        Node curr = root;

        for(int i = 0; i < word.length(); i++){

            int idx = word.charAt(i) - 'a';

            if(curr.children[idx] == null){
                curr.children[idx] = new Node();
            }else{
                curr.children[idx].freq++;
            }

            curr = curr.children[idx];

        }

        curr.eow = true;

    }

    public static void printPrefixes(String word){
        
        Node curr = root;
        String prefix = "";
        
        for(int i = 0; i < word.length(); i++){
            
            int idx = word.charAt(i) - 'a';
            prefix += word.charAt(i);
            
            if(curr.children[idx] != null && curr.children[idx].freq == 1){
                System.out.println(prefix);
                return;
            }
            
            curr = curr.children[idx];
        }
    }

    public static void main(String[] args) {

        String words[] = {"zebra", "dog", "dove", "duck"};

        // Insert all words into Trie
        for(String word : words){
            insert(word);
        }

        // Print unique prefixes for each word
        System.out.println("Unique Prefixes:");
        for(String word : words){
            printPrefixes(word);
        }
        
    }

}