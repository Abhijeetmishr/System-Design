package DSA.Heap;
import java.util.*;

/*
 * https://leetcode.com/problems/k-closest-points-to-origin/solutions/220235/java-three-solutions-to-this-classical-k-th-problem/
 */
public class KClosestPoint {
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<Pair> pq = new PriorityQueue<>();

        for(int i = 0; i < points.length; i++){
            int x = points[i][0];
            int y = points[i][1];

            int dist = x*x + y*y;

            if(pq.size() < k){
                pq.add(new Pair(dist, i));
            } else {
                if(pq.peek().dist > dist){
                    pq.poll();
                    pq.add(new Pair(dist, i));
                }
               
            }
        }
        int[][] res = new int[k][2];
        int i = 0;
        while(!pq.isEmpty()){
            int index = pq.peek().point;
            pq.poll();
            res[i] = points[index];
            i++;
        }
        return res;
    }

    class Pair implements Comparable<Pair>{
        int dist;
        int point;
        Pair(int dist, int point){
            this.dist = dist;
            this.point = point;
        }

        @Override
        public int compareTo(Pair o){
            return Integer.compare(o.dist, dist);
        }
    }
}
