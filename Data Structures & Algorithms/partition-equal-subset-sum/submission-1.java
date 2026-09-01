class Solution {
    private int[][] mem;
    private boolean canPartition(int[] nums, int start, int target) {
        if (target == 0) {
            return true;
        }
        if (target < 0 || start >= nums.length) {
            return false;
        }
        if (mem[start][target] != 0) {
            return mem[start][target] == 1 ? true : false;
        }
        if (canPartition(nums, start + 1, target - nums[start]) || canPartition(nums, start + 1, target)) {
            mem[start][target] = 1;
            return true;
        }
        mem[start][target] = -1;
        return false;
    }
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for (int num: nums) {
            sum += num;
        }
        if (sum % 2 == 1) {
            return false;
        }
        sum = sum / 2;
        mem = new int[nums.length][sum + 1];
        return canPartition(nums, 0, sum);
    }
}
