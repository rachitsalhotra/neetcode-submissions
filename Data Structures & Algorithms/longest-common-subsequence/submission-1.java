class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        int m = text1.length();
        int n = text2.length();
        int[][] dp = new int[m][n];

        for (int i = m - 1; i >= 0; i--) {
            if (text1.charAt(i) == text2.charAt(n - 1)) {
                dp[i][n - 1] = 1;
            } else if (i + 1 < m) {
                dp[i][n - 1] = dp[i + 1][n - 1];
            }
        }

        for (int i = n - 1; i >= 0; i--) {
            if (text2.charAt(i) == text1.charAt(m - 1)) {
                dp[m - 1][i] = 1;
            } else if (i + 1 < n) {
                dp[m - 1][i] = dp[m - 1][i + 1];
            }
        }

        for (int i = m - 2; i >= 0; i--) {
            for (int j = n - 2; j >= 0; j--) {
                if (text1.charAt(i) == text2.charAt(j)) {
                    dp[i][j] = 1 + dp[i + 1][j + 1];
                } else {
                    dp[i][j] = Math.max(dp[i + 1][j], dp[i][j + 1]);
                }
            }
        }

        return dp[0][0];
    }
}
