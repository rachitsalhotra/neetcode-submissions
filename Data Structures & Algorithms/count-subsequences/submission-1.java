class Solution {
    private HashMap<String, Integer> mem = new HashMap<>();
    private int numDistinct(String s, String t, StringBuilder sb, int i) {
        if (sb.length() == t.length()) {
            if (sb.toString().equals(t)) {
                return 1;
            }
            return 0;
        }
        if (i >= s.length()) {
            return 0;
        }
        String key = sb.toString() + i;
        if (mem.containsKey(key)) {
            return mem.get(key);
        }
        int res = numDistinct(s, t, new StringBuilder(sb), i + 1) + numDistinct(s, t, new StringBuilder(sb).append(s.charAt(i)), i + 1);
        mem.put(key, res);
        return res;
    }
    public int numDistinct(String s, String t) {
        return numDistinct(s, t, new StringBuilder(), 0);
    }
}
