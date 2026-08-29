class Solution {
    private int numDecodings(String s, int i, int[] mem) {
        if (i >= s.length()) {
            return 1;
        }
        if (s.charAt(i) == '0') {
            return 0;
        }
        if (mem[i] != -1) {
            return mem[i];
        }

        int ans = numDecodings(s, i + 1, mem);
        if (i + 1 < s.length() && (s.charAt(i) == '1' || (s.charAt(i) == '2' && s.charAt(i + 1) - '0' < 7))) {
            ans += numDecodings(s, i + 2, mem);
        }
        mem[i] = ans;
        return mem[i];
    }
    public int numDecodings(String s) {
        int[] mem = new int[s.length()];
        Arrays.fill(mem, -1);
        return numDecodings(s, 0, mem);
    }
}
