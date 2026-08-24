class Solution {
    private boolean[] visited;
    private int visitedNodes = 0;
    private boolean dfs(List<List<Integer>> adjList, int node, int prevNode) {
        if (visited[node]) {
            return false;
        }
        visited[node] = true;
        visitedNodes++;
        List<Integer> nei = adjList.get(node);
        for (int i = 0; i < nei.size(); i++) {
            if (nei.get(i) != prevNode && !dfs(adjList, nei.get(i), node)) {
                return false;
            }
        }
        return true;
    }
    public boolean validTree(int n, int[][] edges) {
        visited = new boolean[n];
        List<List<Integer>> adjList = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adjList.add(new ArrayList<>());
        }
        for (int i = 0; i < edges.length; i++) {
            adjList.get(edges[i][0]).add(edges[i][1]);
            adjList.get(edges[i][1]).add(edges[i][0]);
        }
        if (!dfs(adjList, 0, -1) || visitedNodes != n) {
            return false;
        }
        return true;
    }
}
