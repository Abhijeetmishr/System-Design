package DSA.Graph.StronglyConnectedComponents;

import java.util.ArrayList;
/* Leetcode
    https://leetcode.com/problems/find-all-groups-of-farmland/description/
 */
public class FarmLand {
    int r2 = 0, c2 = 0;
    public int[][] findFarmland(int[][] grid) {
        ArrayList<int[]> list = new ArrayList<>();
        for(int i = 0; i < grid.length; i++) {
            for(int j = 0; j < grid[i].length; j++) {
                if(grid[i][j] == 1) {
                    DFS(grid, i, j);
                    list.add(new int[]{i, j, r2, c2});
                    r2 = 0; c2 = 0;
                }
            }
        }
        int arr[][] = new int[list.size()][4];
        for(int i = 0; i<arr.length; i++)arr[i] = list.get(i);
        return arr;
    }
    public void DFS(int[][] grid, int i, int j) {
        if(i < 0 || i >= grid.length || j < 0 || j >= grid[i].length ||
            grid[i][j] == 0) {
            return;    
        }
        grid[i][j] = 0;
        DFS(grid, i+1, j);
        DFS(grid, i-1, j);
        DFS(grid, i, j+1);
        DFS(grid, i, j-1);
        r2 = Math.max(r2, i);
        c2 = Math.max(c2, j);
    }
}
