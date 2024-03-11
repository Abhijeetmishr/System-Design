package DSA.Heap;
import java.util.*;
    
/**
 * https://www.geeksforgeeks.org/k-maximum-sum-combinations-two-arrays/
 */
class MaxKValidSum {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int k = sc.nextInt();

        int a[] = new int[n];
        int b[] = new int[n];

        for (int i = 0; i < n; i++)
            a[i] = sc.nextInt();

        for (int i = 0; i < n; i++)
            b[i] = sc.nextInt();

        ArrayList<Integer> res = maxKSum(n, k, a, b);

        for (int j : res)
            System.out.print(j + " ");

    }

    static ArrayList<Integer> maxKSum(int n, int k, int[] a, int[] b) {
        Arrays.sort(a);
        Arrays.sort(b);
        PriorityQueue<PairSum> pq = new PriorityQueue<>();

        int l = n-1;
        int m = n-1;
        HashSet<Pair> set = new HashSet<>();

        set.add(new Pair(l, m));
        pq.add(new PairSum(l, m, a[l] + b[m]));
        int c = 0;
        ArrayList<Integer> res = new ArrayList<>();
        while(c++ < k) {
            PairSum max = pq.poll();
            res.add(max.sum);

            l = max.l - 1;
            m = max.m;

            if(!set.contains(new Pair(l, m)) && l >= 0 && m >= 0){
                set.add(new Pair(l, m));
                pq.add(new PairSum(l, m, a[l] + b[m]));
            }
            
            l = max.l;
            m = max.m - 1;

            if(!set.contains(new Pair(l, m)) && l >= 0 && m >= 0){
                set.add(new Pair(l, m));
                pq.add(new PairSum(l, m, a[l] + b[m]));
            }
        }
        return res;
    }

    public static class Pair {
 
        public Pair(int l, int m)
        {
            this.l = l;
            this.m = m;
        }
 
        int l;
        int m;
 
        @Override public boolean equals(Object o)
        {
            if (o == null) {
                return false;
            }
            if (!(o instanceof Pair)) {
                return false;
            }
            Pair obj = (Pair)o;
            return (l == obj.l && m == obj.m);
        }
 
        @Override public int hashCode()
        {
            return Objects.hash(l, m);
        }
    }
 
    public static class PairSum
        implements Comparable<PairSum> {
 
        public PairSum(int l, int m, int sum)
        {
            this.sum = sum;
            this.l = l;
            this.m = m;
        }
 
        int sum;
        int l;
        int m;
 
        @Override public int compareTo(PairSum o)
        {
            return Integer.compare(o.sum, sum);
        }
    }
}

