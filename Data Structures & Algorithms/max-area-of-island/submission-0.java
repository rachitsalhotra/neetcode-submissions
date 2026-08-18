class Solution {
    private static final int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    private void dfs(int[][] grid, int i, int j, int[] size) {
        if (i < 0 || j < 0 || i >= grid.length || j >= grid[0].length || grid[i][j] == 0) {
            return;
        }
        grid[i][j] = 0;
        size[0]++;
        for (int[] direction: directions) {
            dfs(grid, i + direction[0], j + direction[1], size);
        }
    }
    public int maxAreaOfIsland(int[][] grid) {
        int max = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                int[] size = new int[1];
                dfs(grid, i, j, size);
                max = Math.max(max, size[0]);
            }
        }
        return max;
    }
}
