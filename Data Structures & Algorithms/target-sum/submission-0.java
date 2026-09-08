class Solution {
    private HashMap<String, Integer> mem;
    private int findTargetSumWays(int[] nums, int target, int i) {
        if (i >= nums.length) {
            return target == 0 ? 1 : 0;
        }
        String key = i + "#" + target;
        if (mem.containsKey(key)) {
            return mem.get(key);
        }
        int res = findTargetSumWays(nums, target - nums[i], i + 1);
        res += findTargetSumWays(nums, target + nums[i], i + 1);
        mem.put(key, res);
        return res;
    }
    public int findTargetSumWays(int[] nums, int target) {
        mem = new HashMap<>();
        return findTargetSumWays(nums, target, 0);
    }
}
