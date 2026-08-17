class PrefixTree {
    class TrieNode {
        TrieNode[] children = new TrieNode[26];
        boolean endOfWord = false;
    }

    private TrieNode root;

    public PrefixTree() {
         root = new TrieNode();
    }

    public void insert(String word) {
        TrieNode parent = root;
        for (char c: word.toCharArray()) {
            TrieNode child;
            if (parent.children[c - 'a'] == null) {
                child = new TrieNode();
                parent.children[c - 'a'] = child;
            } else {
                child = parent.children[c - 'a'];
            }
            parent = child;
        }
        parent.endOfWord = true;
    }

    public boolean search(String word) {
        TrieNode parent = root;
        for (char c: word.toCharArray()) {
            parent = parent.children[c - 'a'];
            if (parent == null) {
                return false;
            }
        }
        return parent.endOfWord;
    }

    public boolean startsWith(String prefix) {
        TrieNode parent = root;
        for (char c: prefix.toCharArray()) {
            parent = parent.children[c - 'a'];
            if (parent == null) {
                return false;
            }
        }
        return true;
    }
}
