class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        Stack<Integer> stack = new Stack<>();
        int[] output = new int[temperatures.length];

        for (int i = 0; i < temperatures.length; i++) {
            int temperature = temperatures[i];
            while (!stack.isEmpty() && temperature > temperatures[stack.peek()]) {
                output[stack.peek()] = i - stack.peek();
                stack.pop();
            }
            stack.push(i);
        }

        return output;
    }
}
