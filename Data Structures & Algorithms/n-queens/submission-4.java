class Solution {
    private List<List<String>> res = new ArrayList<>();
    private int len;
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
    private void solveNQueens(int n, int i, int j, List<int[]> curr) {
        if (n == 0) {
            List<StringBuilder> row = new ArrayList<>();
            StringBuilder sb = new StringBuilder();
            for (int b = 0; b < len; b++) {
                sb.append('.');
            }
            for (int a = 0; a < len; a++) {
                row.add(new StringBuilder(sb));
            }
            for (int[] queen: curr) {
                int x = queen[0];
                int y = queen[1];
                row.get(x).setCharAt(y, 'Q');
            }
            List<String> rowStrings = new ArrayList<>();
            for (int k = 0; k < row.size(); k++) {
                rowStrings.add(row.get(k).toString());
            }
            res.add(rowStrings);
            return;
        }
        for (int a = i; a < len; a++) {
            for (int b = (a == i ? j : 0); b < len; b++) {
                if (isValid(a, b, curr)) {
                    curr.add(new int[] {a, b});
                    solveNQueens(n - 1, a, b, curr);
                    curr.remove(curr.size() - 1);
                }
            }
        }
    }
    public List<List<String>> solveNQueens(int n) {
        List<int[]> curr = new ArrayList<>();
        len = n;
        solveNQueens(n, 0, 0, curr);
        return res;
    }
}
