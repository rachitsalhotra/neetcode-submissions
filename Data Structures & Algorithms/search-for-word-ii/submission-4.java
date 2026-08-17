class TrieNode {
    TrieNode[] children = new TrieNode[26];
    int numWords = 0;
    boolean endOfWord = false;

    public void insert(String word) {
        TrieNode parent = this;
        parent.numWords++;
        for (char c: word.toCharArray()) {
            int i = c - 'a';
            if (parent.children[i] == null) {
                parent.children[i] = new TrieNode();
            }
            parent = parent.children[i];
            parent.numWords++;
        }
        parent.endOfWord = true;
    }
}
class Solution {
    List<String> res = new ArrayList<>();
    private int findWords(char[][] board, int i, int j, StringBuilder curr, TrieNode root) {
        if (i < 0 || j < 0 || i >= board.length || j >= board[0].length || board[i][j] == '*' || root.children[board[i][j] - 'a'] == null) {
            return 0;
        }
        char c = board[i][j];
        curr.append(c);
        board[i][j] = '*';
        int found = 0;
        if (root.children[c - 'a'].endOfWord) {
            res.add(curr.toString());
            root.children[c - 'a'].endOfWord = false;
            found++;
        }
        TrieNode parent = root;
        root = root.children[c - 'a'];

        found += findWords(board, i + 1, j, curr, root);
        found += findWords(board, i - 1, j, curr, root);
        found += findWords(board, i, j + 1, curr, root);
        found += findWords(board, i, j - 1, curr, root);

        curr.deleteCharAt(curr.length() - 1);
        board[i][j] = c;
        root.numWords -= found;
        if (root.numWords == 0) {
            parent.children[c - 'a'] = null;
        }

        return found;
    }
    public List<String> findWords(char[][] board, String[] words) {
        TrieNode root = new TrieNode();
        for (String word: words) {
            root.insert(word);
        }
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                root.numWords -= findWords(board, i, j, new StringBuilder(), root);
            }
        }
        return res;
    }
}
