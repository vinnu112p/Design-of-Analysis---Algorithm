
public class SinglyLinkedList {


 public static boolean isCycle(Node head){

        Node slow = head;
        Node fast = head;

        while(fast!= null && fast.next!= null){
            slow = slow.next;
            fast = fast.next.next;

            if(slow == fast){
                return true;
            }
        }

        return false;

    }


    public static void breakCycle(Node heads){

        if(!isCycle(heads)){
            System.out.println("No cycle exist");
            return;
        }

        Node slow = heads;
        Node fast = heads;

        while(fast!= null && fast.next!= null){
            slow = slow.next;
            fast = fast.next.next;

            if(slow == fast){
                 break;
            }
        }

        // slow = heads;
        // Node pre = null;

        // while(slow!= fast){
        //     pre = fast;
        //     slow = slow.next;
        //     fast = fast.next;
        // }
        // if(pre!= null){

        // pre.next = null;
        // }

          // Find the start of the cycle
    slow = heads;
    if (slow == fast) {
        // Cycle starts at head
        while (fast.next != slow) {
            fast = fast.next;
        }
        fast.next = null;
    } else {
        // Cycle starts elsewhere
        while (slow.next != fast.next) {
            slow = slow.next;
            fast = fast.next;
        }
        fast.next = null;
    }
        
    }

    public static void main(String arg[]) {

        LinkedList bucket = new LinkedList();
        // bucket.Append(7);
        // bucket.Append(8);
        // bucket.Append(10);
        // bucket.InsertAtHead(4);
        // bucket.InsertAtPos(5,1);
        // bucket.show();
        // bucket.removeNthfromEnd(3);
        // bucket.show();
        // bucket.reverse();
        // bucket.show();
        // System.out.println(bucket.search(11));
        // bucket.Append(12);
        // bucket.RemoveHead();
        // bucket.RemoveHead();
        // bucket.RemoveAtPos(1);
        // bucket.RemoveEnd();
        // bucket.RemoveEnd();
        // bucket.show();

        //Palindrome
        bucket.Append(3);
        bucket.Append(2);
        bucket.Append(1);
        // bucket.Append(3);
        bucket.Append(1);
        bucket.Append(2);
        bucket.Append(3);
        bucket.show();
        if (bucket.Palindrome()) {
            System.out.println("Palindrome");
        } else {
            System.out.println("Not");
        }
        //Cycle linkedlist
        Node heads = new Node(1);
        heads.next = new Node(2);
        heads.next.next = new Node(3);
        heads.next.next.next = heads;

        // 1->2->3->1
        if(isCycle(heads)){
            System.out.println("Cycle");
        }

        breakCycle(heads);
        breakCycle(heads);
        if(isCycle(heads)){
            System.out.println("Cycle");
        }

        

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

    void InsertAtHead(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
            return;
        }

        newNode.next = head;
        head = newNode;

    }

    void InsertAtPos(int data, int pos) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
            return;
        }

        if (pos == 0) {
            InsertAtHead(data);
            return;
        }

        int itr = 0;
        Node temp = head;

        while (itr != pos - 1) {
            temp = temp.next;
            itr++;
        }

        Node temp1 = temp.next;
        temp.next = newNode;
        newNode.next = temp1;

    }

    void RemoveHead() {
        if (head == null) {
            System.out.println("Empty");
            return;
        }

        head = head.next;
    }

    void RemoveAtPos(int pos) {

        if (head == null) {
            System.out.println("Empty");
            return;
        }

        if (pos == 0) {
            RemoveHead();
            return;
        }

        Node temp = head;
        int itr = 0;

        while (itr != pos - 1) {
            temp = temp.next;
            itr++;
        }

        temp.next = temp.next.next;

    }

    void RemoveEnd() {
        if (head == null) {
            System.out.println("Empty");
            return;
        }

        if (head.next == null) { // Only one node
            head = null;
            return;
        }

        Node temp = head;
        Node prev = null;
        while (temp.next != null) {
            prev = temp;
            temp = temp.next;

        }

        prev.next = null;

    }

    int search(int target) {

        Node temp = head;
        int pos = 1;
        while (temp != null) {
            if (temp.data == target) {
                return pos;
            }

            temp = temp.next;
            pos++;
        }

        return -1;

    }

    void reverse() {

        Node curr = head;
        Node prev = null;
        Node next;

        while (head != null) {
            next = head.next;
            head.next = prev;
            prev = head;
            head = next;
        }

        head = prev;

    }

    void removeNthfromEnd(int n) {

        Node temp = head;
        int size = 0;

        while (temp != null) {
            temp = temp.next;
            size++;
        }

        RemoveAtPos((size - n));

    }

    Node findMid() {

        Node slow = head;
        Node fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;

    }

    boolean Palindrome() {

        Node mid = findMid();
        Node temp = head;

        Node curr = mid;
        Node prev = null;
        Node next;

        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        curr = prev;

        while (temp.next != null && curr.next != null) {
            if (temp.data == curr.data) {

                temp = temp.next;
                curr = curr.next;
            } else {
                return false;
            }
        }

        return true;
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
