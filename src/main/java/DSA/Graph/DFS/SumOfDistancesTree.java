package DSA.Graph.DFS;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * https://leetcode.com/problems/sum-of-distances-in-tree/solutions/885637/java-solution-code-photo-explaination
    There is an undirected connected tree with n nodes labeled from 0 to n - 1 and n - 1 edges.
    You are given the integer n and the array edges where edges[i] = [ai, bi] indicates that there is an edge between nodes ai and bi in the tree.
    Return an array answer of length n where answer[i] is the sum of the distances between the ith node in the tree and all other nodes.

    

    Example 1:
    Input: n = 6, edges = [[0,1],[0,2],[2,3],[2,4],[2,5]]
    Output: [8,12,6,10,10,10]
    Explanation: The tree is shown above.
    We can see that dist(0,1) + dist(0,2) + dist(0,3) + dist(0,4) + dist(0,5)
    equals 1 + 1 + 2 + 2 + 2 = 8.
    Hence, answer[0] = 8, and so on.
 */
public class SumOfDistancesTree {
    private Map<Integer, List<Integer>> tree;
    private int[] ans;
    private int[] subTreeSum;
    public int[] sumOfDistancesInTree(int n, int[][] edges) {
        this.tree = new HashMap<>();
        this.ans = new int[n];
        this.subTreeSum = new int[n];

        //create a tree representation
        for(int i = 0; i < n; i++){
            tree.put(i, new ArrayList<>());
        }
        //populate the tree with edges
        for(int[] edge: edges){
            tree.get(edge[0]).add(edge[1]);
            tree.get(edge[1]).add(edge[0]);
        }
        // Perform DFS starting from the root (node 0)
        dfs1(0, -1);

        // Calculate answers for all nodes based on the root node
        calculateAns(0, -1, n);

        return ans;
    }

    private void dfs1(int node, int parent){
        subTreeSum[node] = 1;

        for(int child : tree.get(node)){
            if(child == parent) continue;
            dfs1(child, node);
            subTreeSum[node] += subTreeSum[child];
            ans[node] += ans[child] + subTreeSum[child];
        }
    }

    private void calculateAns(int node, int parent, int n) {
        for(int child: tree.get(node)){
            if(child == parent) continue;
            ans[child] = ans[node] + (n - subTreeSum[child]) - subTreeSum[child];
            calculateAns(child, node, n);
        }
    }
}
