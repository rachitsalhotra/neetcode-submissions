class Solution {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        int[] count = new int[26];
        for (int i = 0; i < s.length(); i++) {
            int n = s.charAt(i) - 'a';
            count[n]++;
        }
        for (int i = 0; i < t.length(); i++) {
            int n = t.charAt(i) - 'a';
            count[n]--;
        }
        for (int i = 0; i < 26; i++) {
            if (count[i] != 0) {
                return false;
            }
        }
        return true;
    }
}
