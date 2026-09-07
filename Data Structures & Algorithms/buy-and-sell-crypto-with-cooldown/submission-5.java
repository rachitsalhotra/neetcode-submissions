class Solution {
    private int[][] mem;
    private int maxProfit(int[] prices, int i, int buyIndex) {
        if (i >= prices.length) {
            return 0;
        }
        if (buyIndex == -1) {
            if (mem[i][prices.length] != 0) {
                return mem[i][prices.length];
            }
        } else {
            if (mem[i][buyIndex] != 0) {
                return mem[i][buyIndex];
            }
        }
        int cooldown = maxProfit(prices, i + 1, buyIndex);
        if (buyIndex == -1) {
            int buy = maxProfit(prices, i + 1, i);
            mem[i][prices.length] = Math.max(buy, cooldown);
            return mem[i][prices.length];
        } else {
            int sell = prices[i] - prices[buyIndex] + maxProfit(prices, i + 2, -1);
            mem[i][buyIndex] = Math.max(sell, cooldown);
            return mem[i][buyIndex];
        }
    }
    public int maxProfit(int[] prices) {
        mem = new int[prices.length][prices.length + 1];
        return maxProfit(prices, 0, -1);
    }
}
