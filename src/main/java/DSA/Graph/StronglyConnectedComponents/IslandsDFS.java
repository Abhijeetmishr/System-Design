package DSA.Graph.StronglyConnectedComponents;

public class IslandsDFS {
     // Function to find the number of islands.
     public int numIslands(char[][] grid) {
        // Code here
        if(grid == null || grid.length == 0) {
            return 0;
        }
     
        int numIslands = 0;
        for(int i = 0; i < grid.length; i++) {
            for(int j = 0; j < grid[i].length; j++) {
                if(grid[i][j] == '1') {
                    numIslands += DFS(grid, i, j);
                }
            }
        }
       return numIslands;
    }
    public int DFS(char[][] grid, int i, int j) {
        if(i < 0 || i >= grid.length || j < 0 || j >= grid[i].length ||
            grid[i][j] == '0') {
             
            return 0;    
        }
        grid[i][j] = '0';
        DFS(grid, i+1, j);
        DFS(grid, i-1, j);
        DFS(grid, i, j+1);
        DFS(grid, i, j-1);
        return 1;
    }
}
