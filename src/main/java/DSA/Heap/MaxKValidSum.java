package DSA.Heap;
import java.util.*;
    
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
        int l;
        int m;
        public Pair(int l, int m){
            this.l = l;
            this.m = m;
        }
    }

    public static class PairSum implements Comparable<PairSum>{
        int l;
        int m;
        int sum;
        public PairSum(int l, int m, int sum){
            this.l = l;
            this.m = m;
            this.sum = sum;
        }
        @Override
        public int compareTo(PairSum other){
            return Integer.compare(other.sum, sum);
        }
    }
}

