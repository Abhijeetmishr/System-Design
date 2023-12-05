package DSA.Graph.BFS;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;

/**
    Given an N x M matrix A of non-negative integers representing the height of each unit cell in a continent,
    the "Blue lake" touches the left and top edges of the matrix and the "Red lake" touches the right and bottom edges.
    Water can only flow in four directions (up, down, left, or right) from a cell to another one with height equal or lower.
    Find the number of cells from where water can flow to both the Blue and Red lake.
 
*/
public class WaterFlow {
    int m;
    int n;
    public int solve(ArrayList<ArrayList<Integer>> A) {
        this.m = A.size();
        this.n = A.get(0).size();
        int res = 0;
        int[][] grid = new int[m][n];

        for (int i = 0; i < m; i++) {
            ArrayList<Integer> rowList = A.get(i);
            for (int j = 0; j < n; j++) {
                grid[i][j] = rowList.get(j);
            }
        }
        boolean[][] visitedBlue = new boolean[m][n];
        boolean[][] visitedRed = new boolean[m][n];

        Queue<int[]> queue = new ArrayDeque<>();

        // BFS from Blue lake
        for (int i = 0; i < m; i++) {
            queue.offer(new int[]{i, 0});
            visitedBlue[i][0] = true;
        }
        for (int j = 0; j < n; j++) {
            queue.offer(new int[]{0, j});
            visitedBlue[0][j] = true;
        }
        bfs(grid, queue, visitedBlue);

        // BFS from Red lake
        for (int i = 0; i < m; i++) {
            queue.offer(new int[]{i, n - 1});
            visitedRed[i][n - 1] = true;
        }
        for (int j = 0; j < n; j++) {
            queue.offer(new int[]{m - 1, j});
            visitedRed[m - 1][j] = true;
        }
        bfs(grid, queue, visitedRed);

        // Count cells that can flow to both lakes
        int count = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (visitedBlue[i][j] && visitedRed[i][j]) {
                    count++;
                }
            }
        }

        return count;
    }

    private void bfs(int[][] A, Queue<int[]> queue, boolean[][] visited) {
        int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int x = current[0];
            int y = current[1];

            for (int[] dir : directions) {
                int nx = x + dir[0];
                int ny = y + dir[1];

                if (nx >= 0 && nx < m && ny >= 0 && ny < n && !visited[nx][ny] && A[nx][ny] >= A[x][y]) {
                    queue.offer(new int[]{nx, ny});
                    visited[nx][ny] = true;
                }
            }
        }
    }
}
