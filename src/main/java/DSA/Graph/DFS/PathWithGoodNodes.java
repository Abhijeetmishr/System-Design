package DSA.Graph.DFS;

import java.util.ArrayList;
import java.util.List;

public class PathWithGoodNodes {
    int find(int root, int parent, List<Integer> adj[], ArrayList<Integer> A, int c, int count){
        int ans =0;
        count += A.get(root-1);
        if(adj[root].size()==1){
            return count <=c ? 1 : 0;
        }   
         
        for(int node : adj[root]){
            if(node != parent){
               ans += find(node, root, adj, A, c, count);
            }
        }
        return ans;
    }
    
    public int solve(ArrayList<Integer> A, ArrayList<ArrayList<Integer>> B, int c) {
        int n = A.size();
        
        @SuppressWarnings("unchecked")
        List<Integer>[] adj = new ArrayList[n+1];
        for(int i=0;i<n+1;i++){
            adj[i] = new ArrayList<>();
        }
        
        for(List<Integer> edge : B){
            adj[edge.get(0)].add(edge.get(1));
            adj[edge.get(1)].add(edge.get(0));
        }
        return find(1,0, adj, A,c, 0);
    }
}
