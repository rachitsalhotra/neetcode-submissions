class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> Integer.compare(b, a));
        for (int stone: stones) {
            pq.offer(stone);
        }
        while (pq.size() > 1) {
            int n1 = pq.poll();
            int n2 = pq.poll();
            if (n1 - n2 != 0) {
                pq.offer(n1 - n2);
            }
        }
        return pq.isEmpty() ? 0 : pq.poll();
    }
}
