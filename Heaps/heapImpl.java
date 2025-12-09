
import java.util.ArrayList;

public class heapImpl {

    static class Heap {

        ArrayList<Integer> arr = new ArrayList<>();

        public void add(int data) {  
            arr.add(data);
            int x = arr.size() - 1;      // index of added element
            int parent = (x - 1) / 2;

            // heapify-up
            while (x > 0 && arr.get(x) < arr.get(parent)) { // for maxheap change < to >
                // swap
                int temp = arr.get(x);
                arr.set(x, arr.get(parent));
                arr.set(parent, temp);

                // move up
                x = parent;
                parent = (x - 1) / 2;
            }
        }

        public int peek() {
            if (arr.size() == 0) {
                throw new IllegalStateException("Heap is empty");
            }
            return arr.get(0);
        }

        private void heapify(int i) {

            int left = 2 * i + 1;
            int right = 2 * i + 2;
            int minidx = i;

            if (left <= arr.size() - 1 && arr.get(minidx) > arr.get(left)) {   // for maxheap change > to <
                minidx = left;
            }
            if (right <= arr.size() - 1 && arr.get(minidx) > arr.get(right)) {
                minidx = right;
            }

            if (minidx != i) {
                int temp = arr.get(i);
                arr.set(i, arr.get(minidx));
                arr.set(minidx, temp);

                heapify(minidx);
            }

        }

        public int remove() {
            int data = arr.get(0);

            // step - 1 // swap first and last
            int temp = arr.get(0);
            arr.set(0, arr.get(arr.size() - 1));
            arr.set(arr.size() - 1, temp);

            // step - 2 // remove last
            arr.remove(arr.size() - 1);

            // heapify
            heapify(0);
            return data;

        }
    }

    public static void main(String[] args) {

        // This heap work as priority queue ( min heap )
        // if we want max heap then we have to change the comparison sign in add and heapify method 
        
        Heap heap = new Heap();   // create heap object

        heap.add(10);
        heap.add(4);
        heap.add(15);
        heap.add(1);
        heap.add(-5);
        heap.add(3);

        System.out.println("Min element (peek): " + heap.peek());

        heap.remove();

        System.out.println("Min element (peek): " + heap.peek());

        heap.remove();

        System.out.println("Min element (peek): " + heap.peek());
    }
}
