package DSA.Graph.DFS;

import java.util.ArrayList;
/**
    Problem Description

    Given an directed graph having A nodes labelled from 1 to A containing M edges given by matrix B of size M x 2such that there is a edge directed from node

    B[i][0] to node B[i][1].

    Find whether a path exists from node 1 to node A.

    Return 1 if path exists else return 0.

    NOTE:

    There are no self-loops in the graph.
    There are no multiple edges between two nodes.
    The graph may or may not be connected.
    Nodes are numbered from 1 to A.
    Your solution will run on multiple test cases. If you are using global variables make sure to clear them.

 */
public class Path {
    //It can be solved using BFS also
    /*Path in Directed Graph*/
    public int solve(int A, ArrayList<ArrayList<Integer>> B) {
        ArrayList<Integer> []adjlist = new ArrayList[A+1];
        for(int i =1 ;i<=A;++i)adjlist[i] = new ArrayList<Integer>();
        for(ArrayList<Integer> i : B){
            int a  = i.get(0);
            int b =  i.get(1);
            adjlist[a].add(b);
        }
        int []visited = new int[A+1];
        boolean flag = dfs(1,adjlist,visited,A);
        return (flag)?1:0;
    }
    public boolean dfs(int curr,ArrayList<Integer> []adjlist,int []visited,int dst){
        if(curr==dst)return true;
        visited[curr] = 1;
        for(int i : adjlist[curr]){
            if(visited[i]==0){
                if(dfs(i,adjlist,visited,dst))return true;
            }
        }
        return false;
    }
}


