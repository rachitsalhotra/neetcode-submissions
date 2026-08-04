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
    class Pair<T, V> {
        T height;
        V balanced;
        public Pair(T height, V balanced) {
            this.height = height;
            this.balanced = balanced;
        }
    }
    private Pair dfs(TreeNode root) {
        if (root == null) {
            return new Pair<Integer, Boolean>(0, true);
        }
        Pair<Integer, Boolean> left = dfs(root.left);
        Pair<Integer, Boolean> right = dfs(root.right);
        int diff = Math.abs(left.height - right.height);
        return new Pair<Integer, Boolean>(1 + Math.max(left.height, right.height), diff <= 1 && left.balanced && right.balanced);
    }

    public boolean isBalanced(TreeNode root) {
        return (boolean) dfs(root).balanced;
    }
}
