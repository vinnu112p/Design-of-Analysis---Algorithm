public class CircularQueue{

    static class Queue{
        int arr[];
        int size;
        int front;
        int rear;

    public Queue(int n){
        this.size = n;
        arr = new int[n];
        front = -1;
        rear = -1;
    }

    public boolean isEmpty(){
        return front == -1;
    }

    public void add(int n){
        if((rear+1)%size == front ){
            System.out.println("Overflow");
            return;
        }

        if(front == -1 && rear == -1){
            front = (front+1) % size;
            rear = (rear+1) % size;
            arr[rear] = n;
            return;
        }

        rear = (rear+1) % size;
        arr[rear] = n;
    }

    public void remove(){

        if(isEmpty()){
            System.out.println("Underflow");
            return;
        }

        if(front == rear){
            int n = arr[front];
            front = -1;
            rear = -1;
            System.out.println("Popped: " + n );
            return;
        }
        int n = arr[front];
        front  = (front+1) % size;
        System.out.println("Popped: " + n );

    }

     public void print() {
            if (isEmpty()) {
                System.out.println("Queue is empty");
                return;
            }

            System.out.print("Queue: ");
            int i = front;
            while (true) {
                System.out.print(arr[i] + " ");
                if (i == rear)
                    break;
                i = (i + 1) % size;
            }
            System.out.println();
        }

    }

    public static void main(String[] args) {

        Queue q = new Queue(5);
        q.add(5);
        q.add(4);
        q.add(6);
        q.add(7);
        q.add(8);
        q.add(9);
        q.remove();
        q.add(10);
        q.print();
        
        
    }

}