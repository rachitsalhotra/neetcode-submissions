public class TrieNode {
    TrieNode[] children = new TrieNode[26];
    boolean endOfWord = false;
}
class WordDictionary {
    private TrieNode root;

    public WordDictionary() {
        root = new TrieNode();
    }

    public void addWord(String word) {
        TrieNode parent = root;
        for (char c: word.toCharArray()) {
            int i = c - 'a';
            if (parent.children[i] == null) {
                parent.children[i] = new TrieNode();
            }
            parent = parent.children[i];
        }
        parent.endOfWord = true;
    }

    private boolean search(String word, TrieNode parent) {
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (c == '.') {
                for (TrieNode child: parent.children) {
                    if (child == null) {
                        continue;
                    }
                    boolean res = search(word.substring(i + 1), child);
                    if (res) {
                        return true;
                    }
                }
                return false;
            } else {
                if (parent.children[c - 'a'] == null) {
                    return false;
                }
                parent = parent.children[c - 'a'];
            }
        }
        return parent.endOfWord;
    }

    public boolean search(String word) {
        return search(word, root);
    }
}
