public class SinglyLinkedList{
    
    public static void main(String arg[]){
        
        LinkedList bucket = new LinkedList();
        bucket.Append(7);
        bucket.Append(8);
        bucket.Append(10);
        bucket.InsertAtHead(4);
        bucket.InsertAtPos(5,1);
        bucket.show();
        bucket.Append(12);
        bucket.RemoveHead();
        bucket.RemoveHead();
        bucket.RemoveAtPos(1);
        bucket.RemoveEnd();
        bucket.show();
        
    }
}


class Node{
    int data;
    Node next;
    
    Node(int data){
        this.data = data;
        this.next = null;
    }
}

class LinkedList{
    Node head;
    void Append(int data){
        
        Node newNode = new Node(data);
        if (head == null){
            head = newNode;
            return;
        }
        
        Node temp = head;
       
        while(temp.next!= null){
          
            temp = temp.next;
        }
        
        temp.next=  newNode;
        
    }
    
    void InsertAtHead(int data){
        Node newNode = new Node(data);
        if (head == null){
            head = newNode;
            return;
        }
        
        newNode.next = head;
        head = newNode;
        
    }
    
    void InsertAtPos(int data,int pos){
        Node newNode = new Node(data);
        if (head == null){
            head = newNode;
            return;
        }
        
        if (pos == 0){
            InsertAtHead(data);
            return;
        }
        
        int itr = 0;
        Node temp = head;
        
        while(itr!= pos-1){
            temp = temp.next;
            itr++;
        }
        
        
        Node temp1 = temp.next;
        temp.next = newNode;
        newNode.next = temp1;
        
    }
    
    void RemoveHead(){
        if(head == null){
            System.out.println("Empty");
            return;
        }
        
        head = head.next;
    }
    
    void RemoveAtPos(int pos){
        
         if(head == null){
            System.out.println("Empty");
            return;
        }
        
        if(pos == 0){
            RemoveHead();
            return;
        }
        
        Node temp = head;
        int itr = 0;
        
        while(itr!= pos-1){
            temp = temp.next;
            itr++;
        }
        
        temp.next = temp.next.next;
        
        
    }
    
    void RemoveEnd(){
        if(head == null){
            System.out.println("Empty");
            return;
        }
        
        Node temp = head;
        Node prev = null;
        while(temp.next!= null){
            prev = temp;
            temp = temp.next;
         
        }
        
        prev.next = null;
        
    }
    
    void show(){
        Node temp = head;
        while(temp!= null){
            System.out.print(temp.data + "-->");
            temp = temp.next;     
            }
            System.out.println("Null");
    }
}

