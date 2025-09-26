public class SizeOfLargestBstInBt{

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

    static class Info{
        boolean isBst;
        int size;
        int min;
        int max;

        public Info(boolean isBst, int max, int min, int size) {
            this.isBst = isBst;
            this.max = max;
            this.min = min;
            this.size = size;
        }

        
    }

    public static int maxBst = 0;
    public static Info largestBst(Node root){

        if(root == null){
            return new Info(true, Integer.MIN_VALUE, Integer.MAX_VALUE , 0);
        }

        Info leftInfo = largestBst(root.left);
        Info RightInfo = largestBst(root.right);
        int size = leftInfo.size + RightInfo.size + 1;
        int min = Math.min(root.data, Math.min(leftInfo.min, RightInfo.min));
        int max = Math.max(root.data, Math.max(leftInfo.max, RightInfo.max));


        // checking isbst

        if(root.data <= leftInfo.max || root.data >= RightInfo.min){
            return new Info(false, max, min, size);
        }

        if(leftInfo.isBst && RightInfo.isBst){
            maxBst = Math.max(maxBst, size);
            return new Info(true, max, min, size);
        }

        return new Info(false, max, min, size);

    }

    public static void main(String[] args) {
        
            //                 50

                
            //          30             60

            //      5       20     45        70

            //                            65     80

            Node root = new Node(50);
            root.left = new Node(30);
            root.left.left = new Node(5);
            root.left.right = new Node(20);

            root.right = new Node(60);
            root.right.left = new Node(45);
            root.right.right = new Node(70);
            root.right.right.left = new Node(65);
            root.right.right.right = new Node(80);

            Info info = largestBst(root);
            System.out.println("Size of largest bst is : " + maxBst);


    }

}