class Solution {
    List<List<Integer>> res;
    private void permute(int[] nums, List<Integer> curr, Set<Integer> currSet) {
        if (curr.size() == nums.length) {
            res.add(new ArrayList<>(curr));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            if (currSet.contains(num)) {
                continue;
            }
            currSet.add(num);
            curr.add(num);
            permute(nums, curr, currSet);
            curr.remove(curr.size() - 1);
            currSet.remove(num);
        }
    }
    public List<List<Integer>> permute(int[] nums) {
        res = new ArrayList<>();
        permute(nums, new ArrayList<>(), new HashSet<>());
        return res;
    }
}
