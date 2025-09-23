import java.util.*;
public class Sumtree {

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

    public static Node buildTree(int nodes[]) {

        idx++;

        if (nodes[idx] == -1) {
            return null;
        }

        Node root = new Node(nodes[idx]);
        root.left = buildTree(nodes);
        root.right = buildTree(nodes);

        return root;

    }

    public static void LevelOrder(Node root) {

        if (root == null) {
            return;
        }

        Queue<Node> q = new LinkedList<>();
        q.add(root);
        q.add(null);
        while (!q.isEmpty()) {
            Node currNode = q.remove();
            if (currNode == null) {
                System.out.println();
                if (q.isEmpty()) {
                    break;
                } else {
                    q.add(null);
                }
            } else {
                System.out.print(currNode.data + " ");
                if (currNode.left != null) {
                    q.add(currNode.left);
                }
                if (currNode.right != null) {
                    q.add(currNode.right);
                }
            }
        }

    }

    public static int sumtree(Node root) {

        if(root == null){
            return 0;
        }

        int ls = sumtree(root.left);
        int rs = sumtree(root.right);

        int data = root.data;
        root.data = ls + rs;
        return data + root.data;  
        

    }

    public static void main(String[] args) {

        int nodes[] = {1, 2, 4, -1, -1, 5, -1, -1, 3, 6, -1, -1, 7, -1, -1};
        Node root = buildTree(nodes);
        LevelOrder(root);
        sumtree(root);
        System.out.println();
        LevelOrder(root);

    }

}
