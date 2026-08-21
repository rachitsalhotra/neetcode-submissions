class Solution {
    private static final int[][] directions = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    private static final int INF = 2147483647;
    public void islandsAndTreasure(int[][] grid) {
        Queue<int[]> q = new LinkedList<>();
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 0) {
                    q.add(new int[] {i, j});
                }
            }
        }
        int res = 0;
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                int[] curr = q.poll();
                int nr = curr[0];
                int nc = curr[1];
                for (int[] dir: directions) {
                    if (nr + dir[0] >= 0 && nc + dir[1] >= 0 && nr + dir[0] < grid.length && nc + dir[1] < grid[0].length && grid[nr + dir[0]][nc + dir[1]] == INF) {
                        grid[nr + dir[0]][nc + dir[1]] = 1 + res;
                        q.add(new int[] {nr + dir[0], nc + dir[1]});
                    }
                }
                
            }
            res++;
        }
    }
}
