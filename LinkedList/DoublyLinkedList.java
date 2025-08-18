class DoublyLinkedList {

    public static void main(String arg[]) {
        LinkedList list = new LinkedList();

        list.Append(5);
        list.Append(8);
        list.InsertAtHead(7);
        list.InsertAtPos(10,1);
        list.RemoveHead();
        list.Append(14);
        list.RemoveAtEnd();
        list.Append(12);
        list.RemoveAtPos(2);
        list.display();

    }
}

class Node {

    int data;
    Node next;
    Node prev;

    Node(int data) {
        this.data = data;
        this.next = null;
        this.prev = null;
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
        newNode.prev = temp;

    }

    void InsertAtHead(int data){

          Node newNode = new Node(data);

        if (head == null) {
            head = newNode;
            return;
        }

        newNode.next = head;
        head.prev = newNode;
        head = newNode;
       

    }

    void InsertAtPos(int data,int pos){

        Node newNode = new Node(data);

        if(head == null){
            head = newNode;
            return;
        }

        if(pos == 0){
            InsertAtHead(data);
            
        }

        Node temp = head;
        int itr = 0;

        while(itr!=  pos){
            temp = temp.next;
            itr++;
        }

        newNode.prev = temp.prev;
        temp.prev.next = newNode;
        newNode.next = temp;
        temp.prev = newNode;

    }

    void RemoveHead(){
        if (head == null){
            System.out.println("Empty");
            
        }

        head = head.next;
        head.prev = null;

    }

    void RemoveAtEnd(){

        if (head == null){
            System.out.println("Empty");
            
        } 

        Node temp = head;
        while(temp.next!= null){
            temp = temp.next;

        }

        temp.prev.next = null;

    }

    void RemoveAtPos(int pos){

            if (head == null){
            System.out.println("Empty");
            
        } 

        if(pos == 0){
            RemoveHead();
        }
        
        Node temp = head;
        int itr = 0;

        while(itr!= pos){
            temp = temp.next;
            itr++;
        }

        temp.prev.next = temp.next;
        temp.next.prev = temp.prev;




        
    }

    void display() {

        Node temp = head;

        if (head == null) {
            System.out.println("Empty LinkedList");
            return;
        }

        while (temp != null) {
            System.out.print(temp.data + "<-->");
            temp = temp.next;
        }
        System.out.print("NULL");
    }
}
