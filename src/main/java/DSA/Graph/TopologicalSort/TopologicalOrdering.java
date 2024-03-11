package DSA.Graph.TopologicalSort;

import java.util.*;

class TopologicalOrdering{
	private static Vector<Integer> topologicalOrdering(int n,Vector<Vector<Integer> > edges){
		Vector<Integer> result = new Vector<>();
		if(n <= 0) return result;

		HashMap<Integer, Integer> in_degree = new HashMap<>();
		HashMap<Integer, List<Integer>> adj_list = new HashMap<>();
		//Ignore 0 because index is starting from 1
		in_degree.put(0, Integer.MAX_VALUE);
		for(int i = 1; i <= n; i++){
			in_degree.put(i , 0);
			adj_list.put(i, new ArrayList<>());
		}
		for(int i = 0; i < edges.size(); i++){
			int node = edges.get(i).get(0);
			int neighbour = edges.get(i).get(1);

			in_degree.put(neighbour, in_degree.get(neighbour) + 1);
			adj_list.get(node).add(neighbour);
		}

		Queue<Integer> queue = new LinkedList<>();
		
		in_degree.forEach((key, value) ->{
			if(value == 0){
				queue.add(key);
			}
		});

		while(!queue.isEmpty()){
			int vertex = queue.poll();
			result.add(vertex);
			for(int neighbour: adj_list.get(vertex)){
				in_degree.put(neighbour, in_degree.get(neighbour) - 1);

				if(in_degree.get(neighbour) == 0) queue.add(neighbour);
			}
		}

		if(result.size() != n) return new Vector<>();

		return result;
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int e = sc.nextInt();
		Vector<Vector<Integer> > edges = new Vector<Vector<Integer> >();
		for(int i=0;i<e;i++)
		{
			int u=sc.nextInt();
			int v=sc.nextInt();
			Vector<Integer> edge = new Vector<Integer>();
			edge.add(u);
			edge.add(v);
			edges.add(edge);
		}
		Vector<Integer> answer = topologicalOrdering(n,edges);
		for(int elem : answer)
			System.out.print(elem+" ");
	}
}
