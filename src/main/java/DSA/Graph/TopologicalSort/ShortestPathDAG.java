package DSA.Graph.TopologicalSort;
import java.util.*;

class Node{
	int data;
	int weight;
	Node(int data,int weight){
		this.data=data;
		this.weight=weight;
	}
}
class ShortestPathDAG {
    public void topoSortUtil(ArrayList<ArrayList<Node>> list,int[]arr) {
		int[]inDegree=new int[list.size()];
		for(int i=0;i<list.size();i++) {
			for(int j=0;j<list.get(i).size();j++) {
				int node=list.get(i).get(j).data;
				inDegree[node]++;
			}
		}
		Queue<Integer> q=new LinkedList<Integer>();
		for(int i=0;i<list.size();i++) {
			if(inDegree[i]==0) {
				q.add(i);
			}
		}
		int k=0;
		while(!q.isEmpty()) {
			int source=q.poll();
			arr[k++]=source;
			for(int i=0;i<list.get(source).size();i++) {
				int node=list.get(source).get(i).data;
				if(--inDegree[node]==0) {
					q.add(node);
				}
			}
		}
	}

	public int[] shortestPath(int N,int M, int[][] edges) {
		//Code here
		ArrayList<ArrayList<Node>> list=new ArrayList<ArrayList<Node>>(N);
		for(int i=0;i<N;i++) {
			list.add(new ArrayList<Node>());
		}
		for(int i=0;i<edges.length;i++){
		    int source=edges[i][0];
		    int destination=edges[i][1];
		    int weight=edges[i][2];
		    list.get(source).add(new Node(destination,weight));
		}
		int[]ans=new int[list.size()];
		int[]dist=new int[list.size()];
		int s=0                                                                                                                             ;
		for(int i=0;i<dist.length;i++) {
			dist[i]=Integer.MAX_VALUE;
		}
		dist[s]=0;
		topoSortUtil(list,ans);
		for(int i=0;i<ans.length;i++) {
			int source=ans[i];
			if(source>=s) {
				for(int j=0;j<list.get(source).size();j++) {
					int node=list.get(source).get(j).data;
					int w=list.get(source).get(j).weight;
					if(dist[source]!=Integer.MAX_VALUE&&dist[node]>dist[source]+w) {
						dist[node]=dist[source]+w;
					}
				}
			}
		}
		for(int i=0;i<dist.length;i++){
		    if(dist[i]==Integer.MAX_VALUE){
		        dist[i]=-1;
		    }
		}
		return dist;
	}
}