class Solution {
    public boolean canJump(int[] nums) {
        int n = nums.length;
        boolean[] reaches = new boolean[n];
        reaches[n - 1] = true;
        for (int i = n - 2; i >= 0; i--) {
            int num = nums[i];
            for (int j = 1; j <= num; j++) {
                if (reaches[i + j]) {
                    reaches[i] = true;
                    break;
                }
            }
        }
        return reaches[0];
    }
}
