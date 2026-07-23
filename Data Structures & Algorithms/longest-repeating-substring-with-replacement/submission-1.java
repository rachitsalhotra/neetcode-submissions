class Solution {
    public int characterReplacement(String s, int k) {
        int max = 1;
        int arr[] = new int[26];
        int l = 0;
        int r = 0;
        int maxFreq = 0;
        char c2 = s.charAt(r);
        arr[c2 - 'A']++;
        if (arr[c2 - 'A'] > maxFreq) {
            maxFreq = arr[c2 - 'A'];
        }
        
        while (l <= r && r < s.length()) {
            

            int len = r - l + 1;
            System.out.println(len);
            if (len - maxFreq > k) {
                char c1 = s.charAt(l);
                arr[c1 - 'A']--;
                l++;
            } else {
                if (len > max) {
                    max = len;
                }
                r++;
                if (r < s.length()) {
                    char c = s.charAt(r);
                    arr[c - 'A']++;
                    if (arr[c - 'A'] > maxFreq) {
                        maxFreq = arr[c - 'A'];
                    }
                }
            }
        }

        return max;
    }
}
