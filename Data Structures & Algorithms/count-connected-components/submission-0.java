class Solution {
    private boolean[] visited;
    private void dfs(List<List<Integer>> adjList, int node, int prevNode) {
        if (visited[node]) {
            return;
        }
        visited[node] = true;
        List<Integer> nei = adjList.get(node);
        for (int i = 0; i < nei.size(); i++) {
            if (nei.get(i) != prevNode) {
                dfs(adjList, nei.get(i), node);
            }
        }
    }

    public int countComponents(int n, int[][] edges) {
        visited = new boolean[n];
        List<List<Integer>> adjList = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adjList.add(new ArrayList<>());
        }
        for (int i = 0; i < edges.length; i++) {
            adjList.get(edges[i][0]).add(edges[i][1]);
            adjList.get(edges[i][1]).add(edges[i][0]);
        }
        int res = 0;
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                dfs(adjList, i, -1);
                res++;
            }
        }
        return res;
    }
}
