class Solution {
    public int maxArea(int[] heights) {
        int l = 0;
        int r = heights.length - 1;
        int max = 0;

        while (l < r) {
            int prod = Math.min(heights[l], heights[r]) * (r - l);
            if (prod > max) {
                max = prod;
            }
            if (heights[l] > heights[r]) {
                r--;
            } else {
                l++;
            }
        }

        return max;
    }
}
