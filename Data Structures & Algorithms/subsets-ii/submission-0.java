class Solution {
    List<List<Integer>> res;
    private void subsetsWithDup(int[] nums, List<Integer> curr, int i) {
        if (i >= nums.length) {
            res.add(new ArrayList<>(curr));
            return;
        }
        curr.add(nums[i]);
        subsetsWithDup(nums, curr, i + 1);
        curr.remove(curr.size() - 1);
        while (i < nums.length - 1 && nums[i] == nums[i + 1]) {
            i++;
        }
        subsetsWithDup(nums, curr, i + 1);
    }
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        res = new ArrayList<>();
        subsetsWithDup(nums, new ArrayList<>(), 0);
        return res;
    }
}
