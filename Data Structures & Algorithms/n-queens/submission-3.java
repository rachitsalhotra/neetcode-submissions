class Solution {
    private List<List<String>> res = new ArrayList<>();
    private boolean isValid(int a, int b, List<int[]> curr) {
        for (int[] queen: curr) {
            int i = queen[0];
            int j = queen[1];
            if (i == a || j == b || Math.abs(a - i) == Math.abs(b - j)) {
                return false;
            }
        }
        return true;
    }
    private void solveNQueens(int n, int i, int j, boolean[][] queens, List<int[]> curr) {
        if (n == 0) {
            List<String> row = new ArrayList<>();
            for (int a = 0; a < queens.length; a++) {
                StringBuilder sb = new StringBuilder();
                for (int b = 0; b < queens.length; b++) {
                    char c;
                    if (queens[a][b]) {
                        c = 'Q';
                    } else {
                        c = '.';
                    }
                    sb.append(c);
                }
                row.add(sb.toString());
            }
            res.add(row);
            return;
        }
        for (int a = i; a < queens.length; a++) {
            for (int b = (a == i ? j : 0); b < queens.length; b++) {
                if (!queens[a][b] && isValid(a, b, curr)) {
                    queens[a][b] = true;
                    curr.add(new int[] {a, b});
                    solveNQueens(n - 1, a, b, queens, curr);
                    curr.remove(curr.size() - 1);
                    queens[a][b] = false;
                }
            }
        }
    }
    public List<List<String>> solveNQueens(int n) {
        boolean[][] queens = new boolean[n][n];
        List<int[]> curr = new ArrayList<>();
        solveNQueens(n, 0, 0, queens, curr);
        return res;
    }
}
