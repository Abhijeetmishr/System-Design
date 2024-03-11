package DSA.Graph.TopologicalSort;
import java.util.*;

public class KahnsAlgo {
    public int[] topoSort(int V, ArrayList<ArrayList<Integer>> adj) {
        int[] degree = new int[V];
        Arrays.fill(degree, 0);
        for(int i = 0; i < adj.size(); i++){
            for(int j = 0; j < adj.get(i).size(); i++){
                int v = adj.get(i).get(j);
                degree[v]++;
            }
        }
        Queue<Integer> q = new LinkedList<>();
        for(int i = 0; i < degree.length; i++) {
            if(degree[i] == 0) {
                q.add(i);
            }
        }
        int cnt = 0;
        int[] ans = new int[V];
        while(!q.isEmpty()) {
            int curr = q.remove();
            ans[cnt] = curr;
            cnt++;
            for(int u : adj.get(curr)) {
                degree[u] = degree[u] - 1;
                
                if(degree[u] == 0) {
                    q.add(u);
                }
            }
        }
        return ans;
    }
}
