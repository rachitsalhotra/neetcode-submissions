class Solution {
    private static final int[][] dirs = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    private boolean[][] visited;
    private void dfs(char[][] board, int r, int c, boolean[][] cantSurround) {
        if (board[r][c] == 'X') {
            return;
        }
        visited[r][c] = true;
        cantSurround[r][c] = true;
        for (int[] dir: dirs) {
            int nr = r + dir[0];
            int nc = c + dir[1];
            if (nr >= 0 && nc >= 0 && nr < board.length && nc < board[0].length && !visited[nr][nc] && board[nr][nc] != 'X') {
                dfs(board, nr, nc, cantSurround);
            }
        }
        visited[r][c] = false;
    }
    public void solve(char[][] board) {
        int m = board.length;
        int n = board[0].length;
        boolean[][] cantSurround = new boolean[m][n];
        visited = new boolean[m][n];
        
        for (int i = 0; i < m; i++) {
            dfs(board, i, 0, cantSurround);
            dfs(board, i, n - 1, cantSurround);
        }
        for (int i = 0; i < n; i++) {
            dfs(board, 0, i, cantSurround);
            dfs(board, m - 1, i, cantSurround);
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 'O' && !cantSurround[i][j]) {
                    board[i][j] = 'X';
                }
            }
        }
    }
}
