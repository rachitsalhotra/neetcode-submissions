class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        List<List<int[]>> adj = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            adj.add(new ArrayList<>());
        }
        for (int i = 0; i < times.length; i++) {
            adj.get(times[i][0]).add(new int[] {times[i][1], times[i][2]});
        }
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[1] - b[1]);
        pq.add(new int[] {k, 0});
        boolean[] visited = new boolean[n];
        int min = 0;
        while (!pq.isEmpty()) {
            int[] node = pq.poll();
            if (visited[node[0] - 1]) {
                continue;
            }
            min = node[1];
            visited[node[0] - 1] = true;
            for (int[] nei: adj.get(node[0])) {
                if (!visited[nei[0] - 1]) {
                    nei[1] += node[1];
                    pq.add(nei);
                }
            }
        }
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                return -1;
            }
        }
        return min;
    }
}
