
import java.util.Stack;

class QueueUsingStack {

    Stack<Integer> s1 = new Stack<>();
    Stack<Integer> s2 = new Stack<>();
   

    public void add(int n) {

        if (s1.isEmpty()) {
            s1.add(n);
        } else {
            while (!s1.isEmpty()) {
                s2.add(s1.pop());
            }

            s1.add(n);

            while (!s2.isEmpty()) {
                s1.add(s2.pop());
            }

        }

    }

    public void remove(){
        if(s1.isEmpty()){
            System.out.println("Underflow");
            return;
        }

        int n = (int) s1.pop();
        System.out.println("Popped: "+ n);

    }

    public void print() {

        while (!s1.isEmpty()) {
            System.out.print(s1.peek() + " ");
            s2.add(s1.pop());
        }

        System.out.println("");

        while (!s2.isEmpty()) {
            s1.add(s2.pop());
        }

    }

@SuppressWarnings("unchecked")
    public static void main(String[] args) {

        QueueUsingStack q = new QueueUsingStack();

        q.add(5);
        q.add(7);
        q.add(8);
        q.add(1);
        q.add(2);
        q.print();
        q.remove();
        q.remove();
        q.print();
        q.add(10);
        q.add(45);
        q.print();


    }

}
