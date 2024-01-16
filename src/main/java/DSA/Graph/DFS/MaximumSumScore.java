package DSA.Graph.DFS;

import java.util.ArrayList;
import java.util.List;

/*
 * https://leetcode.com/problems/maximum-score-after-applying-operations-on-a-tree/submissions/1128024739
 */
public class MaximumSumScore {
    public long maximumScoreAfterOperations(int[][] edges, int[] values) {
        int n = edges.length + 1;
        boolean[] visited = new boolean[n];
        List<List<Integer>> adjList = new ArrayList();

        for(int i = 0; i < n; i++){
            adjList.add(new ArrayList<>());
        }

        for(int[] edge: edges){
            adjList.get(edge[0]).add(edge[1]);
            adjList.get(edge[1]).add(edge[0]);
        }
        
        long[] pair = dfs(adjList, 0, values, visited);

        return (long)(pair[0] - pair[1]);
    }

    public long[] dfs(List<List<Integer>> adjList, int src, int[] values, boolean[] visited) {
        visited[src] = true;
        long[] pair = new long[]{values[src], values[src]};
        long childSum = 0;

        for(int adj: adjList.get(src)){
            if(!visited[adj]) {
                long[] p = dfs(adjList, adj, values, visited);
                pair[0] += p[0];
                childSum += p[1];
            }
        }

        if(childSum != 0){
            pair[1] = Math.min(pair[1], childSum);
        }
        return pair;
    }
}
