class Solution {
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<int[]> pq = new PriorityQueue<>(k, (a, b) -> Integer.compare(b[1], a[1]));
        for (int i = 0; i < points.length; i++) {
            pq.add(new int[] {i, (points[i][0] * points[i][0]) + (points[i][1] * points[i][1])});
            if (pq.size() > k) {
                pq.poll();
            }
        }
        int i = 0;
        int[][] output = new int[k][2];
        while (!pq.isEmpty()) {
            int index = pq.poll()[0];
            output[i][0] = points[index][0];
            output[i++][1] = points[index][1];
        }
        return output;
    }
}
