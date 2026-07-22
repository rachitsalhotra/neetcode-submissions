class Solution {
    public int lengthOfLongestSubstring(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        Queue<Character> q = new LinkedList<>();
        int max = 0;
        
        for(int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (map.containsKey(c)) {
                while (q.peek() != c) {
                    char g = q.poll();
                    if (map.get(g) == 1) {
                        map.remove(g);
                    } else {
                        map.put(g, map.get(g) - 1);
                    }
                }
                char h = q.poll();
                if (map.get(h) == 1) {
                    map.remove(h);
                } else {
                    map.put(h, map.get(h) - 1);
                }
            }
            map.put(c, map.getOrDefault(c, 0) + 1);
            q.add(c);
            if (q.size() > max) {
                max = q.size();
            }
        }

        return max;
    }
}
