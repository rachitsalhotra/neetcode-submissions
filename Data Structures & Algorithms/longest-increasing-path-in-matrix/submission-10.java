class Solution {
    private int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    private int[][] mem;
    private int dfs(int[][] matrix, int i, int j) {
        if (mem[i][j] != -1) {
            return mem[i][j];
        }
        int max = 1;
        for (int[] dir: directions) {
            int ni = i + dir[0];
            int nj = j + dir[1];
            if (ni < 0 || nj < 0 || ni >= matrix.length || nj >= matrix[0].length || matrix[ni][nj] <= matrix[i][j]) {
                continue;
            }
            max = Math.max(max, 1 + dfs(matrix, ni, nj));
        }
        mem[i][j] = max;
        return max;
    }
    public int longestIncreasingPath(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        mem = new int[m][n];
        for (int[] row: mem) {
            Arrays.fill(row, -1);
        }
        int max = 1;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                max = Math.max(max, dfs(matrix, i, j));
            }
        }
        return max;
    }
}
