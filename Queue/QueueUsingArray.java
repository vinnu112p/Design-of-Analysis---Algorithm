
class QueueUsingArray {

    static class Queue {

        int arr[];
        int size;
        int rear;
        int front;

        public Queue(int n) {

            arr = new int[n];
            this.size = n;
            this.front = -1;
            this.rear = -1;

        }

        public boolean isEmpty() {
            return rear == -1;
        }

        public void add(int n) {
            if (rear == size - 1) {
                System.out.println("Overflow");
                return;
            }

            if (front == -1 && rear == -1) {
                front++;
                rear++;
                arr[rear] = n;
            } else {
                arr[++rear] = n;
            }

        }

        public void remove() {
            if (front > rear || front != -1) {
                System.out.println("Underflow");
                return;

            }

            int n = arr[front++];
            System.out.println("Popped : " + n);
        }

        public void peek() {
            System.out.println("Peek : " + arr[front]);
        }

        public void print() {
            for (int i = front; i <= rear; i++) {
                System.out.print(arr[i] + " ");
            }
            System.out.println("");
        }

    }

    public static void main(String arg[]) {

        Queue q = new Queue(5);

        q.add(5);
        q.add(6);
        q.add(8);
        q.add(9);
        q.add(91);
        q.print();
        q.add(7);

        q.peek();
        q.remove();
        q.peek();

    }

}
