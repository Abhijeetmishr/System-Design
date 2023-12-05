package DSA.Graph.BFS;

import java.util.ArrayDeque;
import java.util.Queue;

class CaptureRegions {
    int m, n;
    public void solve(char[][] board) {
        if (board == null || board.length == 0 || board[0].length == 0) return;

        m = board.length; n = board[0].length;
        Queue<Point> queue = new ArrayDeque<>();

        // Step 1: Get all 'O' on edges first
        for (int i = 0; i < m; i++) {
            bfs(board, i,   0, queue); // first row
            bfs(board, i, n-1, queue); // last row
        }
        for (int j = 0; j < n; j++) {
            bfs(board,   0, j, queue); // first col
            bfs(board, m-1, j, queue); // last col
        } 

        // Step 3: Put all '+' to 'O' and 'O' to 'X'
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 'O') board[i][j] = 'X';
                if (board[i][j] == '+') board[i][j] = 'O';
            }
        }
    }
    
    // Step 2: BFS for 'O' and put them to '+'
    public void bfs(char[][] board, int i, int j, Queue<Point> queue) {
        int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        if (board[i][j] == 'O') {
            board[i][j] = '+';
            queue.add(new Point(i, j));
        }
        while (!queue.isEmpty()) {
            Point p = queue.poll();
    
            for (int[] dir : directions) {
                int nx = p.x + dir[0];
                int ny = p.y + dir[1];

                if (nx >= 0 && nx < m && ny >= 0 && ny < n && board[nx][ny] == 'O') {
                    queue.offer(new Point(nx, ny));
                    board[nx][ny] = '+';
                }
            }
        }
    }

    private static class Point {
        int x, y;
        Point(int x, int y) { this.x = x; this.y = y; }
    }
}
