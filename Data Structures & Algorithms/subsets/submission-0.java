class Solution {
    private List<List<Integer>> subsets(int[] nums, int i, List<Integer> subset) {
        if (i >= nums.length) {
            List<List<Integer>> res = new ArrayList<>();
            res.add(subset);
            return res;
        }
        List<Integer> subsetDouble = new ArrayList<>(subset);
        subsetDouble.add(nums[i]);
        List<List<Integer>> subsetList1 = subsets(nums, i + 1, subset);
        List<List<Integer>> subsetList2 = subsets(nums, i + 1, subsetDouble);
        subsetList1.addAll(subsetList2);
        return subsetList1;
    }

    public List<List<Integer>> subsets(int[] nums) {
        return subsets(nums, 0, new ArrayList<>());
    }
}
