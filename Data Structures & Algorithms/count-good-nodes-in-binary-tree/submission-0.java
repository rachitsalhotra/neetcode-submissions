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
    private int goodNodes(TreeNode root, int max) {
        if (root == null) {
            return 0;
        }
        if (root.val >= max) {
            max = Math.max(max, root.val);
            return 1 + goodNodes(root.left, max) + goodNodes(root.right, max);
        } else {
            return goodNodes(root.left, max) + goodNodes(root.right, max);
        }
    }

    public int goodNodes(TreeNode root) {
        return goodNodes(root, root.val);
    }
}
