class Solution {
    public int longestConsecutive(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }

        Arrays.sort(nums);
        System.out.println(Arrays.toString(nums));
        int max = 1;
        int maxTillNow = 1;

        for (int i = 1; i < nums.length; i++) {
            System.out.println(maxTillNow);
            if (nums[i] - nums[i - 1] == 1) {
                maxTillNow++;
            } else if (nums[i] - nums[i - 1] == 0) {
                continue;
            } else {
                if (maxTillNow > max) {
                    max = maxTillNow;
                }
                maxTillNow = 1;
            }
        }

        if (maxTillNow > max) {
            max = maxTillNow;
        }

        return max;
    }
}
