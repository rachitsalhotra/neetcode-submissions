class Solution {
    public int findMin(int[] nums) {
        if (nums.length == 2) {
            return Math.min(nums[0], nums[1]);
        }
        int l = 0;
        int r = nums.length - 1;
        // 4,5,6,7
        // 0,1,2,3

        while (r - l > 1) {
            int mid = l + ((r - l) / 2);
            boolean change = false;

            if (nums[l] > nums[mid]) {
                r = mid;
                change = true;
            }

            if (nums[mid] > nums[r]) {
                l = mid;
                change = true;
            }

            if (!change) {
                return nums[0];
            }
        }

        return nums[r];
    }
}
