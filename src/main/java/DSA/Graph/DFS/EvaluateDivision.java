package DSA.Graph.DFS;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class EvaluateDivision {
    Map<String, Map<String, Double>> graph;
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        buildGraph(equations, values);
        double[] res = new double[queries.size()];
        for(int i = 0; i < queries.size(); i++){
            List<String> query = queries.get(i);
            String src = query.get(0);
            String dest = query.get(1);
            res[i] = DFS(src, dest, new HashMap<>());
        }

        return res;
    }

    public double DFS(String src, String dest, Map<String, Boolean> visited){
        if(!graph.containsKey(src) || !graph.containsKey(dest)){
            return -1.0;
        }
        if(src.equals(dest)){
            return 1.0;
        }

        visited.put(src, true);
        Map<String, Double> neighbors = graph.get(src);

        for(Map.Entry<String, Double> neighbor: neighbors.entrySet()){
            String next = neighbor.getKey();
            double value = neighbor.getValue();

            if(!visited.containsKey(next)){
                double result = DFS(next, dest, visited);

                if (result != -1.0)
                    return value * result;
            }
        }
        return -1.0;
    }

    public void buildGraph(List<List<String>> equations, double[] values) {
        this.graph = new HashMap<>();
        int i = 0;
        for(List<String> equation: equations) {
            String src = equation.get(0);
            String dest = equation.get(1);
            graph.putIfAbsent(src, new HashMap<>());
            graph.putIfAbsent(dest, new HashMap<>());
            graph.get(src).put(dest, values[i]);
            graph.get(dest).put(src, 1.0/values[i]);
            i++;
        }
        return;
    }

    public static void main(String[] args) {
        EvaluateDivision evaluate = new EvaluateDivision();
        
        List<List<String>> equations = new ArrayList<>();
        equations.add(Arrays.asList("a", "b"));
        equations.add(Arrays.asList("b", "c"));

        List<List<String>> queries = new ArrayList<>();
        queries.add(Arrays.asList("a", "c"));
        queries.add(Arrays.asList("b", "a"));
        queries.add(Arrays.asList("a", "e"));
        queries.add(Arrays.asList("a", "a"));
        queries.add(Arrays.asList("x", "x"));

        double[] values = {2.0, 3.0};
        
        double[] res = evaluate.calcEquation(equations, values, queries);
        
        for(double ans: res){
            System.out.print(ans + " ");
        }
        
    }
}
