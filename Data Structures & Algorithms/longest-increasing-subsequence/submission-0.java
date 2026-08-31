class Solution {
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        dp[n - 1] = 1;
        int res = 1;

        for (int i = n - 2; i >= 0; i--) {
            int max = 1;
            for (int j = i + 1; j < n; j++) {
                if (nums[i] < nums[j]) {
                    max = Math.max(max, 1 + dp[j]);
                }
            }
            dp[i] = max;
            res = Math.max(res, max);
        }

        return res;
    }
}
