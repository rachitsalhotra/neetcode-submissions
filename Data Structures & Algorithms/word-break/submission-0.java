class Solution {
    private int[] mem;
    private boolean wordBreak(String s, List<String> wordDict, int index) {
        if (index >= s.length()) {
            return true;
        }
        if (mem[index] != 0) {
            return mem[index] == 1 ? true : false;
        }
        for (String word: wordDict) {
            if (index + word.length() <= s.length() && s.substring(index, index + word.length()).equals(word) && wordBreak(s, wordDict, index + word.length())) {
                mem[index] = 1;
                return true;
            }
        }
        mem[index] = -1;
        return false;
    }
    public boolean wordBreak(String s, List<String> wordDict) {
        mem = new int[s.length()];
        return wordBreak(s, wordDict, 0);
    }
}
