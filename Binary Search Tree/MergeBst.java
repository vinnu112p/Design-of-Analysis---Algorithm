
import java.util.ArrayList;

public class MergeBst {
    static class Node{
        int data;
        Node left;
        Node right;

        Node(int data){
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    public static void InOrder(Node root, ArrayList<Integer> arr){
        if(root == null){
            return;
        }
        InOrder(root.left, arr);
        arr.add(root.data);
        InOrder(root.right,arr);
    }

    public static void inorder(Node root){

         if(root == null){
            return;
        }
        inorder(root.left);
        System.out.print(root.data +  " ");
        inorder(root.right);

    }

    public static Node buildBst(ArrayList<Integer> nodes, int st, int end){
       
       if(st > end){
        return  null;
       }

       int mid = (st+end)/2;

       Node root = new Node(nodes.get(mid));
       root.left = buildBst(nodes, st, mid-1);
       root.right = buildBst(nodes, mid+1, end);
       return root;

    }

    public static void main(String[] args) {
        Node root1 = new Node(2);   //      2
        root1.left = new Node(1);   //   1     4
        root1.right = new Node(4);

        Node root2 = new Node(9);  //     9
        root2.left = new Node(3);  //  3     12
        root2.right = new Node(12);

        ArrayList<Integer> bst1 = new ArrayList<>();
        InOrder(root1, bst1);
        ArrayList<Integer> bst2 = new ArrayList<>();
        InOrder(root2, bst2);
        ArrayList<Integer> merge = new ArrayList<>();

        int i = 0;
        int j = 0;

        while(i < bst1.size() && j < bst2.size()){
            if(bst1.get(i) <= bst2.get(j)){
                merge.add(bst1.get(i));
                i++;

            }else{
                merge.add(bst2.get(j));
                j++;
            }
        }

        while(i < bst1.size()){
            merge.add(bst1.get(i));
            i++;
        }
        while(j < bst2.size()){
            merge.add(bst2.get(j));
            j++;
        }

       Node root =  buildBst(merge, 0, merge.size()-1);
        inorder(root);







    }
}