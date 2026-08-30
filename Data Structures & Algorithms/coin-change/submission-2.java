class Solution {
    private HashMap<Integer, Integer> amountCoins;
    private int coinChange(int[] coins, int amount, int min) {
        if (amount == 0) {
            return 0;
        }
        if (amount < 0) {
            return min;
        }
        if (amountCoins.containsKey(amount)) {
            return amountCoins.get(amount);
        }
        for (int i = 0; i < coins.length; i++) {
            int res = coinChange(coins, amount - coins[i], Integer.MAX_VALUE);
            if (res == Integer.MAX_VALUE) {
                continue;
            }
            min = Math.min(min, 1 + res);
        }
        amountCoins.put(amount, min);
        return min;
    }
    public int coinChange(int[] coins, int amount) {
        amountCoins = new HashMap<>();
        int ans = coinChange(coins, amount, Integer.MAX_VALUE);
        return ans == Integer.MAX_VALUE ? -1 : ans;
    }
}
