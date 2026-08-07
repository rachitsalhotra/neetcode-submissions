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
    private int[] isValidBSTHelper(TreeNode root) {
        if (root == null) {
            return new int[]{Integer.MAX_VALUE, Integer.MIN_VALUE, 1};
        }
        int[] left = isValidBSTHelper(root.left);
        int[] right = isValidBSTHelper(root.right);
        int leftMin = left[0], leftMax = left[1];
        int rightMin = right[0], rightMax = right[1];
        int isValid = (left[2] == 1 && right[2] == 1 && leftMax < root.val && rightMin > root.val) ? 1 : 0;
        return new int[] {Math.min(leftMin, root.val), Math.max(rightMax, root.val), isValid};
    }
    public boolean isValidBST(TreeNode root) {
        return isValidBSTHelper(root)[2] == 1;
    }
}
