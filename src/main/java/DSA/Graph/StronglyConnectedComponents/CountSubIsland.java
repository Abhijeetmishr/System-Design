package DSA.Graph.StronglyConnectedComponents;
/** Leetcode - 1905
 *  You are given two m x n binary matrices grid1 and grid2 containing only 0's (representing water) and 1's (representing land). An island is a group of 1's connected 4-directionally (horizontal or vertical). Any cells outside of the grid are considered water cells.

    An island in grid2 is considered a sub-island if there is an island in grid1 that contains all the cells that make up this island in grid2.

    Return the number of islands in grid2 that are considered sub-islands.
 */
public class CountSubIsland {
    int ans = 0;
    public int countSubIslands(int[][] grid1, int[][] grid2) {
        if(grid2 == null || grid2.length == 0) {
            return 0;
        }
     
        int numIslands = 0;
        for(int i = 0; i < grid1.length; i++) {
            for(int j = 0; j < grid2[i].length; j++) {
                if(grid2[i][j] == 1) {
                    ans = 1;
                    DFS(grid2, i, j, grid1);
                    numIslands += ans;
                }
            }
        }
       return numIslands;
    }
    public void DFS(int[][] grid2, int i, int j, int[][] grid1) {
        if(i < 0 || i >= grid2.length || j < 0 || j >= grid2[i].length ||
            grid2[i][j] == 0) {
            return;    
        }
        if(grid1[i][j] == 0) ans =  0;
        grid2[i][j] = 0;
        DFS(grid2, i+1, j, grid1);
        DFS(grid2, i-1, j, grid1);
        DFS(grid2, i, j+1, grid1);
        DFS(grid2, i, j-1, grid1);
    }
}
