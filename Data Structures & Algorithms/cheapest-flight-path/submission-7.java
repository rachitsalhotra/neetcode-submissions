class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        List<List<int[]>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }
        for (int i = 0; i < flights.length; i++) {
            adj.get(flights[i][0]).add(new int[] {flights[i][1], flights[i][2]});
        }
        int[] stops = new int[n];
        Arrays.fill(stops, n);
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> Integer.compare(a[0], b[0]));
        pq.add(new int[] {0, src, 0});
        while (!pq.isEmpty()) {
            int[] node = pq.poll();
            if (node[1] == dst) {
                return node[0];
            }
            if (node[2] > k || node[2] >= stops[node[1]]) {
                continue;
            }
            stops[node[1]] = node[2];
            for (int[] nei: adj.get(node[1])) {
                pq.add(new int[] {nei[1] + node[0], nei[0], node[2] + 1});
            }
        }
        return -1;
    }
}