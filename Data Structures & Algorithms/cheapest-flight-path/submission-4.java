class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        List<List<int[]>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }
        for (int[] f : flights) {
            adj.get(f[0]).add(new int[]{f[1], f[2]});
        }
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> Integer.compare(a[0], b[0]));
        pq.add(new int[]{0, src, 0});
        int[] minStopsSeen = new int[n];
        Arrays.fill(minStopsSeen, Integer.MAX_VALUE);
        while (!pq.isEmpty()) {
            int[] node = pq.poll();
            int cost = node[0], city = node[1], stopsUsed = node[2];
            if (city == dst) {
                return cost;   // pq is cost-ordered: first pop of dst is the cheapest valid arrival
            }
            if (stopsUsed > k || stopsUsed >= minStopsSeen[city]) {
                continue;      // can't expand further from here
            }
            minStopsSeen[city] = stopsUsed;
            for (int[] nei : adj.get(city)) {
                pq.add(new int[]{cost + nei[1], nei[0], stopsUsed + 1});
            }
        }
        return -1;
    }
}