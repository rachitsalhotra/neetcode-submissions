class Solution {
    public boolean isValid(String s) {
        Stack<Character> st = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (!st.isEmpty() && ((st.peek() == '(' && c == ')') || (st.peek() == '{' && c == '}') || (st.peek() == '[' && c == ']'))) {
                st.pop();
                continue;
            }
            st.push(c);
        }

        return st.isEmpty();
    }
}
