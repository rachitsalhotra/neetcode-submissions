class Solution {
    private int maxProductHelper(int[] nums) {
        int prod1 = 1;
        int prod2 = 1;
        int max = Integer.MIN_VALUE;
        boolean updatedP1 = false;
        boolean updatedP2 = false;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] <= 0) {
                if (updatedP1) {
                    max = Math.max(max, prod1);
                }
                if (updatedP2) {
                    max = Math.max(max, prod2);
                }
                prod2 *= nums[i];
                prod1 = 1;
                updatedP2 = true;
                continue;
            }
            prod1 *= nums[i];
            prod2 *= nums[i];
            updatedP1 = true;
        }
        if (updatedP1) {
            max = Math.max(max, prod1);
        }
        if (updatedP2) {
            max = Math.max(max, prod2);
        }
        return max;
    }
    public int maxProduct(int[] nums) {
        return Math.max(maxProductHelper(nums), maxProductHelper(IntStream.range(0, nums.length)
                                  .map(i -> nums[nums.length - 1 - i])
                                  .toArray()));
    }
}
