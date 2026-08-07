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
    private void dfs(TreeNode root, int[] res) {
        if (root == null) {
            return;
        }
        if (res[1] != -1) {
            return;
        }
        dfs(root.left, res);
        if (res[0] == 0) return;
        res[0]--;
        if (res[0] == 0) {
            res[1] = root.val;
            return;
        }
        dfs(root.right, res);
    }
    public int kthSmallest(TreeNode root, int k) {
        int[] res = {k, -1};
        dfs(root, res);
        return res[1];
    }
}
