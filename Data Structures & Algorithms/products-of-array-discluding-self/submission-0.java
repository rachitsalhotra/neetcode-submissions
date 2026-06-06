class Solution {
    public int[] productExceptSelf(int[] nums) {
        int prod = 1;
        int prodWithoutZero = 1;
        int numZeroes = 0;

        for (int i = 0; i < nums.length; i++) {
            prod *= nums[i];
            if (nums[i] != 0) {
                prodWithoutZero *= nums[i];
            } else {
                numZeroes++;
            }
        }

        int[] ans = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                ans[i] = numZeroes == 1 ? prodWithoutZero : 0;
            } else {
                ans[i] = prod/nums[i];
            }
        }
        return ans;
    }
}  
