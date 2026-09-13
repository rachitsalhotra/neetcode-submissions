class Solution {
    public String foreignDictionary(String[] words) {
        int[] ind = new int[26];
        Arrays.fill(ind, -1);
        int n = 0;
        HashMap<Integer, List<Integer>> adj = new HashMap<>();
        for (int i = 0; i < words.length; i++) {
            if (i + 1 < words.length && words[i].length() > words[i + 1].length() && words[i + 1].equals(words[i].substring(0, words[i + 1].length()))) {
                return "";
            }
            for (int k = 0; k < words[i].length(); k++) {
                char c = words[i].charAt(k);
                if (ind[c - 'a'] != -1) {
                    continue;
                }
                ind[c - 'a'] = 0;
                n++;
            }
            int j = 0;
            while (i + 1 < words.length && j < Math.min(words[i].length(), words[i + 1].length())) {
                if (words[i].charAt(j) != words[i + 1].charAt(j)) {
                    adj.computeIfAbsent(words[i].charAt(j) - 'a', k -> new ArrayList<>()).add(words[i + 1].charAt(j) - 'a');
                    break;
                }
                j++;
            }
        }
        for (List<Integer> vals: adj.values()) {
            for (int val: vals) {
                ind[val]++;
            }
        }
        StringBuilder res = new StringBuilder();
        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < 26; i++) {
            if (ind[i] == 0) {
                q.add(i);
                res.append((char) (i + 'a'));
            }
        }
        while(!q.isEmpty()) {
            int key = q.poll();
            if (!adj.containsKey(key)) {
                continue;
            }
            for (int nei: adj.get(key)) {
                ind[nei]--;
                if (ind[nei] == 0) {
                    q.add(nei);
                    res.append((char) (nei + 'a'));
                }
            }
        }
        return res.length() == n ? res.toString() : "";
    }
}
