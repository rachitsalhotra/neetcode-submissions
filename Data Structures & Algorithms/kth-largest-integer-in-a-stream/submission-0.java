class KthLargest {
    int capacity;
    PriorityQueue<Integer> pq;

    public KthLargest(int k, int[] nums) {
        pq = new PriorityQueue<>(k);
        capacity = k;

        for (int num : nums) {
            pq.add(num);
            if (pq.size() > k) {
                pq.poll();
            }
        }
    }
    
    public int add(int val) {
        pq.add(val);
        if (pq.size() > capacity) {
            pq.poll();
        }
        return pq.peek();
    }
}
