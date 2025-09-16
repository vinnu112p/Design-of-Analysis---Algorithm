import java.util.*;
public class BinaryTree {

    static class Node {

        int data;
        Node left;
        Node right;

        Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    static int idx = -1;
    

    public static Node buildtree(int nodes[]) {

        idx++;

        if (nodes[idx] == -1) {
            return null;
        }

        Node newNode = new Node(nodes[idx]);
        newNode.left = buildtree(nodes);
        newNode.right = buildtree(nodes);

        return newNode;

    }

    public static void Preorder(Node root) {

        if (root == null) {
            return;
        }
        System.out.print(root.data + " ");
        Preorder(root.left);
        Preorder(root.right);
        

    }

    public static void Inorder(Node root) {

        if (root == null) {
            return;
        }
        Inorder(root.left);
        System.out.print(root.data + " ");
        Inorder(root.right);

        

    }

    public static void PostOrder(Node root) {

        if (root == null) {
            return;
        }
        PostOrder(root.left);
        PostOrder(root.right);
        System.out.print(root.data + " ");

    }

    public static void LevelOrder(Node root){

            if(root == null){
                return;
            }

            Queue<Node> q = new LinkedList<>();
            q.add(root);
            q.add(null);
            while(!q.isEmpty()){
                Node currNode = q.remove();
                if(currNode == null){
                    System.out.println();
                    if(q.isEmpty()){
                        break;
                    }else{
                        q.add(null);
                    }
                }else{
                    System.out.print(currNode.data + " ");
                    if(currNode.left != null){
                        q.add(currNode.left);
                    }
                    if(currNode.right != null){
                        q.add(currNode.right);
                    }
                }
            }



    }

    public static int height(Node root){

        if(root == null){
            return 0;
        }

        int lh = height(root.left);
        int rh = height(root.right);

        return Math.max(lh, rh) + 1;        

    }

    public static int TotalNode(Node root){

        if(root == null){
            return 0;
        }

        int leftCount = TotalNode(root.left);
        int rightCount = TotalNode(root.right);

        return leftCount + rightCount + 1;

    }

    public static int Diameter(Node root){   // Diameter is the number of nodes in the longest path from one to other

    if(root == null){
        return 0;
    }

    int ld = Diameter(root.left);
    int lh = height(root.left);
    int rd = Diameter(root.right);
    int rh = height(root.right);
    int Sd = lh+rh+1;

    return Math.max(Math.max(ld, rd),Sd);

    }

    public static void main(String[] args) {

        int nodes[] = {1, 2, 4, -1, -1, 5, -1, -1, 3, -1, 6, -1, -1};
        Node root = buildtree(nodes);

        System.out.println(root.data);
        Preorder(root);
        System.out.println("");
        
        Inorder(root);
        System.out.println("");
        PostOrder(root);
        System.out.println("");
        LevelOrder(root);
       
        System.out.println("Height : " + height(root));
        System.out.println("Total Nodes : " + TotalNode(root));
        System.out.println("Diameter: " + Diameter(root));

    }

}

/*
Tree Structure:
        1
      /   \
     2     3
    / \     \
   4   5     6
*/
