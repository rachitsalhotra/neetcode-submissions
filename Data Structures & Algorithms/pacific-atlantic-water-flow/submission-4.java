class Solution {
    private static final int[][] directions = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
    private void dfs(int[][] heights, int r, int c, boolean[][] ocean) {
        ocean[r][c] = true;
        for (int[] dir: directions) {
            int nr = r + dir[0];
            int nc = c + dir[1];
            if (nr >= 0 && nc >= 0 && nr < heights.length && nc < heights[0].length && heights[nr][nc] >= heights[r][c] && !ocean[nr][nc]) {
                dfs(heights, nr, nc, ocean);
            }
        }
    }
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        int m = heights.length;
        int n = heights[0].length;
        boolean[][] pac = new boolean[m][n];
        boolean[][] atl = new boolean[m][n];

        for (int i = 0; i < m; i++) {
            dfs(heights, i, 0, pac);
            dfs(heights, i, n - 1, atl);
        }

        for (int i = 0; i < n; i++) {
            dfs(heights, 0, i, pac);
            dfs(heights, m - 1, i, atl);
        }

        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (pac[i][j] && atl[i][j]) {
                    res.add(Arrays.asList(i, j));
                }
            }
        }
        return res;
    }
}
