class Solution {
    HashMap<String, Boolean> mem = new HashMap<>();
    private boolean isInterleaveHelper(String s1, String s2, String s3) {
        if (s1.isEmpty() && s2.isEmpty() && s3.isEmpty()) {
            return true;
        } else if (s3.isEmpty()) {
            return false;
        } else if (s1.isEmpty()) {
            return s2.equals(s3);
        } else if (s2.isEmpty()) {
            return s1.equals(s3);
        }
        String key = s1.length() + "#" + s2.length();
        if (mem.containsKey(key)) {
            return mem.get(key);
        }
        boolean res = false;
        if (s3.charAt(0) == s1.charAt(0)) {
            res |= isInterleaveHelper(s1.substring(1), s2, s3.substring(1));
        }
        if (s3.charAt(0) == s2.charAt(0)) {
            res |= isInterleaveHelper(s1, s2.substring(1), s3.substring(1));
        }
        mem.put(key, res);
        return res;
    }
    public boolean isInterleave(String s1, String s2, String s3) {
        return isInterleaveHelper(s1, s2, s3);
    }
}
