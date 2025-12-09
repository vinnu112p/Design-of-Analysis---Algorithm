
import java.util.PriorityQueue;

public class PriorityQueueDemo {

    static class Student implements Comparable<Student> {

        String name;
        int rank;

        Student(String name, int rank) {
            this.name = name;
            this.rank = rank;
        }

        // @Override
        // public int compareTo(Student s2) {
        //     return this.rank - s2.rank; // min heap
        // }

        @Override
        public int compareTo(Student s2) {
            return this.name.compareTo(s2.name); // alphabetical min-heap
        }

    }

    public static void main(String arg[]) {

        // PriorityQueue<Integer> pq = new PriorityQueue<>();
        // pq.add(4);
        // pq.add(7);
        // pq.add(1);
        // pq.add(9);
        // pq.add(2);
        // while (!pq.isEmpty()) {
        //     System.out.print(pq.peek() + " ");
        //     pq.remove();
        // }
        PriorityQueue<Student> st = new PriorityQueue<>();

        st.add(new Student("Aryan", 10));
        st.add(new Student("Alex", 1));
        st.add(new Student("Sara", 4));
        st.add(new Student("Zara", 2));

        while (!st.isEmpty()) {
            System.err.println("Name :" + st.peek().name + " Rank : " + st.peek().rank);
            st.remove();
        }

    }

}
