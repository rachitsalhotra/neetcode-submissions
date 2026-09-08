class Solution {
    private boolean[] visited;
    private void dfs(int[][] isConnected, int index) {
        if (visited[index]) {
            return;
        }
        visited[index] = true;
        for (int i = 0; i < isConnected.length; i++) {
            if (isConnected[index][i] == 1) {
                dfs(isConnected, i);
            }
        }
    }
    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        visited = new boolean[n];
        int res = 0;
        for (int i = 0; i < n; i++) {
            if (visited[i]) {
                continue;
            }
            visited[i] = true;
            res++;
            for (int j = i + 1; j < n; j++) {
                if (isConnected[i][j] == 1) {
                    dfs(isConnected, j);
                }
            }
        }
        return res;
    }
}