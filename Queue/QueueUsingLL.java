public class QueueUsingLL{

    static class Node{
        int data;
        Node next;

        Node(int n){
            this.data = n;
            this.next = null;
        }
    }

    static class Queue{

        Node head = null;
        Node tail = null;

        public boolean isEmpty(){
            return head == null;
        }

        public void add(int n){

            Node newNode = new Node(n);

        if(head == null && tail == null){
            head = newNode;
            tail = newNode;
        }else{
            tail.next = newNode;
            tail = tail.next;
        }



        }

        public void remove(){

            if(isEmpty()){
                System.out.println("Underflow");
                return;
            }

            int n = head.data;
            System.out.println("Removed: " + n);
            head = head.next;

        }

        public void print(){

            Node temp = head;

            while(temp!= null){
                System.out.print(temp.data + "--> ");
                temp = temp.next;
            }
            System.out.println("");

        }

    }



    public static void main(String[] args) {
        Queue q = new Queue();
        q.add(1);
        q.add(2);
        q.add(3);
        q.print();
        q.remove();
        q.print();
        q.add(4);
        q.print();
    }

}