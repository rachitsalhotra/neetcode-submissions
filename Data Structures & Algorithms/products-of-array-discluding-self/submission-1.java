class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int prefixProd[] = new int[n];
        int suffixProd[] = new int[n];

        int pre = 1;
        int suf = 1;

        for (int i = 0; i < n; i++) {
            prefixProd[i] = pre;
            pre *= nums[i];
        }

        for (int i = n - 1; i >= 0; i--) {
            suffixProd[i] = suf;
            suf *= nums[i];
        }

        int[] ans = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            ans[i] = prefixProd[i] * suffixProd[i];
        }
        
        return ans;
    }
}  
