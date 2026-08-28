class Solution {
    private int dp(int[] nums, int start, int end) {
        int[] dp = new int[nums.length - 1];
        dp[0] = nums[start];
        dp[1] = Math.max(nums[start], nums[start + 1]);
        for (int i = start + 2, j = 2; i <= end; i++, j++) {
            dp[j] = Math.max(dp[j - 1], nums[i] + dp[j - 2]);
        }
        return dp[dp.length - 1];
    }
    public int rob(int[] nums) {
        if (nums.length <= 3) {
            int max = 0;
            for (int i = 0; i < nums.length; i++) {
                max = Math.max(max, nums[i]);
            }
            return max;
        }
        return Math.max(dp(nums, 0, nums.length - 2), dp(nums, 1, nums.length - 1));
    }
}
