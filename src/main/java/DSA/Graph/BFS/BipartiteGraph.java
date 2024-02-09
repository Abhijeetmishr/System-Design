package DSA.Graph.BFS;
import java.util.*;

/*
 * Given a set of N Countries which are numbered from 1 to N, split the Countries into two groups, of any size, such that the following condition is met.

If a Country dislikes another Country, they should not be in the same group. If dislikes[i] = [a, b], we should not put Country numbered a and Country numbered b into the same group.
 */
public class BipartiteGraph {
    private static String possibleBipartition(int n, Vector<Vector<Integer> > edges) {
		ArrayList<ArrayList<Integer>> adjList = new ArrayList<>();
		int[] color = new int[10005];
		Arrays.fill(color, 0);
		for(int i = 0; i <= n; i++){
			adjList.add(new ArrayList<>());
		}

		for(Vector<Integer> edge : edges){
			int u = edge.get(0);
			int v = edge.get(1);
			adjList.get(u).add(v);
			adjList.get(v).add(u);
		}

		Queue<int[]> queue = new LinkedList<>();
		queue.add(new int[]{1, 1});

		while(!queue.isEmpty()){
			int[] arr = queue.poll();
			int curr = arr[0];
			color[curr] = arr[1];

			for(int u : adjList.get(curr)){
				if(color[u] != 1){
					queue.add(new int[]{u, 3-color[curr]});
				} else if(color[u] != 3 - color[curr]){
					return "Not Possible";
				}
			}
		}
		return "Possible";
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		for (int tests = 0; tests < t; tests++) {
			int n = sc.nextInt();
			int m = sc.nextInt();

			Vector<Vector<Integer> > edges = new Vector<Vector<Integer> >();
			for (int i = 0; i < m; i++) {
				int u = sc.nextInt();
				int v = sc.nextInt();
				Vector<Integer> edge = new Vector<Integer>();
				edge.add(u);
				edge.add(v);
				edges.add(edge);
			}
			System.out.println(possibleBipartition(n, edges));
		}
		sc.close();
	}
}
