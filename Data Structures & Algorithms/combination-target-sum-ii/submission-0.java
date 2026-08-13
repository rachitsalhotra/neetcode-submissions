class Solution {
    private void combinationSum2(int[] candidates, int target, List<List<Integer>> res, List<Integer> numList, int i) {
        if (target == 0) {
            res.add(new ArrayList<>(numList));
            return;
        }
        if (i >= candidates.length) {
            return;
        }
        if (target - candidates[i] >= 0) {
            numList.add(candidates[i]);
            combinationSum2(candidates, target - candidates[i], res, numList, i + 1);
            numList.remove(numList.size() - 1);
        }
        while (i < candidates.length - 1 && candidates[i] == candidates[i + 1]) {
            i++;
        }
        combinationSum2(candidates, target, res, numList, i + 1);
    }
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(candidates);
        combinationSum2(candidates, target, res, new ArrayList<>(), 0);
        return res;
    }
}
