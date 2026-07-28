class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int n = matrix.length;
        int m = matrix[0].length;

        int row = -1;
        int lr = 0;
        int rr = n - 1;

        while (lr <= rr) {
            int mid = lr + ((rr - lr) / 2);

            if (target > matrix[mid][0]) {
                if (target <= matrix[mid][m - 1]) {
                    row = mid;
                    break;
                }
                lr = mid + 1;
            } else if (target < matrix[mid][0]) {
                rr = mid - 1;
            } else {
                return true;
            }
        }

        if (row == -1) {
            return false;
        }

        int lc = 0;
        int rc = m - 1;

        while (lc <= rc) {
            int mid = lc + ((rc - lc) / 2);

            if (target > matrix[row][mid]) {
                lc = mid + 1;
            } else if (target < matrix[row][mid]) {
                rc = mid - 1;
            } else {
                return true;
            }
        }

        return false;
    }
}
