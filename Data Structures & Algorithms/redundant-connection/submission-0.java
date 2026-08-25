class Solution {
    private boolean[] visited;
    private HashSet<String> set = new HashSet<>();
    private boolean flag = false;
    private int vertex = -1;
    private void dfs(List<List<Integer>> adjList, int node, int parent) {
        if (set.size() > 0) {
            return;
        }
        if (visited[node]) {
            flag = true;
            vertex = node;
            set.add((Math.min(node + 1, parent + 1)) + "#" + (Math.max(node + 1, parent + 1)));
            return;
        }
        visited[node] = true;
        List<Integer> neighbours = adjList.get(node);
        for (int nei: neighbours) {
            if (nei == parent) {
                continue;
            }
            dfs(adjList, nei, node);
        }

        if (flag && vertex == node) {
            flag = false;
        }
        if (flag) {
            set.add((Math.min(node + 1, parent + 1)) + "#" + (Math.max(node + 1, parent + 1)));
        }
    }
    public int[] findRedundantConnection(int[][] edges) {
        List<List<Integer>> adjList = new ArrayList<>();
        int n = 1;
        for (int i = 0; i < edges.length; i++) {
            n = Math.max(n, edges[i][1]);
        }
        visited = new boolean[n + 1];
        for (int i = 0; i < n; i++) {
            adjList.add(new ArrayList<>());
        }
        for (int i = 0; i < n; i++) {
            adjList.get(edges[i][0] - 1).add(edges[i][1] - 1);
            adjList.get(edges[i][1] - 1).add(edges[i][0] - 1);
        }
        dfs(adjList, 0, -1);
        System.out.println(set);
        for (int i = edges.length - 1; i >= 0; i--) {
            if (set.contains(edges[i][0] + "#" + edges[i][1])) {
                return new int[] {edges[i][0], edges[i][1]};
            }
        }
        return new int[0];
    }
}
