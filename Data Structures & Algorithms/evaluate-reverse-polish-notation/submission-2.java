class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();

        int idx = 0;
        while (idx < tokens.length) {
            String token = tokens[idx];
            if (token.equals("+")) {
                int n1 = stack.pop();
                int n2 = stack.pop();
                stack.push(n1 + n2);
            } else if (token.equals("*")) {
                int n1 = stack.pop();
                int n2 = stack.pop();
                stack.push(n1 * n2);
            } else if (token.equals("-")) {
                int n1 = stack.pop();
                int n2 = stack.pop();
                stack.push(n2 - n1);
            } else if (token.equals("/")) {
                int n1 = stack.pop();
                int n2 = stack.pop();
                stack.push(n2 / n1);
            } else {
                stack.push(Integer.parseInt(token));
            }
            idx++;
        }

        return stack.pop();
    }
}
