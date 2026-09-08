class Solution {
    private int[][] mem;
    private int maxProfit(int[] prices, int i, boolean buying) {
        if (i >= prices.length) {
            return 0;
        }
        if (buying) {
            if (mem[i][0] != 0) {
                return mem[i][0];
            }
        } else {
            if (mem[i][1] != 0) {
                return mem[i][1];
            }
        }
        int cooldown = maxProfit(prices, i + 1, buying);
        if (buying) {
            int buy = maxProfit(prices, i + 1, false) - prices[i];
            mem[i][0] = Math.max(buy, cooldown);
            return mem[i][0];
        } else {
            int sell = maxProfit(prices, i + 2, true) + prices[i];
            mem[i][1] = Math.max(sell, cooldown);
            return mem[i][1];
        }
    }
    public int maxProfit(int[] prices) {
        mem = new int[prices.length][2];
        return maxProfit(prices, 0, true);
    }
}
