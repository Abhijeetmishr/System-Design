package DSA.Graph.DFS;

import java.util.ArrayList;
import java.util.Scanner;

/*
 * Given a non-empty 2D array grid of 0s and 1s,
 * an island is a group of 1s (representing land) connected 4-directionally (horizontal or vertical). You may assume all four edges of the grid are surrounded by water.
 * Find the maximum area of an island in the given 2D array (If there is no island, the maximum area is 0).
 * 
 */
public class MaxAreaOfIsland {
    public static int maxAreaOfIsland(ArrayList<ArrayList<Integer> > matrix){
        int[][] grid = new int[matrix.size()][];
        for (int i = 0; i < matrix.size(); i++) {
            grid[i] = new int[matrix.get(i).size()];
            for (int j = 0; j < matrix.get(i).size(); j++) {
                grid[i][j] = matrix.get(i).get(j);
            }
        }

        int numOfIslands = 0;
        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[i].length; j++){
                if(grid[i][j] == 1){
                    numOfIslands = Math.max(numOfIslands, dfs(i, j, grid));
                }
            }
        }
        return numOfIslands;
    }

    public static int dfs(int i, int j, int[][] grid){
        if(i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || grid[i][j] == 0){
            return 0;
        }

        grid[i][j] = 0;
        int count = 1;
        count += dfs(i+1, j, grid);
        count += dfs(i-1, j, grid);
        count += dfs(i, j+1, grid);
        count += dfs(i, j-1, grid);
        return count;
    }

    public static void main(String[] args){
        
        Scanner sc = new Scanner(System.in);
        int n,m;

        n = sc.nextInt();
        m = sc.nextInt();
        
        ArrayList<ArrayList<Integer> > a = new ArrayList<ArrayList<Integer> >();
        for(int i=0;i<n;i++){
            ArrayList<Integer> b = new ArrayList<>();

            for(int j = 0;j<m;j++){
                b.add(sc.nextInt());
            }
            a.add(b);
        }

        int ans = MaxAreaOfIsland.maxAreaOfIsland(a);
        System.out.println(ans);
    }   
}
