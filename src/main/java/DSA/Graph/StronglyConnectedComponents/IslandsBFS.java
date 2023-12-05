package DSA.Graph.StronglyConnectedComponents;

import java.util.LinkedList;
import java.util.Queue;
/*  
 *  Given an m x n 2D binary grid grid which represents a map of '1's (land) and '0's (water),
    return the number of islands.

    An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically.
    You may assume all four edges of the grid are all surrounded by water.
 */
public class IslandsBFS {
    int row;
    int col;
    public int numIslands(char[][] grid){
        this.row = grid.length;
        this.col = grid[0].length;
        boolean[][] visited = new boolean[row][col];
        int res = 0;

        for(int i = 0; i < row; i++){
            for(int j = 0; j < col; j++){
                if(grid[i][j] == '1' && !visited[i][j]){
                    bfs(grid, visited, i, j);
                    res++;
                }
            }
        }
        return res;
    }

    public void bfs(char[][] grid, boolean[][] visited, int i, int j){
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(i, j));
        visited[i][j] = true;

        int dx[] = {0, 0, -1, 1};
        int dy[] = {1, -1, 0, 0};

        while(!q.isEmpty()){
            Pair p = q.poll();
            for(int k = 0; k < 4; k++){
                if(isSafe(grid, p.x + dx[k], p.y + dy[k], visited)){
                    visited[p.x + dx[k]][p.y + dy[k]] = true;
                    q.add(new Pair(p.x + dx[k], p.y + dy[k]));
                }
            }
        }
    }

    public boolean isSafe(char[][] mat, int i, int j, boolean vis[][]) {
        return (i >= 0) && (i < row) &&
            (j >= 0) && (j < col) &&
            (mat[i][j]=='1' && !vis[i][j]);
    }

    private class Pair{
        int x;
        int y;
        Pair(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
}
