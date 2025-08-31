
class ZigZag {

    public static void main(String[] args) {

        LinkedList ll = new LinkedList();
        ll.Append(1);
        ll.Append(2);
        ll.Append(3);
        ll.Append(4);
        ll.Append(5);
        ll.show();
        ll.zigizigi();
        ll.show();

    }

}

class Node {

    int data;
    Node next;

    Node(int data) {
        this.data = data;
        this.next = null;
    }
}

class LinkedList {

    Node head;

    void Append(int data) {

        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
            return;
        }

        Node temp = head;

        while (temp.next != null) {

            temp = temp.next;
        }

        temp.next = newNode;

    }

    public Node findMid() {

        Node slow = head;
        Node fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;

    }

   public void zigizigi() {
    // Find mid
    Node mid = findMid();
    Node second = mid.next;
    mid.next = null; // Break the list

    // Reverse second half
    Node prev = null;
    Node curr = second;
    Node next;
    while (curr != null) {
        next = curr.next;
        curr.next = prev;
        prev = curr;
        curr = next;
    }
    Node first = head;
    Node secondHalf = prev;

    // Merge zigzag
    while (first != null && secondHalf != null) {
        Node temp1 = first.next;
        Node temp2 = secondHalf.next;
        first.next = secondHalf;
        if (temp1 == null) break;
        secondHalf.next = temp1;
        first = temp1;
        secondHalf = temp2;
    }
}

    void show() {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + "-->");
            temp = temp.next;
        }
        System.out.println("Null");
    }

}
