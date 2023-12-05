package DSA.Graph.TopologicalSort;
import java.util.*;

public class AlienDictionary {
    public String findOrder(String [] dict, int N, int K)
    {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        
        for(int i = 0; i < K; i++){
            adj.add(new ArrayList<>());
        }
        for(int i = 0; i < N-1; i++){
            String s1 = dict[i];
            String s2 = dict[i+1];
            
            int len = Math.min(s1.length(), s2.length());
            
            for(int ptr = 0; ptr < len; ptr++){
                if(s1.charAt(ptr) != s2.charAt(ptr)){
                    adj.get(s1.charAt(ptr) - 'a').add(s2.charAt(ptr) - 'a');
                    break;
                }
            }
        }
        
        int[] sort = topoSort(K, adj);
        String ans = "";
        for(int x: sort){
            ans += (char)(x + (int)'a');
        }
        return ans;
    }
    
    private int[] topoSort(int V, ArrayList<ArrayList<Integer>> adj) 
    {
        // add your code here
        int degree[] = new int[V];
        Arrays.fill(degree, 0);
        for(int i = 0; i < adj.size(); i++) {
            for(int j = 0; j < adj.get(i).size(); j++) {
                degree[adj.get(i).get(j)] = degree[adj.get(i).get(j)] + 1;
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
