class Solution {
    public int trap(int[] height) {
        if (height.length == 0) {
            return 0;
        }

        int sum = 0;
        Stack<Integer> s = new Stack<>();

        for (int i = 0; i < height.length; i++) {
            while (!s.isEmpty() && height[i] >= height[s.peek()]) {
                int mid = height[s.pop()];
                if (!s.isEmpty()) {
                    int right = height[i];
                    int left = height[s.peek()];

                    int h = Math.min(left, right) - mid;
                    int w = i - s.peek() - 1;

                    sum += h * w;
                }
            }
            s.push(i);
        }

        return sum;
    }
}
