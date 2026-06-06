class Solution {

    public boolean isValidBox(int sr, int er, int sc, int ec, HashMap<Character, Boolean> map, char[][] board) {
        for (int i = sr; i < er; i++) {
            for (int j = sc; j < ec; j++) {
                char c = board[i][j];
                if (map.get(c) != null) {
                    return false;
                }
                if (c != '.') {
                    map.put(c, true);
                }
            }
        }
        map.clear();
        return true;
    }

    public boolean isValidSudoku(char[][] board) {
        HashMap<Character, Boolean> map = new HashMap<>();

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                char c = board[i][j];
                if (map.get(c) != null) {
                    return false;
                }
                if (c != '.') {
                    map.put(c, true);
                }
            }
            map.clear();
        }

        for (int j = 0; j < 9; j++) {
            for (int i = 0; i < 9; i++) {
                char c = board[i][j];
                if (map.get(c) != null) {
                    return false;
                }
                if (c != '.') {
                    map.put(c, true);
                }
            }
            map.clear();
        }

        return isValidBox(0, 3, 0, 3, map, board) && isValidBox(3, 6, 0, 3, map, board) && isValidBox(6, 9, 0, 3, map, board) && isValidBox(0, 3, 3, 6, map, board) && isValidBox(0, 3, 6, 9, map, board) && isValidBox(3, 6, 3, 6, map, board) && isValidBox(3, 6, 6, 9, map, board) && isValidBox(6, 9, 3, 6, map, board) && isValidBox(6, 9, 6, 9, map, board);
    }
}
