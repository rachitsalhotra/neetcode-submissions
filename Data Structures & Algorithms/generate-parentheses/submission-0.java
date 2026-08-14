class Solution {
    public List<String> generateParenthesis(int n) {
        List<StringBuilder> res = new ArrayList<>();
        StringBuilder sb = new StringBuilder("()");
        res.add(sb);
        for (int i = 1; i < n; i++) {
            int size = res.size();
            for (int j = 0; j < size; j++) {
                StringBuilder sbD = res.get(j);
                for (int k = 0; k < sbD.length(); k++) {
                    StringBuilder sbN = new StringBuilder(sbD);
                    res.add(sbN.insert(k, "()"));
                }
            }
        }
        Set<String> finalRes = new HashSet<>();
        for (int i = res.size() - 1; i >= 0; i--) {
            if (res.get(i).length() < (n * 2)) {
                break;
            }
            finalRes.add(res.get(i).toString());
        }
        return new ArrayList<>(finalRes);
    }
}
