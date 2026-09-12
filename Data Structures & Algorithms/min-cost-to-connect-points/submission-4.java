class Solution {
    public int minCostConnectPoints(int[][] points) {
        int n = points.length;
        List<List<int[]>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int dist = Math.abs(points[i][0] - points[j][0]) + Math.abs(points[i][1] - points[j][1]);
                adj.get(i).add(new int[] {dist, j});
                adj.get(j).add(new int[] {dist, i});
            }
        }
        boolean[] visited = new boolean[n];
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> Integer.compare(a[0], b[0]));
        pq.add(new int[] {0, 0});
        int cost = 0;
        while (!pq.isEmpty()) {
            int[] edge = pq.poll();
            int dist = edge[0];
            int node = edge[1];
            if (visited[node]) {
                continue;
            }
            visited[node] = true;
            cost += dist;
            for (int[] nei: adj.get(node)) {
                if (!visited[nei[1]]) {
                    pq.add(nei);
                }
            }
        }
        return cost;
    }
}
