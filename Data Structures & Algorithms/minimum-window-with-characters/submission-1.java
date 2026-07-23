class Solution {
    public String minWindow(String s, String t) {
        String ans = "";
        if (t.length() > s.length()) {
            return ans;
        }

        HashMap<Character, Integer> tCount = new HashMap<>();
        HashMap<Character, Integer> sCount = new HashMap<>();

        for (int i = 0; i < t.length(); i++) {
            tCount.put(t.charAt(i), tCount.getOrDefault(t.charAt(i), 0) + 1);
        }

        int l = 0;
        int r = 0;
        int need = tCount.size();
        int curr = 0;
        int min = Integer.MAX_VALUE;

        while (l <= r && r < s.length()) {
            char c = s.charAt(r);
            int freq = sCount.getOrDefault(c, 0) + 1;
            sCount.put(c, freq);

            if (tCount.containsKey(c) && freq == tCount.get(c)) {
                curr++;
            }

            if (curr == need) {
                int len = r - l + 1;
                if (len < min) {
                    min = len;
                    ans = s.substring(l, r + 1);
                }

                while (curr >= need) {
                    char c1 = s.charAt(l);
                    int freq1 = sCount.getOrDefault(c1, 0) - 1;
                    sCount.put(c1, freq1);
                    l++;
                    if (tCount.containsKey(c1) && freq1 < tCount.get(c1)) {
                        curr--;
                    } else {
                        int len1 = r - l + 1;
                        if (len1 < min) {
                            min = len1;
                            ans = s.substring(l, r + 1);
                        }
                    }
                }
            }

            r++;
        }

        return ans;
    }
}
