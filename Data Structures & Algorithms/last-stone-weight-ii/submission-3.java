class Solution {
    private HashMap<String, Integer> mem = new HashMap<>();
    private int lastStoneWeightII(int[] stones, int i, int sum, int target) {
        if (i >= stones.length) {
            return target - sum < 0 ? Integer.MIN_VALUE : sum;
        }
        String key = sum + "#" + i;
        if (mem.containsKey(key)) {
            return mem.get(key);
        }
        int res1 = lastStoneWeightII(stones, i + 1, sum + stones[i], target);
        int res2 = lastStoneWeightII(stones, i + 1, sum, target);
        mem.put(key, Math.max(res1, res2));
        return mem.get(key);
    }
    public int lastStoneWeightII(int[] stones) {
        int sum = Arrays.stream(stones).sum();
        return sum - 2 * lastStoneWeightII(stones, 0, 0, sum / 2);
    }
}