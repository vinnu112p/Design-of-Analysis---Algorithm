
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

    public static int height(Node root) {

        if (root == null) {
            return 0;
        }

        int lh = height(root.left);
        int rh = height(root.right);

        return Math.max(lh, rh) + 1;

    }

    public static int TotalNode(Node root) {

        if (root == null) {
            return 0;
        }

        int leftCount = TotalNode(root.left);
        int rightCount = TotalNode(root.right);

        return leftCount + rightCount + 1;

    }

    public static int Diameter(Node root) {   // Diameter is the number of nodes in the longest path from one to other

        if (root == null) {
            return 0;
        }

        int ld = Diameter(root.left);
        int lh = height(root.left);
        int rd = Diameter(root.right);
        int rh = height(root.right);
        int Sd = lh + rh + 1;

        return Math.max(Math.max(ld, rd), Sd);

    }

    static class Info {

        int diameter;
        int height;

        Info(int d, int h) {
            this.diameter = d;
            this.height = h;
        }
    }

    public static Info DiameterOptimized(Node root) { // O(n)

        if (root == null) {
            return new Info(0, 0);
        }

        Info leftinfo = DiameterOptimized(root.left);
        Info Rightinfo = DiameterOptimized(root.right);
        int dia = Math.max(Math.max(leftinfo.diameter, Rightinfo.diameter), leftinfo.height + Rightinfo.height + 1);
        int height = Math.max(leftinfo.height, Rightinfo.height) + 1;

        return new Info(dia, height);

    }

    public static boolean isIdentical(Node node, Node subroot) {

        if (node == null && subroot == null) {
            return true;
        } else if (node == null || subroot == null || node.data != subroot.data) {
            return false;
        }

        if (!isIdentical(node.left, subroot.left)) {
            return false;
        }
        if (!isIdentical(node.right, subroot.right)) {
            return false;
        }

        return true;

    }

    public static boolean isSubtree(Node root, Node subTree) {

        if (root == null) {
            return false;
        }

        if (root.data == subTree.data) {
            if (isIdentical(root, subTree)) {
                return true;
            }
        }

        return isSubtree(root.left, subTree) || isSubtree(root.right, subTree);

    }

    static class Infor {

        Node node;
        int hd;

        Infor(Node node, int hd) {
            this.node = node;
            this.hd = hd;
        }
    }

    public static void topView(Node root) {
        Queue<Infor> q = new LinkedList<>();
        HashMap<Integer, Node> map = new HashMap<>();
        int min = 0, max = 0;
        q.add(new Infor(root, 0));
        q.add(null);

        while (!q.isEmpty()) {
            Infor curr = q.remove();
            if (curr == null) {
                if (q.isEmpty()) {
                    break;
                } else {
                    q.add(null);
                }
            } else {

                if (!map.containsKey(curr.hd)) {
                    map.put(curr.hd, curr.node);
                }

                if (curr.node.left != null) {
                    q.add(new Infor(curr.node.left, curr.hd - 1));
                    min = Math.min(min, curr.hd - 1);
                }

                if (curr.node.right != null) {
                    q.add(new Infor(curr.node.right, curr.hd + 1));
                    max = Math.max(max, curr.hd + 1);
                }

            }

        }

        for (int i = min; i <= max; i++) {
            System.out.print(map.get(i).data + " ");
        }

    }

    public static void Klevel(Node root, int lvl, int k) {

        if (root == null) {
            return;
        }

        if (lvl == k) {
            System.out.print(root.data + " ");
            return;
        }

        Klevel(root.left, lvl + 1, k);
        Klevel(root.right, lvl + 1, k);

    }

    public static boolean getPath(Node root, int n, ArrayList<Node> path) {

        if (root == null) {
            return false;
        }

        path.add(root);
        if (root.data == n) {
            return true;

        }

        boolean foundLeft = getPath(root.left, n, path);
        boolean foundRight = getPath(root.right, n, path);

        if (foundLeft || foundRight) {
            return true;
        }

        path.remove(path.size() - 1);
        return false;

    }

    public static Node lca(Node root, int n1, int n2) {    // Lowest Common Ancestor

        ArrayList<Node> path1 = new ArrayList<>();
        ArrayList<Node> path2 = new ArrayList<>();

        getPath(root, n1, path1);
        getPath(root, n2, path2);
        int i = 0;
        for (; i < path1.size() && i < path2.size(); i++) {

            if (path1.get(i) != path2.get(i)) {
                break;
            }

        }

        Node lca = path1.get(i - 1);

        return lca;

    }

    public static Node lca2(Node root, int n1, int n2) {

        if (root == null || root.data == n1 || root.data == n2) {
            return root;
        }

        Node leftlca = lca2(root.left, n1, n2);
        Node rightlca = lca2(root.right, n1, n2);

        if (leftlca == null && rightlca == null) {
            return null;
        }

        if (leftlca != null && rightlca != null) {
            return root;
        }

        if (leftlca != null) {
            return leftlca;
        } else {
            return rightlca;
        }

    }

    public static int helperdis(Node root, int n) {
        if (root == null) {
            return -1;
        }
        if (root.data == n) {
            return 0;
        }

        int ld = helperdis(root.left, n);
        int rd = helperdis(root.right, n);

        if (ld != -1) {
            return ld + 1;
        }
        if (rd != -1) {
            return rd + 1;
        }
        return -1;
    }

    public static int minDistance(Node root, int n1, int n2) {

        if (root == null) {
            return 0;
        }

        Node lca = lca2(root, n1, n2);

        int ld = helperdis(lca, n1);
        int rd = helperdis(lca, n2);

        return ld + rd;

    }

    public static int kthAncestor(Node root, int n, int k) {

        if (root == null) {
            return -1;
        }

        if (root.data == n) {
            return 0;
        }

        int ld = kthAncestor(root.left, n, k);
        int rd = kthAncestor(root.right, n, k);

        if (ld == -1 && rd == -1) {
            return -1;
        }

        int max = Math.max(ld, rd);
        if (max +1  == k) {
            System.out.println(root.data);
        }

        return max+1;
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
        Info f = DiameterOptimized(root);
        System.out.println("Diameter: " + f.diameter + " Height: " + f.height);

        // Manually create a different tree:
        /*
        New Tree Structure:
                10
               /  \
              7    15
             /    /  \
            5    12   18
         */
        Node root2 = new Node(10);
        root2.left = new Node(7);
        root2.right = new Node(15);
        root2.left.left = new Node(5);
        root2.right.left = new Node(12);
        root2.right.right = new Node(18);

        /*
          Subtree Structure:
                 15
                / \
               12   18
         */
        Node subtree = new Node(15);
        subtree.left = new Node(12);
        subtree.right = new Node(18);

        if (isSubtree(root2, subtree)) {
            System.out.println("Subtree Exist");
        } else {
            System.out.println("Subtree do not exist");
        }

        // top view 
        topView(root2);
        System.out.println("");
        topView(root);
        System.out.println("");

        Klevel(root, 1, 3);
        System.out.println("");
        Klevel(root, 1, 2);
        System.out.println("");
        System.out.println(lca(root, 4, 6).data);

        System.out.println(lca2(root, 4, 5).data);

        System.out.println("Min distance btw 4 & 6: " + minDistance(root, 4, 6));
        System.out.println("Min distance btw 5 & 15: " + minDistance(root2, 5, 15));
        System.out.println("Kth 2 Ancestor of 4 is: " + kthAncestor(root, 4, 2));

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
