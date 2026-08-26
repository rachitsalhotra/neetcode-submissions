class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        HashMap<String, List<String>> patterns = new HashMap<>();
        for (String word: wordList) {
            for (int i = 0; i < word.length(); i++) {
                StringBuilder sb = new StringBuilder();
                sb.append(word.substring(0, i));
                sb.append('*');
                sb.append(word.substring(i + 1));
                String key = sb.toString();
                if (patterns.containsKey(key)) {
                    patterns.get(key).add(word);
                } else {
                    List<String> words = new ArrayList<>();
                    words.add(word);
                    patterns.put(key, words);
                }
            }
        }
        int res = 1;
        Queue<String> q = new LinkedList<>();
        Set<String> visited = new HashSet<>();
        q.add(beginWord);
        visited.add(beginWord);
        while(!q.isEmpty()) {
            int size = q.size();
            for (int j = 0; j < size; j++) {
                String word = q.poll();
                for (int i = 0; i < word.length(); i++) {
                    StringBuilder sb = new StringBuilder();
                    sb.append(word.substring(0, i));
                    sb.append('*');
                    sb.append(word.substring(i + 1));
                    String key = sb.toString();
                    if (!patterns.containsKey(key)) {
                        continue;
                    }
                    List<String> neighbours = patterns.get(key);
                    for (String nei: neighbours) {
                        if (nei.equals(word) || visited.contains(nei)) {
                            continue;
                        }
                        if (nei.equals(endWord)) {
                            return res + 1;
                        }
                        q.add(nei);
                        visited.add(nei);
                    }
                }
            }
            res++;
        }
        return 0;
    }
}
