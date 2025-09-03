
class Node {

    int data;
    Node next;

    public Node(int data) {
        this.data = data;
        this.next = null;
    }

}

 class Stack {

    Node head = null;

    public boolean isEmpty() {
        return head == null;
    }

    public void push(int data) {
        Node newNode = new Node(data);

        if (isEmpty()) {
            head = newNode;
            return;
        }

        newNode.next = head;
        head = newNode;
    }

    public int pop() {

        if (isEmpty()) {
            System.out.println("Stack underflow");
            return -1;
        }

        int top = head.data;
        head = head.next;
        return top;

    }

    public int peek() {
        return head.data;
    }

}

public class stackLL {

    public static void main(String[] args) {

        Stack sc = new Stack();
        sc.push(1);
        sc.push(2);
        sc.push(3);

        while (!sc.isEmpty()) {
            System.out.println(sc.pop());
            
        }

    }

}
