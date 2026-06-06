class Solution {

    public String encode(List<String> strs) {
        StringBuilder sb = new StringBuilder();
        for (String s: strs) {
            sb.append(s.length()).append("#").append(s);
        }
        return sb.toString();
    }

    public List<String> decode(String str) {
        List<String> ans = new ArrayList<>();

        for (int i = 0; i < str.length();) {
            StringBuilder numS = new StringBuilder();
            while (str.charAt(i) != '#') {
                numS.append(str.charAt(i));
                i++;
            }
            i++;
            int len = Integer.parseInt(numS.toString());
            ans.add(str.substring(i, i + len));
            i += len;
        }

        return ans;
    }
}
