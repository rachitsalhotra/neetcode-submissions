class Solution {
    public int largestRectangleArea(int[] heights) {
        // [7,4,7,2,1,2,4]

        Stack<Integer> stack = new Stack<>();
        int res[] = new int[heights.length];

        for (int i = 0; i < heights.length; i++) {
            while (!stack.isEmpty() && heights[stack.peek()] > heights[i]) {
                int index = stack.pop();
                int cal = heights[index] * (i - index - 1);
                res[index] += cal;
            }
            stack.push(i);
        }

        while (!stack.isEmpty()) {
            int index = stack.pop();
            int cal = heights[index] * (heights.length - index - 1);
            res[index] += cal;
        }

        for (int i = heights.length - 1; i >= 0; i--) {
            while (!stack.isEmpty() && heights[stack.peek()] >= heights[i]) {
                int index = stack.pop();
                int cal = heights[index] * (index - i);
                res[index] += cal;
            }
            stack.push(i);
        }

        while (!stack.isEmpty()) {
            int index = stack.pop();
            int cal = heights[index] * (index + 1);
            res[index] += cal;
        }

        int max = 0;

        for (int i = 0; i < res.length; i++) {
            max = Math.max(res[i], max);
        }

        return max;
    }
}