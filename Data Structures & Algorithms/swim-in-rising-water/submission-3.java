class Solution {
    private int[][] directions = {{0, 1}, {1, 0}, {-1, 0}, {0, -1}};
    public int swimInWater(int[][] grid) {
        int n = grid.length;
        boolean[][] visited = new boolean[n][n];
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> Integer.compare(a[0], b[0]));
        pq.add(new int[] {grid[0][0], 0, 0});
        while(!pq.isEmpty()) {
            int[] node = pq.poll();
            int ht = node[0];
            int r = node[1];
            int c = node[2];
            if (r == n - 1 && c == n - 1) {
                return ht;
            }
            if (visited[r][c]) {
                continue;
            }
            visited[r][c] = true;
            for (int[] dir: directions) {
                int nr = r + dir[0];
                int nc = c + dir[1];
                if (nr < 0 || nc < 0 || nr >= n || nc >= n || visited[nr][nc]) {
                    continue;
                }
                pq.add(new int[] {Math.max(ht, grid[nr][nc]), nr, nc});
            }
        }
        return 0;
    }
}
