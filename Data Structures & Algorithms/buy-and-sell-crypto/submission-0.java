class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int[] leftMin = new int[n];

        int min = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            leftMin[i] = Math.min(min, prices[i]);
        }

        int res = 0;
        int max = Integer.MIN_VALUE;
        for (int i = n - 1; i >= 0; i--) {
            max = Math.max(max, prices[i]);
            int profit = max - leftMin[i];
            if (profit > res) {
                res = profit;
            }
        }

        return res;
    }
}
