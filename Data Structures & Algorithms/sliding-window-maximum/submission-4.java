class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int res[] = new int[nums.length - k + 1];
        Deque<Integer> dq = new LinkedList<>();

        int l = 0;
        int r = 0;

        while (r < nums.length) {
            while (!dq.isEmpty() && nums[dq.getLast()] < nums[r]) {
                dq.removeLast();
            }

            dq.addLast(r);

            if (l > dq.getFirst()) {
                dq.removeFirst();
            }

            if ((r + 1) >= k) {
                res[r - k + 1] = nums[dq.getFirst()];
                l++;
            }

            r++;
        }

        return res;
    }
}
