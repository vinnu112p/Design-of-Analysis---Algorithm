
public class BST {

    static class Node {

        int data;
        Node left;
        Node right;

        Node(int d) {
            this.data = d;
            this.left = null;
            this.right = null;
        }
    }

    public static Node buildbst(Node root, int val) {

        if (root == null) {
            root = new Node(val);
            return root;
        }

        if (root.data > val) {
            root.left = buildbst(root.left, val);
        }
        if (root.data < val) {
            root.right = buildbst(root.right, val);
        }

        return root;

    }

    public static boolean search(Node root, int key){

        if(root == null){
            return false;
        }

        if(root.data == key){
            return true;
        }else if (root.data > key){
            return search(root.left, key);
        }else{
            return search(root.right, key);
        }

    }

    public static Node findInorderSuccessor(Node root){
        while(root.left != null){
            root = root.left;
        }
        return root;
    }

    public static Node delete(Node root, int val){
        if(root.data < val){
            root.right  = delete(root.right, val);
        }else if(root.data > val){
            root.left = delete(root.left, val);
        }else{ 
            // CASE 1 Leaf Node
            if(root.left == null && root.right == null){
                return null;
            }

            // CASE 2 Single child
            if(root.left == null){
                return root.right;
            }else if(root.right == null){
                return root.left;
            }

            // CASE 3 Both child

             Node IS = findInorderSuccessor(root.right);
             root.data = IS.data;
             root.right = delete(root.right, IS.data);
        }

        return root;
    }

    public static void PrintInRange(Node root, int k1, int k2){
        if(root == null){
            return;
        }

        if(root.data >= k1 && root.data <= k2){
            PrintInRange(root.left, k1, k2);
            System.out.print(root.data + " ");
            PrintInRange(root.right, k1, k2);
        }else if(root.data < k1){
            PrintInRange(root.right, k1, k2);
        }else{
            PrintInRange(root.left, k1, k2);
        }
    }

    public static void Inorder(Node root) {
        if (root == null) {
            return;
        }

        Inorder(root.left);
        System.out.print(root.data + " ");
        Inorder(root.right);

    }

    public static void main(String[] args) {

        int arr[] = {5, 1, 3, 4, 2, 7};
        Node root = null;
        for (int i : arr) {
            root = buildbst(root, i);
        }

        Inorder(root);
        System.out.println("");
        PrintInRange(root,3,5 );
        System.out.println("");

        if(search(root, 4)){
             System.out.println("Found");
        }else{
            System.out.println("Not Found");
        }

        root = delete(root, 3);
        Inorder(root);
        
    }

}
