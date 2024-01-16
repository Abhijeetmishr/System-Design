package DSA.Heap;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class SumOfKElements {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt() , q = sc.nextInt();

        int[] arr = new int[n], queries = new int[q];
        for(int i = 0 ; i < n; i ++)
            arr[i] = sc.nextInt();
        for (int i = 0; i < q; i++)
            queries[i] = sc.nextInt();
        long[] result = specialArrayOperation(n, q, arr, queries);
        for(int i = 0 ; i < result.length; i++)
            System.out.println(result[i]);
        sc.close();
    }

    static long[] specialArrayOperation(int n, int q, int[] arr, int[] queries) {
        ArrayList<Integer> res = new ArrayList<>();
        ArrayList<Integer> list = new ArrayList<>();

        for(int i = 0; i < n; i++){
            list.add(arr[i]);
        }
        while(q-- > 0) {
            Collections.sort(list);
            int ele = list.remove(n-1) - list.remove(0);
            list.add(ele);
            res.add(list.stream().mapToInt(Integer::intValue).sum());
        }
        long[] array = new long[res.size()];
        for(int i = 0; i < res.size(); i++){
            array[i] = res.get(i).intValue();
        }
        return array;
    }
}
