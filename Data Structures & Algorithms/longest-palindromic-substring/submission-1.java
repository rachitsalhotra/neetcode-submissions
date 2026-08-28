class Solution {
    public String longestPalindrome(String s) {
        // 1,0,1,0,0
        // 0,1,0,1,0
        // 0,0,1,0,0
        // 0,0,0,1,0
        // 0,0,0,0,1

        // 1,1,1,0
        // 0,1,0,1
        // 0,0,1,0
        // 0,0,0,1

        int n = s.length();
        boolean[][] dp = new boolean[n][n];
        int max = 1;
        int r = 0;
        int c = 0;
        for (int i = 0; i < n; i++) {
            dp[i][i] = true;
        }
        for (int i = n - 2; i >= 0; i--) {
            for (int j = i + 1; j < n; j++) {
                dp[i][j] = s.charAt(j) == s.charAt(i) && (i + 1 > j - 1 || dp[i + 1][j - 1]);
                if (dp[i][j] && j - i + 1 > max) {
                    max = j - i + 1;
                    r = i;
                    c = j;
                }
            }
        }
        return s.substring(r, c + 1);
    }
}
