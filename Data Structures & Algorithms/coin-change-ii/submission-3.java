class Solution {
    private int[][] mem;
    private int change(int amount, int[] coins, int si) {
        if (amount == 0) {
            return 1;
        }
        if (si >= coins.length || coins[si] > amount) {
            return 0;
        }
        if (mem[si][amount] != -1) {
            return mem[si][amount];
        }
        int res = 0;
        for (int i = si; i < coins.length; i++) {
            int newAmount = amount - coins[i];
            if (newAmount < 0) {
                continue;
            }
            res += change(newAmount, coins, i);
        }
        mem[si][amount] = res;
        return res;
    }
    public int change(int amount, int[] coins) {
        Arrays.sort(coins);
        mem = new int[coins.length][amount + 1];
        for (int[] row: mem) {
            Arrays.fill(row, -1);
        }
        return change(amount, coins, 0);
    }
}
