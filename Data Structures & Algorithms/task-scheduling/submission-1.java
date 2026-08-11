class Solution {
    public int leastInterval(char[] tasks, int n) {
        int count[] = new int[26];
        for (char c: tasks) {
            count[c - 'A']++;
        }
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for (int cnt: count) {
            if (cnt == 0) {
                continue;
            }
            pq.add(cnt);
        }
        int res = 0;
        Queue<int[]> q = new LinkedList<>();
        while(!pq.isEmpty() || !q.isEmpty()) {
            if (!pq.isEmpty()) {
                int counter = pq.poll() - 1;
                if (counter > 0) {
                    int[] cooler = {res + n, counter};
                    q.offer(cooler);
                }
            }
            if (!q.isEmpty() && q.peek()[0] == res) {
                pq.add(q.poll()[1]);
            }
            res++;
        }
        return res;
    }
}
