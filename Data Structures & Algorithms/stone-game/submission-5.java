class Solution {
    private int[][] mem;
    private int stoneGame(int[] piles, int i, int j, boolean aliceTurn) {
        if (i > j) {
            return 0;
        }
        if (mem[i][j] != 0) {
            return mem[i][j];
        }
        int sum1 = stoneGame(piles, i + 1, j, !aliceTurn);
        int sum2 = stoneGame(piles, i, j - 1, !aliceTurn);
        if (aliceTurn) {
            sum1 += piles[i];
            sum2 += piles[j];
        }
        mem[i][j] = Math.max(sum1, sum2);
        return mem[i][j];
    }
    public boolean stoneGame(int[] piles) {
        mem = new int[piles.length][piles.length];
        int sum = Arrays.stream(piles).sum();
        int alice = stoneGame(piles, 0, piles.length - 1, true);
        int bob = sum - alice;
        return alice > bob ? true : false;
    }
}