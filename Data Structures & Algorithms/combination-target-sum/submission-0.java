class Solution {
    private void combinationSum(int[] nums, int target, List<List<Integer>> res, List<Integer> numList, int i) {
        if (target == 0) {
            res.add(new ArrayList<>(numList));
            return;
        }
        if (i >= nums.length) {
            return;
        }
        if (target - nums[i] >= 0) {
            numList.add(nums[i]);
            combinationSum(nums, target - nums[i], res, numList, i);
            numList.remove(numList.size() - 1);
        }
        combinationSum(nums, target, res, numList, i + 1);
    }
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        List<List<Integer>> res = new ArrayList<>();
        combinationSum(nums, target, res, new ArrayList<>(), 0);
        return res;
    }
}
