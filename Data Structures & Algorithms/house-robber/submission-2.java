class Solution {
    public int rob(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }
        for (int i = 2; i < nums.length; i++) {
            int max = i > 2 ? Math.max(nums[i - 2], nums[i - 3]) : nums[i - 2];
            nums[i] += max;
        }
        return Math.max(nums[nums.length - 1], nums[nums.length - 2]);
    }
}
