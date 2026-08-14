class Solution {
    public List<String> generateParenthesis(int n) {
        Set<String> current = new HashSet<>();
        current.add("()");
        for (int round = 1; round < n; round++) {
            Set<String> next = new HashSet<>();
            for (String s : current) {
                for (int pos = 0; pos <= s.length(); pos++) {
                    next.add(s.substring(0, pos) + "()" + s.substring(pos));
                }
            }
            current = next;
        }
        return new ArrayList<>(current);
    }
}
