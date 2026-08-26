class Solution {
    private static final int[][] directions = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    private void dfs(int r, int c, int[][] grid) {
        grid[r][c] = 2;
        for (int[] dir: directions) {
            int nr = r + dir[0];
            int nc = c + dir[1];

            if (nr >= 0 && nc >= 0 && nr < grid.length && nc < grid[0].length && grid[nr][nc] == 1) {
                dfs(nr, nc, grid);
            }
        }
    }
    public int shortestBridge(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        boolean flag = false;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    dfs(i, j, grid);
                    flag = true;
                    break;
                }
            }
            if (flag) {
                break;
            }
        }
        Queue<int[]> q = new LinkedList<>();
        boolean[][] visited = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 2) {
                    q.add(new int[] {i, j, 0});
                    visited[i][j] = true;
                }
            }
        }
        int min = Integer.MAX_VALUE;
        while(!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                int[] node = q.poll();
                for (int[] dir: directions) {
                    int r = node[0] + dir[0];
                    int c = node[1] + dir[1];
                    if (r >= 0 && c >= 0 && r < grid.length && c < grid[0].length && !visited[r][c] && grid[r][c] != 2) {
                        if (grid[r][c] == 1) {
                            min = Math.min(min, node[2]);
                            continue;
                        }
                        visited[r][c] = true;
                        q.add(new int[] {r, c, node[2] + 1});
                    }
                }
            }
        }

        return min;
    }
}