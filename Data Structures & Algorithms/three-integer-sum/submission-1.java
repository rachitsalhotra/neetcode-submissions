class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<>();

        HashMap<Integer, Integer> count = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            count.put(nums[i], count.getOrDefault(nums[i], 0) + 1);
        }

        for (int i = 0; i < nums.length; i++) {
            count.put(nums[i], count.get(nums[i]) - 1);
            if (i > 0 && nums[i] == nums[i - 1]) continue;
            for (int j = i + 1; j < nums.length; j++) {
                count.put(nums[j], count.get(nums[j]) - 1);
                if (j > i + 1 && nums[j] == nums[j - 1]) continue;
                int target = 0 - nums[i] - nums[j];

                if (count.containsKey(target) && count.get(target) > 0) {
                    List<Integer> triplet = new ArrayList<>();
                    triplet.add(nums[i]);
                    triplet.add(nums[j]);
                    triplet.add(target);
                    ans.add(triplet);
                }
            }

            for (int j = i + 1; j < nums.length; j++) {
                count.put(nums[j], count.get(nums[j]) + 1);
            }
        }

        return ans;
    }
}
