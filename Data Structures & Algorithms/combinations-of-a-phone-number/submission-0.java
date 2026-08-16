class Solution {
    String[] digitMap = {"abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
    List<String> res;
    private void letterCombinations(String digits, int i, StringBuilder curr) {
        if (i >= digits.length()) {
            if (curr.length() > 0) {
                res.add(curr.toString());
            }
            return;
        }
        String chars = digitMap[digits.charAt(i) - '2'];
        for (char c: chars.toCharArray()) {
            curr.append(c);
            letterCombinations(digits, i + 1, curr);
            curr.deleteCharAt(curr.length() - 1);
        }
    }
    public List<String> letterCombinations(String digits) {
        res = new ArrayList<>();
        letterCombinations(digits, 0, new StringBuilder());
        return res;
    }
}
