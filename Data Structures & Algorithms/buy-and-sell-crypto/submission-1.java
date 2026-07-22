class Solution {
    public int maxProfit(int[] prices) {
        if (prices.length < 2) {
            return 0;
        }

        int b = prices[0];
        int maxProfit = 0;

        for (int i = 1; i < prices.length; i++) {
            int s = prices[i];
            if (b > s) {
                b = s;
                continue;
            }
            int profit = s - b;

            if (profit > maxProfit) {
                maxProfit = profit;
            }
        }

        return maxProfit;
    }
}
