class Solution {
    private boolean isPalindrome(String s) {
        StringBuilder sb = new StringBuilder(s);
        return sb.toString().equals(sb.reverse().toString());
    }
    private void partition(String s, int l, int r, List<String> curr, List<List<String>> res) {
        if (r == s.length()) {
            if (isPalindrome(s.substring(l, r))) {
                curr.add(s.substring(l, r));
                res.add(new ArrayList<>(curr));
                curr.remove(curr.size() - 1);
            }
            return;
        }
        if (isPalindrome(s.substring(l, r))) {
            curr.add(s.substring(l, r));
            partition(s, r, r + 1, curr, res);
            curr.remove(curr.size() - 1);
        }
        partition(s, l, r + 1, curr, res);
    }
    public List<List<String>> partition(String s) {
        List<List<String>> res = new ArrayList<>();
        partition(s, 0, 1, new ArrayList<>(), res);
        return res;
    }
}
