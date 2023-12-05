package DSA.Graph.ShortestPath;
import java.util.*;

public class ShortestPathUnweighted {
    static void addEdge(ArrayList<ArrayList<Integer>> adj, int u, int v) 
	{ 
		adj.get(u).add(v); 
		adj.get(v).add(u); 
	} 
    public static int[] minPath(ArrayList<ArrayList<Integer>> adj, int V, int s){
        boolean[] visited = new boolean[V];
        int[] dist = new int[V];
        Arrays.fill(dist, Integer.MAX_VALUE-1);
        dist[0] = 0;
        Queue<Integer> q = new LinkedList<>();
        visited[s] = true;
        q.add(s);

        while(!q.isEmpty()){
            int u = q.poll();
            for(int v : adj.get(u)){
                if(visited[v] == false){
                    dist[v] = dist[u] + 1;
                    visited[v] = true;
                    q.add(v);
                }
            }
        }
        return dist;
    }
    public static void main(String[] args) 
	{  
		int V = 4; 
		ArrayList<ArrayList<Integer> > adj = new ArrayList<ArrayList<Integer>>(V); 
		
		for (int i = 0; i < V; i++) 
			adj.add(new ArrayList<Integer>()); 

		addEdge(adj,0,1); 
    	addEdge(adj,1,2); 
    	addEdge(adj,2,3); 
    	addEdge(adj,0,2); 
    	addEdge(adj,1,3);
        
    	int[] dist = minPath(adj,V,0); 
        
        for(int i=0;i<V;i++){
            System.out.print(dist[i]+" ");
        }
	} 
}
