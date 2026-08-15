class Solution {
    private boolean exist(char[][] board, String word, int i, int j, int k, boolean[][] visited) {
        if (k >= word.length()) {
            return true;
        }
        if (i + 1 < board.length && !visited[i + 1][j] && board[i + 1][j] == word.charAt(k)) {
            visited[i + 1][j] = true;
            if (exist(board, word, i + 1, j, k + 1, visited)) {
                return true;
            }
            visited[i + 1][j] = false;
        }
        if (i - 1 >= 0 && !visited[i - 1][j] && board[i - 1][j] == word.charAt(k)) {
            visited[i - 1][j] = true;
            if (exist(board, word, i - 1, j, k + 1, visited)) {
                return true;
            }
            visited[i - 1][j] = false;
        }
        if (j + 1 < board[0].length && !visited[i][j + 1] && board[i][j + 1] == word.charAt(k)) {
            visited[i][j + 1] = true;
            if (exist(board, word, i, j + 1, k + 1, visited)) {
                return true;
            }
            visited[i][j + 1] = false;
        }
        if (j - 1 >= 0 && !visited[i][j - 1] && board[i][j - 1] == word.charAt(k)) {
            visited[i][j - 1] = true;
            if (exist(board, word, i, j - 1, k + 1, visited)) {
                return true;
            }
            visited[i][j - 1] = false;
        }
        return false;
    }
    public boolean exist(char[][] board, String word) {
        boolean[][] visited = new boolean[board.length][board[0].length];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == word.charAt(0)) {
                    visited[i][j] = true;
                    if (exist(board, word, i, j, 1, visited)) {
                        return true;
                    }
                    visited[i][j] = false;
                }
            }
        }
        return false;
    }
}
