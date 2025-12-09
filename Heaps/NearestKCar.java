
import java.util.PriorityQueue;


class NearestKCar {

    static class Point implements Comparable<Point>{

        int x;
        int y;
        int distSqr;
        int idx;

        public Point(int x,int y,int distSqr,int idx){
            this.x = x;
            this.y = y;
            this.distSqr = distSqr;
            this.idx = idx;
        }

        @Override
        public int compareTo(Point p2){
            return this.distSqr-p2.distSqr;
        }


    }

    public static void main(String[] args) {
        int pts[][] = {{3,3},{5,-1},{-2,4}};
        int k = 2;

        PriorityQueue<Point> pq  = new PriorityQueue<>();

        for(int i = 0; i < pts.length; i++){
            int disq = pts[i][0]*pts[i][0] + pts[i][1]*pts[i][1];
            pq.add(new Point(pts[i][0],pts[i][1],disq,i));
        }

        for(int i = 0; i < k ; i++){
            System.out.println("C" + pq.remove().idx);
        }


        // this question is about finding k nearest car to the origin (0,0) 




    }

}