class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int[] res = new int[nums.length - k + 1];
        HashMap<Integer, Integer> map = new HashMap<>();
        
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < k; i++) {
            if (nums[i] > max) {
                max = nums[i];
            }
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }
        System.out.println(map);
        
        int ctr = 0;
        res[ctr++] = max;
        for (int i = k; i < nums.length; i++) {
            if (nums[i] >= max) {
                max = nums[i];
            } else if (nums[i - k] == max && map.get(nums[i - k]) == 1) {
                // find max again
                max = Integer.MIN_VALUE;
                for (int j = i; j > i - k; j--) {
                    if (nums[j] > max) {
                        max = nums[j];
                    }
                }
            }

            int freq = map.getOrDefault(nums[i - k], 0) - 1;
            if (freq == 0) {
                map.remove(nums[i - k]);
            } else {
                map.put(nums[i - k], freq);
            }
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);

            res[ctr++] = max;

            System.out.println(map);
        }

        return res;
    }
}
