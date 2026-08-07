/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

class Solution {
    public int[] maxPathSumHelper(TreeNode root) {
        if (root == null) {
            return new int[] {0, Integer.MIN_VALUE};
        }
        int totalSum = 0;
        int[] leftSums = maxPathSumHelper(root.left);
        int[] rightSums = maxPathSumHelper(root.right);
        if (leftSums[0] > 0) {
            totalSum += leftSums[0];
        }
        if (rightSums[0] > 0) {
            totalSum += rightSums[0];
        }
        int max = Math.max(totalSum + root.val, Math.max(leftSums[1], rightSums[1]));
        int sumMax = Math.max(leftSums[0], rightSums[0]);
        int sumTillNow = root.val + (sumMax > 0 ? sumMax : 0);
        return new int[] {sumTillNow, max};
    }
    public int maxPathSum(TreeNode root) {
        return maxPathSumHelper(root)[1];
    }
}
