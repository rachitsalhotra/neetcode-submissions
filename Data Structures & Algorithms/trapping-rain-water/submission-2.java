class Solution {
    public int trap(int[] height) {
        Stack<Integer> s = new Stack<>();

        int total = 0;
        int top = 0;
        for (int i = 0; i < height.length; i++) {
            int num = height[i];
            if (num >= top) {
                int counter = 0;
                int block = 0;
                while (!s.isEmpty()) {
                    int n = s.pop();
                    if (n == top) {
                        break;
                    }
                    block += n;
                    counter++;
                }
                total = total + (counter * Math.min(num, top)) - block;
                top = num;
            }
            s.push(num);
        }

        int size = s.size();
        s.clear();

        top = 0;
        for (int i = height.length - 1; (i >= height.length - 1 - size) && i >= 0; i--) {
            int num = height[i];
            if (num >= top) {
                int counter = 0;
                int block = 0;
                while (!s.isEmpty()) {
                    int n = s.pop();
                    if (n == top) {
                        break;
                    }
                    block += n;
                    counter++;
                }
                total = total + (counter * Math.min(num, top)) - block;
                top = num;
            }
            s.push(num);
        }

        return total;
    }
}
