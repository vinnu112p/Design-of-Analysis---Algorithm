public class MirrorBST{

static class Node{
    int data;
    Node left;
    Node right;

    Node(int d){
        this.data = d;
        this.left = null;
        this.right = null;
    }
}

public static Node mirror(Node root){
    if(root == null){
        return null;
    }

    Node leftSub = mirror(root.left);
    Node rightSub = mirror(root.right);

    root.left = rightSub;
    root.right = leftSub;
    return root;

}

public static void preOrder(Node root){
    if(root == null){
        return;
    }
    System.out.print(root.data + " ");
    preOrder(root.left);
    preOrder(root.right);
}

public static void main(String[] args) {
    
        //         8
        //     5       10
        
        // 3     6         11

    Node root = new Node(8);
    root.left = new Node(5);
    root.right = new Node(10);
    root.left.left = new Node(3);
    root.left.right = new Node(6);
    root.right.right = new Node(11);

    preOrder(root);
    System.out.println("");
    mirror(root);
    preOrder(root);



}

}