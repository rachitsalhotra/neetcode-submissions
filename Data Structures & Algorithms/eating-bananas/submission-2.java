class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int max = 1;
        for (int i = 0; i < piles.length; i++) {
            if (piles[i] > max) {
                max = piles[i];
            }
        }

        int ans = max;
        int l = 1;
        int r = max;
        while (l <= r) {
            int mid = l + ((r - l) / 2);
            int hours = 0;
            for (int j = 0; j < piles.length; j++) {
                hours += Math.ceil(piles[j] / (double) mid);
            }
            if (hours <= h) {
                if (mid < ans) {
                    ans = mid;
                }
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }

        return ans;
    }
}
