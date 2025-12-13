import java.util.*;
public class HashMapCode{

    static class HashMap<K,V>{

            private class Node {

                K key;
                V value;    

                public Node(K key, V value){
                    this.key = key;
                    this.value = value;
                }
            }

            private int n; // n
            private int N; // n
            private LinkedList<Node> bucket[];  // N

            @SuppressWarnings("unchecked")
            public HashMap(){

                this.N = 4;
                this.bucket = new LinkedList[4];
                for(int i = 0; i < 4; i++){
                    this.bucket[i] = new LinkedList<>();
                }

            }

            private int Hashfunction(K key){
                int hc = key.hashCode();
                return Math.abs(hc) % N;
            }

            private int SearchInLL(K key, int bi){
                LinkedList<Node> ll = bucket[bi];
                int di = 0;

                for(int i = 0; i < ll.size(); i++){
                    Node node = ll.get(i);
                    if(node.key == key){
                        return di;
                    }

                    di++;
                }

                return -1;
            }
            private void rehash(){
                
            }

            public void put(K key, V value){

                int bi = Hashfunction(key);
                int di = SearchInLL(key,bi);  

                if(di!= -1){
                    Node node = bucket[bi].get(di);
                    node.value = value;
                }else{

                    bucket[bi].add(new Node(key,value));
                    n++;


                }

                double lambda = (double) n/N;

                if(lambda > 2.0){
                    rehash();
                }


            }

            public boolean containsKey(K key){
                return false;
            }

            public V remove(K key){
                return null;
            }

            public V get(K key){
                return null;
            }

            public ArrayList<K> keySet(){
                return null;
            }
    }

    public static void main(String[] args) {
        
    }

}