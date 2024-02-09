package DSA.Graph.DFS;
import java.util.*;

/*
 * Problem Description
    Given an undirected graph, you have to find the number of connected components in that graph.
 */
public class ConnectedComponentsInGraph {

    public Map<Integer,Set<Integer>> buildGraph(ArrayList<ArrayList<Integer>> edges){
        Map<Integer,Set<Integer>> graph = new HashMap<>();

        for(ArrayList<Integer> edge: edges){
            int u = edge.get(0);
            int v = edge.get(1);
            if(!graph.containsKey(u)){
                graph.put(u, new HashSet<>());
            }
            graph.get(u).add(v);
            if(!graph.containsKey(v)){
                graph.put(v, new HashSet<>());
            }
            graph.get(v).add(u);
        }

        return graph;
    }
    int connectedComponentsInGraph(int n,  ArrayList<ArrayList<Integer>> edges) {
        Map<Integer,Set<Integer>> graph = buildGraph(edges);
        
        HashSet<Integer> visited = new HashSet<>();

        int connectedComponentsCount = 0;

        for(int i = 1; i <= n; i++){
            if(visited.contains(i)){
                continue;
            }
            dfs(i, visited, graph);
            ++connectedComponentsCount;
        }
        return connectedComponentsCount;
    }

    public void dfs(int src,  HashSet<Integer> visited,  Map<Integer,Set<Integer>> graph){
        if(visited.contains(src)){
            return;
        }

        visited.add(src);
        if(!graph.containsKey(src)){
            return;
        }

        for(int neighbour: graph.get(src)){
           dfs(neighbour, visited, graph);
        }
        
        return;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        ArrayList<ArrayList<Integer>> edges = new ArrayList<ArrayList<Integer>>();
    
        for(int i = 0;i < m; i++) {
            edges.add(new ArrayList<Integer>());
            edges.get(i).add(scanner.nextInt());
            edges.get(i).add(scanner.nextInt());
        }
        ConnectedComponentsInGraph answer = new ConnectedComponentsInGraph();
        int result = answer.connectedComponentsInGraph(n, edges);
        System.out.println(result);
        scanner.close();
    }
}
